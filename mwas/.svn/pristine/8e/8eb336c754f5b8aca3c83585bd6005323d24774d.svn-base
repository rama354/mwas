/**
 * 
 */
package com.mwas.spring.beans.authentication;

import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import com.mwas.security.SecurityConstants;



/**
 * @author asus
 *
 */
public class JAASAuthorizationService implements AuthorizationService {

	/**
	 * 
	 */
	public JAASAuthorizationService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean authorize(CallbackHandler cbhandler) 
	{
		boolean isLoginSuccess=false;
		try 
		{
			LoginContext loginContext = new LoginContext("MWAS",cbhandler);
			loginContext.login();
			isLoginSuccess=true;
		} catch (LoginException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return isLoginSuccess;
	}

	@Override
	public String getAuthType() {
		// TODO Auto-generated method stub
		return SecurityConstants.JAAS_AUTH_TYPE;
	}

	@Override
	public void setAuthType(String type) {
		// TODO Auto-generated method stub
		
	}

}
