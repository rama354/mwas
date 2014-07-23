/**
 * 
 */
package com.mwas.datalayer.dao;

import java.util.List;

import com.mwas.entities.LinkedInProfile;
import com.mwas.entities.Profile;

/**
 * @author asus
 *
 */
public interface ProfileDao {

	public  LinkedInProfile getLinkedInProfile(final int id);
    
    public  Profile getProfile(final int id);
    
    public void setLinkedInProfile(LinkedInProfile entity);
        
    public void setProfile(Profile entity);
    
    public List<Profile> getAllProfiles();
    

}
