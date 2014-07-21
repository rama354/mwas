/**
 * 
 */
package com.mwas.entities;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author rramanathan
 *
 */
public class Profile implements Serializable 
{

	private static final long serialVersionUID = 1L;
	protected long SPACE_ID;
	protected String firstName;
	protected String lastName;	
	protected String userName;

	
	private ArrayList<String> attributeList = null;
	/**
	 * @return the employeeName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return the sPACE_ID
	 */
	public synchronized long getSPACE_ID() {
		return SPACE_ID;
	}
	/**
	 * @return the lasttName
	 */
	public synchronized String getLastName() {
		return lastName;
	}
	/**
	 * @param lasttName the lasttName to set
	 */
	public synchronized void setLastName(String lasttName) {
		this.lastName = lasttName;
	}
	/**
	 * @return the userName
	 */
	public synchronized String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public synchronized void setUserName(String userName) {
		this.userName = userName;
	}
	public List getAttributes() 
	{
		 attributeList = new ArrayList<String>();
		 attributeList.add("FirstName");
		 //attributeList.add("SPACE_ID");
		 attributeList.add("LastName");
		 attributeList.add("UserName");
		
		 return attributeList;
	}
	
	public void setAttributeValues(Map<String, Object> valueMap)
	{
	   Set<String> iterator =  valueMap.keySet();
	   Class[] parameterTypes = null;
	   Object[] args = null;
	   
	   for (String attribute: iterator)
	   {
		   if (attribute.equalsIgnoreCase("FirstName"))
		   {
			   parameterTypes = new Class[]{String.class};  
			   args = new Object[]{new String((String)valueMap.get(attribute))};
		   }
		   /*
		   else if (attribute.equalsIgnoreCase("SPACE_ID"))
		   {
			   parameterTypes = new Class[]{int.class};
			   args = new Object[]{new Integer((Integer)valueMap.get(attribute))};
		   }*/
		   else if (attribute.equalsIgnoreCase("LastName"))
		   {
			   parameterTypes = new Class[]{String.class};
			   args = new Object[]{new String((String)valueMap.get(attribute))};
		   }
		   else if (attribute.equalsIgnoreCase("UserName"))
		   {
			   parameterTypes = new Class[]{String.class};
			   args = new Object[]{new String((String)valueMap.get(attribute))};
		   }
		   try 
		   {
			Profile.class.getMethod("set"+attribute, parameterTypes).invoke(this,args);
		   } catch (IllegalAccessException e)
		   {
			   e.printStackTrace();
		   }catch (IllegalArgumentException e){
			   e.printStackTrace();
		   }catch (InvocationTargetException e){
			   e.printStackTrace();
		   }
		    catch(NoSuchMethodException e){
		    	e.printStackTrace();
		    }
		    catch (SecurityException e) 
		   {
		 
			e.printStackTrace();  ////Use Logger
		   }
	   }		
	}
}
