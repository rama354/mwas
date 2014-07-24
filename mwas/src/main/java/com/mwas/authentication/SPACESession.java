/**
 * 
 */
package com.mwas.authentication;

import java.io.Serializable;
import java.util.LinkedHashMap;

import javax.security.auth.Subject;

/**
 * @author asus
 *
 */
public class SPACESession implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private static SPACESession spaceSession = null;
	
	private boolean sessionLogin; 
	private final long securityToken;
	private int homepagehit;
	//private Subject subject;
	private final int spaceSessionID;

	private LinkedHashMap<String, Object> sessionObjects; 
	
	private SPACESession() 
	{
		securityToken = SecurityToken.createUniqueToken();
		spaceSessionID=SecurityToken.createUserID();
		sessionLogin=true;
		homepagehit=1;
		
		sessionObjects= new LinkedHashMap<String, Object>();
	}

	private void init() 
	{
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

	public Object getSessionObject(String key){
		return sessionObjects.get(key);
	}
	
	public Object setSessionObject(String key,Object value){
		return sessionObjects.put(key, value);
	}
	
	public static void destroy()
	{
		spaceSession = null;	
	}
	
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
	}
	/**
	 * @return the homepagehit
	 */
	public int getHomepagehit() {
		return homepagehit;
	}

	/**
	 * @param homepagehit the homepagehit to set
	 */
	public void setHomepagehit(int homepagehit) {
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
	public void setSessionLogin(boolean sessionLogin) {
		this.sessionLogin = sessionLogin;
	}
	
}
