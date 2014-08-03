/**
 * 
 */
package com.mwas.authentication;

import java.io.Serializable;
import java.util.LinkedHashMap;

import javax.security.auth.Subject;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.mwas.authentication.SPACESession;

/**
 * @author asus
 *
 */
@Component
//@Scope(value="session",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SPACESessionImpl implements SPACESession,Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	//private static SPACESession spaceSession = null;
	
	private boolean sessionLogin; 
	private long securityToken;
	private int homepagehit;
	private int spaceSessionID;
	private LinkedHashMap<String, Object> sessionObjects; 
	
	public SPACESessionImpl() 
	{
		securityToken = SecurityToken.createUniqueToken();
		spaceSessionID=SecurityToken.createUserID();
		sessionLogin=true;
		homepagehit=1;		
		sessionObjects= new LinkedHashMap<String, Object>();
		
		System.out.println("Session is logged "+sessionLogin);
		System.out.println("Homepagehit "+homepagehit);
		System.out.println("SecurityToken "+securityToken);
	}

	public void init() 
	{
		securityToken = SecurityToken.createUniqueToken();
		spaceSessionID=SecurityToken.createUserID();
		sessionLogin=true;
		homepagehit=1;		
		sessionObjects= new LinkedHashMap<String, Object>();
		
		System.out.println("Session is logged "+sessionLogin);
		System.out.println("Homepagehit "+homepagehit);
		System.out.println("SecurityToken "+securityToken);
	}
	
	/**
	 * @return the fmid
	 */
	public final int getSpaceSessionID() {
		return spaceSessionID;
	}

	public final Object getSessionObject(String key){
		return sessionObjects.get(key);
	}
	
	public synchronized void setSessionObject(String key,Object value){
		sessionObjects.put(key, value);
	}
	
	public void destroy()
	{
		//securityToken = SecurityToken.createUniqueToken();
		//spaceSessionID=SecurityToken.createUserID();
		sessionLogin=false;	
		sessionObjects= null;
	}
	/*
	public static SPACESession getSessionInstance()
	{
	   if (spaceSession == null)
		{
			synchronized(SPACESession.class)
			{
				if (spaceSession == null)
				{
					spaceSession = new SPACESession();
					spaceSession.init();
				}
			}
		}
	   
	   return spaceSession;
	}*/
	/**
	 * @return the homepagehit
	 */
	public final int getHomepagehit() {
		return homepagehit;
	}

	/**
	 * @param homepagehit the homepagehit to set
	 */
	public synchronized void setHomepagehit(int homepagehit) {
		this.homepagehit = homepagehit;
	}

	/**
	 * @return the securityToken
	 */
	public final long getSecurityToken() {
		return securityToken;
	}

	
	/**
	 * @return the sessionLogin
	 */
	public boolean isSessionLogin() 
	{
		return sessionLogin;
	}

	/**
	 * @param sessionLogin the sessionLogin to set
	 */
	public synchronized void setSessionLogin(boolean sessionLogin) {
		this.sessionLogin = sessionLogin;
	}
	
}
