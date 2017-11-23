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

package com.zachard.spring.hello.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security 配置类, 作用类似于 spring-security.xml 文件
 * <pre>
 *     {@link EnableWebSecurity}注解表示开启Web安全配置
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/**
	 * 系统用户角色分类,理论上应该配置在配置文件
	 * <pre>
	 *     注: (1) Spring Security 会自动为 USER 加上 ROLE_ 变成 ROLE_USER
	 * </pre>
	 */
	private static final String ROLE_USER = "USER";
	private static final String ROLE_AMAIN = "AMAIN";
	private static final String ROLE_DBA = "DBA";
	
	/**
	 * 对Spring Security用户及角色进行管理, 相当于 spring-security.xml 文件中
	 * <authentication-manager>作用
	 * 
	 * <pre>
	 *     {@link AuthenticationManagerBuilder#inMemoryAuthentication()}
	 *     方法表示将用户的权限相关信息加载到内存之中
	 * </pre>
	 * 
	 * @param auth
	 * @throws Exception
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("zachard").password("123456").roles(ROLE_USER);
		auth.inMemoryAuthentication().withUser("admin").password("123456").roles(ROLE_AMAIN);
		auth.inMemoryAuthentication().withUser("dba").password("123456").roles(ROLE_DBA);
	}
	
	/**
	 * 对项目中的URL请求权限进行控制, 相当于 spring-security.xml 文件中的 http 标签作用
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		    .antMatchers("/security/admin/**").access("hasRole('ROLE_ADMIN')")
		    .antMatchers("/security/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
		    .and().formLogin();
	}

}
