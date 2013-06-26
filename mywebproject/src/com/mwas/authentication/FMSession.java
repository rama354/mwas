/**
 * 
 */
package com.mwas.authentication;

/**
 * @author asus
 *
 */
public class FMSession {

	/**
	 * 
	 */
	private static FMSession fmSessionInstance = null;
	
	private boolean sessionLogin=false; 
	private long securityToken;
	private int homepagehit;
	
	private FMSession() 
	{
	  //this.sessionLogin=sessionLogin;
		
	}

	private void init() 
	{
		sessionLogin=true;
		homepagehit=1;
		securityToken = SecurityToken.createUniqueToken();
		System.out.println("Session is logged "+sessionLogin);
		System.out.println("Homepagehit "+homepagehit);
		System.out.println("SecurityToken "+securityToken);
	}
	
	public static void destroy()
	{
		fmSessionInstance = null;	
	}
	
	public static FMSession getSessionInstance()
	{
	   if (fmSessionInstance == null)
		{
			synchronized(FMSession.class)
			{
				if (fmSessionInstance == null)
				{
					fmSessionInstance = new FMSession();
					fmSessionInstance.init();
				}
			}
		}
	   
	   return fmSessionInstance;
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
	public long getSecurityToken() {
		return securityToken;
	}

	/**
	 * @param securityToken the securityToken to set
	 */
	public void setSecurityToken(long securityToken) {
		this.securityToken = securityToken;
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
