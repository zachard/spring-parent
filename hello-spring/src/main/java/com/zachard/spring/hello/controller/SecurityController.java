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

package com.zachard.spring.hello.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Spring Security 示例相关Controller
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Controller
@RequestMapping("/security")
public class SecurityController {
	
	/**
	 * Spring Security 入门示例, 没有访问限制的请求URL
	 * 
	 * @return    逻辑视图
	 */
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security 安全入门");
		model.addObject("message", "欢迎, 这是一个公开访问页面!");
		model.setViewName("index");
		
		return model;
	}
	
	/**
	 * Spring Security 入门示例, 特定角色访问(权限限制)的URL示例
	 * 
	 * @return    逻辑视图名称
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView admin() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security 安全入门");
		model.addObject("message", "欢迎,这是系统管理员页面!");
		model.setViewName("admin");

		return model;
	}
	
	/**
	 * Spring Security 入门示例, 特定角色访问(权限限制)的URL示例
	 * 
	 * @return    逻辑视图名称
	 */
	@RequestMapping(value = "/dba", method = RequestMethod.GET)
	public ModelAndView dba() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security 安全入门");
		model.addObject("message", "欢迎,这是数据库管理员页面!");
		model.setViewName("admin");

		return model;
	}
	
	/**
	 * 处理用户登录、登录失败与退出登录请求
	 * 
	 * @param error    登录错误标志
	 * @param logout   退出登录标志
	 * @return         请求的逻辑视图
	 */
	@RequestMapping(value = "/login", method = {RequestMethod.GET})
	public String login() {
		return "login";
	}
	
	/**
	 * 处理登出的请求接口
	 * 
	 * <pre>
	 *     (1) {@link SecurityContextHolder}表示一个与当前执行线程关联的{@link SecurityContext}对象
	 *     (2) {@link SecurityContextLogoutHandler}类通过修改{@link SecurityContextHolder}对象来指定登出操作
	 *         {@link SecurityContextLogoutHandler}会校验{@link HttpSession}对象是否为<code>null</code>,
	 *         并且当<code>clearAuthentication</code>设置为<code>true</code>时, 可以移除当前{@link SecurityContext}
	 *         中的{@link Authentication}对象
	 * </pre>
	 * 
	 * @param request    HTTP请求对象
	 * @param response   HTTP响应对象
	 * @return           重定向的视图页面
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {
			/*
			 * SecurityContextLogoutHandler注销时,会执行一下操作:
			 * (1) 若HTTP会话失效, 解除绑定到它的任何对象
			 * (2) 删除 SecurityContext 的身份验证, 以防止并发请求的问题
			 * (3) 显式地清除当前线程上下文值
			 */
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		// 可以重定向到任意页面,但一般是重定向到登录页面
		return "redirect:/security/login?logout";
	}
	
	/**
	 * 权限拒绝请求URL
	 * 
	 * @param model    视图model对象
	 * @return         逻辑视图名称
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}
	
	/**
	 * 获取登录用户名
	 * 
	 * @return    登录用户名
	 */
	private String getPrincipal() {
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			return username;
		}
		
		username = principal.toString();
		return username;
	}

}
