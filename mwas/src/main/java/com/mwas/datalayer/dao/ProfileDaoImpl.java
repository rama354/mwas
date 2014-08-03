/**
 * 
 */
package com.mwas.datalayer.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mwas.entities.Profile;
import com.mwas.entities.LinkedInProfile;


/**
 * @author kartik
 *
 */
@Repository
@Transactional
public class ProfileDaoImpl implements ProfileDao{
		 
		@Autowired
	    private SessionFactory sessionFactory;
	    
	    public  LinkedInProfile getLinkedInProfile(final int id)
	    {
	    	return (LinkedInProfile)sessionFactory.getCurrentSession().get(LinkedInProfile.class, new Integer(id));
	    }
	    
	    public  Profile getProfile(final long id)
	    {
	    	return (Profile)sessionFactory.getCurrentSession().get(Profile.class, new Long(id));
	    }
	    
	    public List<Profile> getAllProfiles()
	    {
	    	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Profile.class);
	    	List<Profile> allProfiles = new ArrayList<Profile>();
	    	for (Object profile:criteria.list()){
	    		allProfiles.add((Profile)profile);
	    	}
	    	
	    	return allProfiles;
	    }
	    
	    
	    public void setLinkedInProfile(LinkedInProfile entity)
	    {
	    	sessionFactory.getCurrentSession().saveOrUpdate(entity);
	    }
	    
	    public void setProfile(Profile entity)
	    {
	    	sessionFactory.getCurrentSession().saveOrUpdate(entity);
	    }

	    public SessionFactory getSessionFactory()
	    {
	        return sessionFactory;
	    }
	    
}
