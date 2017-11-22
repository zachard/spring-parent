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

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zachard.spring.hello.model.Departments;
import com.zachard.spring.hello.service.DepartmentsService;

/**
 * 部门处理请求Controller
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Controller
@RequestMapping("/department")
public class DepartmentsController {

	@Resource
	private DepartmentsService departmentsService;
	
	/**
	 * 查询部门信息请求接口
	 * 
	 * @param deptNo    部门编号
	 * @return          部门信息
	 */
	@RequestMapping(value = "/{deptNo}", method = {RequestMethod.GET})
	@ResponseBody
	public Departments query(@PathVariable("deptNo") String deptNo) {
		return departmentsService.queryByNo(deptNo);
	}
	
}
