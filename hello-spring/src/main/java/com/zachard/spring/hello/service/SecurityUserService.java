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

package com.zachard.spring.hello.service;

import com.zachard.spring.hello.model.security.SecurityUser;

/**
 * Spring 安全用户Service接口定义
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public interface SecurityUserService {
	
	/**
	 * 根据用户id查询用户信息
	 * 
	 * @param id    用户id
	 * @return      用户信息
	 */
	SecurityUser queryUserById(Integer id);
	
	/**
	 * 根据用户名查询用户信息
	 * 
	 * @param username    用户名
	 * @return            用户信息
	 */
	SecurityUser queryUserByUsername(String username);

}
