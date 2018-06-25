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

package com.zachard.spring.hello.initializer;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.zachard.spring.hello.configuration.AppConfig;

/**
 * {@link AbstractAnnotationConfigDispatcherServletInitializer}表示注册{@link DispatcherServlet}
 * 到 Web Application Context 之中
 * 
 * <pre>
 *     可以用实现 {@link WebApplicationInitializer}并在{@link WebApplicationInitializer#onStartup(javax.servlet.ServletContext)}
 *     注册{@link DispatcherServlet} Spring MVC 核心处理器方法代替
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class SpringDispatchServletInitializer 
    extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 指定 {@link Configuration} 或 {@link Component} 注解的类作为程序上下文的根配置
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {AppConfig.class};
	}

	/**
	 * 指定 {@link Configuration} 或 {@link Component} 注解的类作为 {@link DispatcherServlet}
	 * 核心处理器的上下文配置
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	/**
	 * 指定 {@link DispatcherServlet} 核心处理的处理URL
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
