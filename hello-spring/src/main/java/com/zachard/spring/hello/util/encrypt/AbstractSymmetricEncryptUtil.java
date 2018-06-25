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
import java.nio.charset.Charset;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 对称加密工具类公共类
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public abstract class AbstractSymmetricEncryptUtil {
	/**
	 * 对称密钥生成器
	 */
	protected KeyGenerator keyGenerator;
	
	/**
	 * 对称密钥
	 */
	protected SecretKey secretKey;
	
	/**
	 * 加密与解密类
	 */
	protected Cipher cipher;
	
	public static final String ENCODE = "UTF-8";
	
	/**
	 * 对数据进行加密操作
	 * 
	 * @param data    需要加密的数据
	 * @return        加密后的数据
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws UnsupportedEncodingException
	 */
	public String encrypt(String data) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		
		if (data == null) {
			throw new IllegalArgumentException("参数不能为空");
		}
		
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] cipherByte = cipher.doFinal(data.getBytes(ENCODE));
		
		return new BASE64Encoder().encode(cipherByte);
	}
	
	/**
	 * 对密文进行解密操作
	 * 
	 * @param cipherText    加密的密文
	 * @return              解密后的数据
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws IOException 
	 */
	public String decrypt(String cipherText) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
		
		if (cipherText == null) {
			throw new IllegalArgumentException("参数不能为空");
		}
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] dataByte = cipher.doFinal(new BASE64Decoder().decodeBuffer(cipherText));
		
		return new String(dataByte, Charset.forName(ENCODE));
	}
}
