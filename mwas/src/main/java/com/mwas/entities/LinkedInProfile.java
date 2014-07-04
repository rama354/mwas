package com.mwas.entities;

import java.io.Serializable;
import java.util.List;

public class LinkedInProfile extends Profile implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final int LI_ID;
	private String name;
	private String designation;
	private String summary;
	private List educationHistory;
	private List workHistory;
	private Skill[] skillSet;
	private Group[] groups;
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	public LinkedInProfile(int LI_ID)
	{
		this.LI_ID=LI_ID;
	}
	/**
	 * @return the fMID
	 */
	public final int getLI_ID() 
	{
		return LI_ID;
	}
	/**
	 * @return the educationHistory
	 */
	public List getEducationHistory() {
		return educationHistory;
	}
	/**
	 * @param educationHistory the educationHistory to set
	 */
	public void setEducationHistory(List educationHistory) {
		this.educationHistory = educationHistory;
	}
	/**
	 * @return the workHistory
	 */
	public List getWorkHistory() {
		return workHistory;
	}
	/**
	 * @param workHistory the workHistory to set
	 */
	public void setWorkHistory(List workHistory) {
		this.workHistory = workHistory;
	}
	/**
	 * @return the profile
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * @return the skillSet
	 */
	public Skill[] getSkillSet() {
		return skillSet;
	}
	/**
	 * @param skillSet the skillSet to set
	 */
	public void setSkillSet(Skill[] skillSet) {
		this.skillSet = skillSet;
	}
	/**
	 * @return the groups
	 */
	public Group[] getGroups() 
	{
		return groups;
	}
	/**
	 * @param groups the groups to set
	 */
	public void setGroups(Group[] groups) 
	{
		this.groups = groups;
	}

}
