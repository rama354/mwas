/**
 * 
 */
package com.mwas.authentication;

import java.util.Random;

/**
 * @author asus
 *
 */
public class SecurityToken {

	public static long createUniqueToken() {
		// TODO Auto-generate method stub
		Random random = new Random(980354);
		return random.nextLong();
	}

}
