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

package com.zachard.spring.hello.util;

import java.util.Base64;

import org.junit.Test;

/**
 * 加密工具测试类
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class EncryptUtilTest {
	
	/**
	 * 测试{@link Base64}解密密文
	 */
	@Test
	public void decryptByBase64Test() {
		String encode = "enB6ZW5n";
		System.err.println("解密后的原文为: " + EncryptUtil.decryptByBase64(encode));
	}
	
	/**
	 * 测试{@link Base64}加密原文
	 */
	@Test
	public void encodeByBase64Test() {
		String source = "zpzeng";
		System.err.println("加密后的密文为: " + EncryptUtil.encodeByBase64(source));
	}

}
