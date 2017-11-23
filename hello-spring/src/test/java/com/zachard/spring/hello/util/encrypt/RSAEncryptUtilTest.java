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

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * <code>RSA</code>加密算法工具类测试类
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class RSAEncryptUtilTest {
	
	private static RSAEncryptUtil rsaEncryptUtil;
	
	private static final String RSA_ALGORITHM = "RSA";
	
	@BeforeClass
	public static void setBeforeClass() {
		rsaEncryptUtil = new RSAEncryptUtil();
	}
	
	/**
	 * <code>RSA</code>算法加密与解密测试方法
	 * 
	 * @throws Exception
	 */
	@Test
	public void rsaTest() throws Exception {
		// 获取及初始化密钥生成器
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
		keyPairGenerator.initialize(1024);
		
		// 生成私钥及公钥
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		
		String data = "zpzeng";
		System.err.println("需要加密的数据为: " + data);
		String cipherText = rsaEncryptUtil.encrypt(publicKey, data);
		System.err.println("密文为: " + cipherText);
		String desData = rsaEncryptUtil.decrypt(privateKey, cipherText);
		System.err.println("解密后的数据为: " + desData);
	}

}
