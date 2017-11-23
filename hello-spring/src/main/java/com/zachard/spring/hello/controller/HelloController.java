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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 项目首页处理控制器
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Controller
public class HelloController {
	
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

}
