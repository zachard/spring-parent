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

package com.zachard.spring.hello.enums;

import java.util.Collection;

import com.zachard.spring.hello.constant.SecurityConstant;

/**
 * Spring 安全 -- 角色与其登录成功跳转URL枚举类
 * 
 * <pre>
 *     因为角色是存在一个{@link Collection}集合之中, 所以暂时不启用这个枚举, 通过常量来使用角色及URL
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Deprecated
public enum SecurityRoleUrlEnum {
	USER(SecurityConstant.ROLE_USER, SecurityConstant.USER_URL),
	ADMIN(SecurityConstant.ROLE_ADMIN, SecurityConstant.ADMIN_URL),
	DBA(SecurityConstant.ROLE_DBA, SecurityConstant.DBA_URL),
	DENY("", SecurityConstant.DENIED_URL),
	;
	
	/**
	 * Spring 安全角色
	 */
	private String role;
	
	/**
	 * Spring 安全跳转URL
	 */
	private String url;
	
	SecurityRoleUrlEnum(String role, String url) {
		this.role = role;
		this.url = url;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

}
