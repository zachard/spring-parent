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

import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import com.sun.crypto.provider.SunJCE;

/**
 * <code>AES</code>高级标准对称加密算法
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class AESEncryptUtil extends AbstractSymmetricEncryptUtil {
	
	private static final String AES_ALGORITHM = "DES";
	
	//@Value("${secretKey}")
	private String keyString;
	
	/**
	 * <code>DES</code>算法加密对应的工具类构造器
	 * 
	 * <pre>
	 *     每次调用{@link KeyGenerator#generateKey()}得到的{@link SecretKey}都不一致
	 *     所以实际应用中必须保证这个类型为单例
	 * </pre>
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 */
	public AESEncryptUtil() throws NoSuchAlgorithmException, NoSuchPaddingException {
		Security.addProvider(new SunJCE());
		
		keyGenerator = KeyGenerator.getInstance(AES_ALGORITHM);
		secretKey = keyGenerator.generateKey();
		
		// 生成指定的SecretKey, 而不是随机生成, 避免项目重启之后无法解密
//		byte[] keyBytes = new BASE64Decoder().decodeBuffer(keyString);
//		secretKey = new SecretKeySpec(keyBytes, AES_ALGORITHM);
		cipher = Cipher.getInstance(AES_ALGORITHM);
	}

}
