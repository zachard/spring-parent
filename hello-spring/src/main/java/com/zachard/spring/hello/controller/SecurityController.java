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

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (StringUtils.isNoneBlank(error)) {
			modelAndView.addObject("error", "无效的用户名与密码");
		}
		
		if (StringUtils.isNoneBlank(logout)) {
			modelAndView.addObject("msg", "您已成功退出");
		}
		
		modelAndView.setViewName("login");
		
		return modelAndView;
	}

}
