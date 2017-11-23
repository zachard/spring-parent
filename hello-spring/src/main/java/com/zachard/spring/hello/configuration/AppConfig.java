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
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * 项目配置类
 * 
 * <pre>
 *     {@link EnableWebMvc}注解表示启用Spring webmvc 的功能
 *     {@link ComponentScan}注解表示需要扫描注解为组件的包, 相当于 spring-mvc.xml 中的 context:component-scan 标签
 *     {@link Import}表示需要导入的其他配置类
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@EnableWebMvc
@Configuration
@ComponentScan({"com.zachard.spring.hello.*"})
@Import({SpringSecurityConfig.class, DataSourceConfiguration.class, MyBatisConfig.class, MyBatisMapperScannerConfig.class})
public class AppConfig {
	
	/**
	 * 配置视图解析器
	 * 相当于在 spring-mvc.xml 配置文件中配置视图解析器
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		// prefix设置为: /WEB-INF/classes/pages时,表示的是 src/main/resources/pages目录
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}

}
