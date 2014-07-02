/**
 * 
 */
package com.mwas.spring.beans.authentication;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;

/**
 * @author asus
 *
 */
public interface AuthorizationService {
	
	//boolean authorize(CallbackHandler cbhandler);
	Subject authorize(CallbackHandler cbhandler);
	
	String getAuthType();
	
	void setAuthType(String type);

}
