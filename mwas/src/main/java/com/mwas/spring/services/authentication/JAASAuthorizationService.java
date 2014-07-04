/**
 * 
 */
package com.mwas.spring.beans.authentication;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import org.springframework.stereotype.Service;

import com.mwas.security.SecurityConstants;



/**
 * @author asus
 *
 */
@Service
public class JAASAuthorizationService implements AuthorizationService {

	/**
	 * 
	 */
	public JAASAuthorizationService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Subject authorize(CallbackHandler cbhandler) 
	{
		//boolean isLoginSuccess=false;
		Subject subject=null;
		try 
		{
			LoginContext loginContext = new LoginContext("MWAS",cbhandler);
			loginContext.login();
			subject=loginContext.getSubject();
			//isLoginSuccess=true;
		} catch (LoginException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//return isLoginSuccess;
		return subject;
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
