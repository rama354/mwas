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

/**
 * @author rramanathan
 *
 */
public class Person implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String employeeName;
	private int hr_ID;
	private String designation;
	private String division;
	
	private ArrayList<String> attributeList = null;
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	/**
	 * @return the hr_ID
	 */
	public int getHr_ID() {
		return hr_ID;
	}
	/**
	 * @param d the hr_ID to set
	 */
	public void setHr_ID(int hr_ID) {
		this.hr_ID = hr_ID;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
	   if (designation != null)
			this.designation = designation;
	   else
		   this.designation = " ";
	}
	
	
	/**
	 * @return the division
	 */
	public String getDivision() {
		return division;
	}
	/**
	 * @param division the division to set
	 */
	public void setDivision(String division) 
	{
	   if (division !=null)	
		   this.division = division;
	   else
		   this.division = " ";
	}
	public List getAttributes() 
	{
		 attributeList = new ArrayList<String>();
		 attributeList.add("EmployeeName");
		 attributeList.add("Hr_ID");
		 attributeList.add("Designation");
		// attributeList.add("Division");
		
		 return attributeList;
	}
	
	public void setAttributeValues(Map<String, Object> valueMap)
	{
	   Iterator iterator =  attributeList.iterator();
	   Class[] parameterTypes = null;
	   Object[] args = null;
	   
	   while(iterator.hasNext())
	   {
		   String attribute = (String)iterator.next();
		   if (attribute.equalsIgnoreCase("EmployeeName"))
		   {
			   parameterTypes = new Class[]{String.class};  
			   args = new Object[]{new String((String)valueMap.get(attribute))};
		   }
		   else if (attribute.equalsIgnoreCase("Hr_ID"))
		   {
			   parameterTypes = new Class[]{int.class};
			   args = new Object[]{new Integer((Integer)valueMap.get(attribute))};
		   }
		   else if (attribute.equalsIgnoreCase("Designation"))
		   {
			   parameterTypes = new Class[]{String.class};
			   args = new Object[]{new String((String)valueMap.get(attribute))};
		   }
		   else if (attribute.equalsIgnoreCase("Division"))
		   {
			   parameterTypes = new Class[]{String.class};
			   args = new Object[]{new String((String)valueMap.get(attribute))};
		   }
		   try 
		   {
			Person.class.getMethod("set"+attribute, parameterTypes).invoke(this,args);
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
