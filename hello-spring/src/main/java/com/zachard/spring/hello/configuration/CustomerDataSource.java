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

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 自定义数据源对象
 * 
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class CustomerDataSource extends BasicDataSource implements InitializingBean, DisposableBean {

	/**
	 * 实现{@link DisposableBean}接口, 容器销毁时, 关闭数据源
	 */
	@Override
	public void destroy() throws Exception {
		super.close();
	}

	/**
	 * 实现{@link InitializingBean}接口, 容器创建时, 创建数据源
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		super.createDataSource();
	}

}
