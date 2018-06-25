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

import java.util.ResourceBundle;

import com.zachard.spring.hello.util.encrypt.Base64EncryptUtil;

/**
 * 数据库JDBC属性key值
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class DBConstant {
	
	private static final ResourceBundle DB_BUNDLE;
	
	static {
		// 这是一种加载属性文件的写法, 正规的写法应该用写工具类将配置文件属性加载到Properties中
		DB_BUNDLE = ResourceBundle.getBundle(Constant.DB_FILE_NAME);
	}
	
	/**
	 * 数据库属性的Key值
	 */
	private static final String DRIVER_KEY = "jdbc.driverClassName";
	private static final String URL_KEY = "jdbc.url";
	private static final String USERNAME_KEY = "jdbc.username";
	private static final String PASSWORD_KEY = "jdbc.password";
	private static final String MAXACTIVE_KEY = "jdbc.maxActive";
	private static final String MAXWAIT_KEY = "jdbc.maxWait";
	private static final String INITIALPOOLSIZE_KEY = "jdbc.initialPoolSize";
	private static final String MINIDLE_KEY = "jdbc.minIdle";
	
	/**
	 * 为数据库连接属性赋值
	 */
	public static final String DRIVER = DB_BUNDLE.getString(DRIVER_KEY);
	public static final String URL = DB_BUNDLE.getString(URL_KEY);
	public static final String USERNAME = DB_BUNDLE.getString(USERNAME_KEY);
	public static final String PASSWORD = Base64EncryptUtil.decode(DB_BUNDLE.getString(PASSWORD_KEY));
	public static final int MAXACTIVE = Integer.valueOf(DB_BUNDLE.getString(MAXACTIVE_KEY));
	public static final long MAXWAIT = Integer.valueOf(DB_BUNDLE.getString(MAXWAIT_KEY));
	public static final int INITIALPOOLSIZE = Integer.valueOf(DB_BUNDLE.getString(INITIALPOOLSIZE_KEY));
	public static final int MINIDLE = Integer.valueOf(DB_BUNDLE.getString(MINIDLE_KEY));

}
