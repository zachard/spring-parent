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

import java.util.Objects;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.zachard.spring.hello.constant.EncryptKeyConstant;
import com.zachard.spring.hello.util.encrypt.Base64EncryptUtil;

/**
 * 自定义属性配置文件解析器
 * <pre>
 *     一般用于对访问数据库属性加密
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class CustomPropertyPlaceholder extends PropertyPlaceholderConfigurer {
	
	/**
	 * 对加载后的properties特定属性值进行转换
	 * 
	 * @param  属性key
	 * @param  配置文件中的属性值
	 * @return 转化后的属性值
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		
		if(Objects.equals(propertyName, EncryptKeyConstant.JDBC_PASSWORD)) {
			return Base64EncryptUtil.decode(propertyValue);
		}
		
		return propertyValue;
	}

}
