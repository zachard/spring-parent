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

package com.zachard.spring.hello.mapper;

import com.zachard.spring.hello.model.Departments;

/**
 * 部门DAO持久化接口
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public interface DepartmentsMapper {

	/**
	 * 根据部门编号查询部门信息
	 * 
	 * @param deptNo    部门编号
	 * @return          部门信息
	 */
	Departments queryByNo(String deptNo);
	
}
