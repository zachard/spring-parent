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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zachard.spring.hello.constant.DBConstant;

/**
 * 数据源配置类,用于获取数据源
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Configuration
public class DataSourceConfiguration {
	
	/**
	 * 数据源获取, 设置数据源的用户名、密码等各种连接属性
	 * 
	 * @return    数据源对象
	 */
	@Bean(name = "customerDataSource")
	public CustomerDataSource getDataSource() {
		CustomerDataSource dataSource = new CustomerDataSource();
		
		// 设置数据源连接属性
		dataSource.setDriverClassName(DBConstant.DRIVER);
		dataSource.setUrl(DBConstant.URL);
		dataSource.setUsername(DBConstant.USERNAME);
		dataSource.setPassword(DBConstant.PASSWORD);
		dataSource.setInitialSize(DBConstant.INITIALPOOLSIZE);
		dataSource.setMinIdle(DBConstant.MINIDLE);
		dataSource.setMaxActive(DBConstant.MAXACTIVE);
		dataSource.setMaxWait(DBConstant.MAXWAIT);
		
		return dataSource;
	}

}
