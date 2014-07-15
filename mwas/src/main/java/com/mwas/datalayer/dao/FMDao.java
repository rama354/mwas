/**
 * 
 */
package com.mwas.datalayer.dao;

import com.mwas.entities.LinkedInProfile;
import com.mwas.entities.Profile;

/**
 * @author asus
 *
 */
public interface FMDao {

	public  LinkedInProfile getLinkedInProfile(final int id);
    
    public  Profile getProfile(final int id);
    
    public void setLinkedInProfile(LinkedInProfile entity);
        
    public void setProfile(Profile entity);
    

}
