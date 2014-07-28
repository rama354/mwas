/**
 * 
 */
package com.mwas.authentication;

/**
 * @author kartik
 *
 */
public interface SPACESession {
	
	
	public void init();
	
	public void destroy();
	
	public boolean isSessionLogin();
	
	public int getSpaceSessionID();

	public Object getSessionObject(String key);
	
	public void setSessionObject(String key,Object value);

	public int getHomepagehit();

	/**
	 * @param homepagehit the homepagehit to set
	 */
	public void setHomepagehit(int homepagehit);

	/**
	 * @return the securityToken
	 */
	public long getSecurityToken();

}
