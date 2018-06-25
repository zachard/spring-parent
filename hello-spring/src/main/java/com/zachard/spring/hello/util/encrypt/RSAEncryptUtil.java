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

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

/**
 * <code>RSA</code>是一种非对称加密算法
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class RSAEncryptUtil {
	
	private static final String RSA_ALGORITHM = "RSA";
	
	/**
	 * 通过<code>RSA</code>算法对数据进行加密
	 * 
	 * @param publicKey    加密公钥
	 * @param data         需要加密的数据
	 * @return             加密后的密文
	 * @throws Exception
	 */
	public String encrypt(RSAPublicKey publicKey, String data) throws Exception {
		
		if (publicKey == null || data == null) {
			throw new IllegalArgumentException("参数不能为空");
		}
		
		Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] dataByte = data.getBytes();
		
		// Base64(jdk1.8)对加密后的密文进行编码,对于低版本的jdk, 可以使用sun.misc.BASE64Encoder类代替
		return Base64.getEncoder().encodeToString(cipher.doFinal(dataByte));
	}
	
	/**
	 * 通过<code>RSA</code>算法对密文进行解密
	 * 
	 * @param privateKey    解密的私钥
	 * @param cipherText    需要解密的密文
	 * @return              解密后的数据
	 * @throws Exception
	 */
	public String decrypt(RSAPrivateKey privateKey, String cipherText) throws Exception {
		
		if (privateKey == null || cipherText == null) {
			throw new IllegalArgumentException("参数不能为空");
		}
		
		// Base64(jdk1.8)对需要解密的密文进行解码,对于低版本的jdk, 可以使用sun.misc.BASE64Decoder类代替
		byte[] cipherByte = Base64.getDecoder().decode(cipherText);
		Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		
		return new String(cipher.doFinal(cipherByte));
	}

}
