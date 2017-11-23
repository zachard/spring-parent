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
 * mybatis相关常量
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public interface MybatisConstant {
	
	String AUTO_MAPPING_BEHAVIOR_VALUE = "autoMappingBehavior";
	String DEFAULT_EXECUTOR_TYPE_VALUE = "defaultExecutorType";
	int DEFAULT_STATEMENT_TIMEOUT_VALUE = 2500;
	
	/**
	 * mybatis映射文件配置
	 */
	String MYBATIS_MAPPER_RESOURCE_PATH = "classpath:com/zachard/spring/hello/mapper/file/*.xml";
	
	/**
	 * mybatis别名扫描包
	 */
	String MYBATIS_TYPE_ALIASES_PACKAGE = "com.zachard.spring.hello.model";
	
	/**
	 * mapper文件对应类的路径
	 */
	String MYBATIS_MAPPER_CLASS_PATH = "com.zachard.spring.hello.mapper";

}
