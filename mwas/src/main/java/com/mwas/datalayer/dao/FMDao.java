/**
 * 
 */
package com.mwas.datalayer.dao;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mwas.entities.FutureMaker;
import com.mwas.entities.Profile;

/**
 * @author kartik
 *
 */
@Repository("fmDao")
public class FMDao {
		 
		@Autowired
	    private SessionFactory sessionFactory;
	    
	    public  FutureMaker getFutureMaker(final int id)
	    {
	    	sessionFactory.getCurrentSession().get(FutureMaker.class, new Integer(id));
	    }
	    
	    public void setFutureMaker(Profile entity)
	    {
	    	sessionFactory.getCurrentSession().saveOrUpdate(entity);
	    }
	    

	    /*public void setSessionFactory(SessionFactory
	    									sessionFactory)
	    {
	        this.sessionFactory = sessionFactory;
	    }*/
	 
	    public SessionFactory getSessionFactory()
	    {
	        return sessionFactory;
	    }
}
