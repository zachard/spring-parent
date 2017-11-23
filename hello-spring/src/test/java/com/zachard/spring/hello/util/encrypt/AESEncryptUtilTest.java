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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.junit.BeforeClass;
import org.junit.Test;

import sun.misc.BASE64Encoder;

/**
 * <code>AES</code>高级标准对称加密算法测试类
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class AESEncryptUtilTest {
	
private static AESEncryptUtil aesEncryptUtil;
	
	/**
	 * 加密后的密文
	 */
	private String cipherText;
	
	/**
	 * 整个测试过程中只对加密工具类初始化一次,以确保{@link SecretKey}加密与解密过程中保持不变
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IOException 
	 */
	@BeforeClass
	public static void setBeforeClass() throws NoSuchAlgorithmException, NoSuchPaddingException, IOException {
		System.setProperty("secretKey", "f8gjOz4x0+8=");
		aesEncryptUtil = new AESEncryptUtil();
	}
	
	/**
	 * <code>DES</code>算法加解密测试
	 * 
	 * <pre>
	 *     放在一个方法里面执行,保证加密与解密的同步执行(先加密后解密)
	 * </pre>
	 * 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidKeyException 
	 * @throws IOException 
	 */
	@Test
	public void aesTest() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
		encryptTest();
		//cipherText = "I7wWUv5zwFY=";
		decryptTest();
		System.err.println("密钥的Key为: " + new BASE64Encoder().encode(aesEncryptUtil.secretKey.getEncoded()));
	}
	
	/**
	 * <code>DES</code>算法加密测试方法
	 * 
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws UnsupportedEncodingException
	 */
	private void encryptTest() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		String data = "zpzeng";
		cipherText = aesEncryptUtil.encrypt(data);
		System.err.println("加密后的密文为: " + cipherText);
	}
	
	/**
	 * <code>DES</code>算法解密测试方法
	 * 
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws IOException
	 */
	private void decryptTest() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
		System.err.println("解密后的原文为: " + aesEncryptUtil.decrypt(cipherText));
	}

}
