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

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * {@link MessageDigest}信息摘要算法加密工具类
 * <pre>
 *     {@link MessageDigest}提供了信息摘要算法的实现,例如: SHA-1,SHA-256, MD5算法,
 *     信息摘要算法是一种将任意大小数据加密为固定长度哈希值的单向安全加密函数
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class MessageDigestUtil {
	
	private static final String MD5_ALGORITHM = "MD5";
	private static final String SHA_ALGORITHM = "SHA";
	
	/**
	 * 编码格式,放入项目中的全局常量接口不合适,因为这是工具类,会引入业务代码
	 */
	private static final String ENCODE = "UTF-8";
	
	/**
	 * 采用MD5生成字符串加密信息摘要
	 * 
	 * @param data   需要加密的字符串
	 * @return       按MD5算法生成的摘要信息
	 * @throws NoSuchAlgorithmException    算法不存在
	 * @throws UnsupportedEncodingException 
	 */
	public static String encryptByMD5(String data) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return encrypt(data, MD5_ALGORITHM);
	}
	
	/**
	 * 采用SHA生成字符串加密信息摘要
	 * 
	 * @param data   需要加密的字符串
	 * @return       按MD5算法生成的摘要信息
	 * @throws NoSuchAlgorithmException    算法不存在
	 * @throws UnsupportedEncodingException 
	 */
	public static String encryptBySHA(String data) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return encrypt(data, SHA_ALGORITHM);
	}
	
	/**
	 * 对字符串按指定算法生成摘要信息
	 * <pre>
	 *     {@link MessageDigest#update(byte)}会更新摘要,并将状态设置为处理中
	 *     {@link MessageDigest#digest()}主要完成摘要生成最后的哈希值计算,
	 *     计算完成之后状态设置为初始状态,摘要被清空
	 * </pre>
	 * 
	 * @param data    需要生成摘要信息的字符串
	 * @param algorithm    生成摘要的算法
	 * @return             字符串的摘要信息
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException 
	 */
	private static String encrypt(String data, String algorithm) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (data == null) {
			throw new IllegalArgumentException("方法参数不能为空");
		}
		
		MessageDigest md5 = MessageDigest.getInstance(algorithm);
		md5.update(data.getBytes(ENCODE));
		
		return new String(md5.digest(), ENCODE);
	}

}
