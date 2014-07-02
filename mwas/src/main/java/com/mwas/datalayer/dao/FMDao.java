/**
 * 
 */
package com.mwas.datalayer.dao;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mwas.entities.FutureMaker;
import com.mwas.entities.Profile;

/**
 * @author kartik
 *
 */
@Repository("fmDao")
public class FMDao {
		 
	    private HibernateTemplate hibernateTemplate;
	    
	    @Autowired
	    public void setHibernateTemplate(HibernateTemplate
	                             hibernateTemplate)
	    {
	        this.hibernateTemplate = hibernateTemplate;
	    }
	 
	    public HibernateTemplate getHibernateTemplate()
	    {
	        return hibernateTemplate;
	    }
	
	    public  FutureMaker getFutureMaker(final int id)
	    {
	        HibernateCallback callback = new HibernateCallback() {
	            public Object doInHibernate(Session session)
	                throws HibernateException,SQLException 
	            {
	                return session.load(FutureMaker.class, id);
	            }
	        };
	        return (FutureMaker)hibernateTemplate.execute(callback);
	    }
	    
	    public void setFutureMaker(Profile entity)
	    {
	    	hibernateTemplate.saveOrUpdate(entity);
	    }
}
