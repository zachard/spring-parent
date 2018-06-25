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
 * <code>DES</code>是一种对称加密算法
 * 
 * 注: 之前想要将所有对称加密算法设置到一个工具类中,并且所有加密方法为静态,但是因为每个对称加密算法
 *     都需要设置对应密钥生成器、对称密钥,所以采用非静态方式类实现
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class DESEncryptUtil extends AbstractSymmetricEncryptUtil {
	
	private static final String DES_ALGORITHM = "DES";
	
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
	public DESEncryptUtil() throws NoSuchAlgorithmException, NoSuchPaddingException {
		Security.addProvider(new SunJCE());
		keyGenerator = KeyGenerator.getInstance(DES_ALGORITHM);
		secretKey = keyGenerator.generateKey();
		cipher = Cipher.getInstance(DES_ALGORITHM);
	}

}
