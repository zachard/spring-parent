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

package com.zachard.spring.hello.constant;

/**
 * Spring 安全相关的静态常量
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public interface SecurityConstant {
	
	/**
	 * Spring 安全角色常量
	 */
	String ROLE_USER = "ROLE_USER";
	String ROLE_ADMIN = "ROLE_ADMIN";
	String ROLE_DBA = "ROLE_DBA";
	
	/**
	 * Spring 安全不同角色登录成功的URL
	 */
	String USER_URL = "/security/index";
	String ADMIN_URL = "/security/admin";
	String DBA_URL = "/security/dba";
	String DENIED_URL = "/security/Access_Denied";

}
