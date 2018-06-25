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

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.zachard.spring.hello.util.encrypt.MessageDigestUtil;

/**
 * {@link MessageDigest}信息摘要算法加密工具测试类
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class MessageDigestUtilTest {
	
	/**
	 * MD5算法生成摘要方法测试
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void encryptByMD5Test() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String digest = MessageDigestUtil.encryptByMD5("zpzeng");
		System.err.println("生成的摘要信息为: " + digest);
	}
	
	/**
	 * SHA算法生成摘要方法测试
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void encryptBySHATest() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String digest = MessageDigestUtil.encryptBySHA("zpzeng");
		System.err.println("生成的摘要信息为: " + digest);
	}

}
