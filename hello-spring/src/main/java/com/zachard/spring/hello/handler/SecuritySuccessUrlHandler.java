/*
 *  Copyright 2015-2017 zachard, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.zachard.spring.hello.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.zachard.spring.hello.constant.SecurityConstant;

/**
 * Spring 安全 -- 自定义登录成功的URL处理器
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Component
public class SecuritySuccessUrlHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(SecuritySuccessUrlHandler.class);
	
	/**
	 * 重定向策略
	 */
	@Resource
	private RedirectStrategy redirectStrategy;
	
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, 
			Authentication authentication) throws IOException {
		
		if (response.isCommitted()) {
			logger.info("响应已提交,无法重定向");
			return;
		}
		
		redirectStrategy.sendRedirect(request, response, determineTargetUrl(authentication));
	}
	
	/**
	 * 根据登录用户角色决定登录成功后的目标URL
	 * 
	 * @param authentication    权限认证对象
	 * @return                  登录成功后跳转的URL
	 */
	private String determineTargetUrl(Authentication authentication) {
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		List<String> roles = new ArrayList<>();
		authorities.forEach(authoritie -> roles.add(authoritie.getAuthority()));
		
		if (roles.contains(SecurityConstant.ROLE_DBA)) {
			return SecurityConstant.DBA_URL;
		}
		
		if (roles.contains(SecurityConstant.ROLE_ADMIN)) {
			return SecurityConstant.ADMIN_URL;
		}
		
		if (roles.contains(SecurityConstant.USER_URL)) {
			return SecurityConstant.USER_URL;
		}
		
		return SecurityConstant.DENIED_URL;
	}

}
