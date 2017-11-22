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

package com.zachard.spring.hello.util.encrypt;

import java.util.Base64;

/**
 * 采用{@link Base64}实现字符串的编码与解码
 * <pre>
 *     通过Base64实现字符串的编码与解码
 *     注意事项: (1) 只有JDK 1.8版本开始才存在
 *              (2) Base64的定义: 被设计用于把任意8位字节描述为一种不易被人直接识别的形式
 *              (3) Base64一般用于编码/解码,而不用于密码加密与解密
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 * @since 1.8
 */
public class Base64EncryptUtil {

	/**
	 * 通过{@link Base64}对字符串进行解码
	 * 
	 * @param value    需要解码的字符串
	 * @return         解码后的原字符串
	 */
	public static String decode(String value) {
		return new String(Base64.getDecoder().decode(value));
	}
	
	/**
	 * 通过{@link Base64}对字符串进行编码
	 * 
	 * @param value    需要进行编码的字符串
	 * @return         编码后的字符串
	 */
	public static String encode(String value) {
		
		if (value == null) {
			throw new IllegalArgumentException("参数不能为空");
		}
		
		return Base64.getEncoder().encodeToString(value.getBytes());
	}
}
