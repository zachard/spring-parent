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

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zachard.spring.hello.constant.MybatisConstant;

/**
 * mybatis的mapper文件对应类扫描配置
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Configuration
public class MyBatisMapperScannerConfig {
	
	/**
	 * mybatis的mapper文件对应类扫描配置
	 * 
	 * @return    mapper文件类扫描配置对象
	 */
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(MybatisConstant.MYBATIS_MAPPER_CLASS_PATH);
        
        return mapperScannerConfigurer;
	}

}
