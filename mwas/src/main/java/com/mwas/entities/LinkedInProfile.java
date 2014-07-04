package com.mwas.entities;

import java.io.Serializable;
import java.util.List;

public class LinkedInProfile extends Profile implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int LI_ID;
	private String name;
	private String designation;
	private String summary;
	private List educationHistory;
	private List workHistory;
	private Skill[] skillSet;
	private Group[] groups;
	
	public LinkedInProfile()
	{
		
	}

	/**
	 * @return the lI_ID
	 */
	public int getLI_ID() {
		return LI_ID;
	}

	/**
	 * @param lI_ID the lI_ID to set
	 */
	public synchronized void setLI_ID(int lI_ID) {
		LI_ID = lI_ID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public synchronized void setName(String name) {
		this.name = name;
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
	public synchronized void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public synchronized void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the educationHistory
	 */
	public synchronized List getEducationHistory() {
		return educationHistory;
	}

	/**
	 * @param educationHistory the educationHistory to set
	 */
	public synchronized void setEducationHistory(List educationHistory) {
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
	public synchronized void setWorkHistory(List workHistory) {
		this.workHistory = workHistory;
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
	public synchronized void setSkillSet(Skill[] skillSet) {
		this.skillSet = skillSet;
	}

	/**
	 * @return the groups
	 */
	public Group[] getGroups() {
		return groups;
	}

	/**
	 * @param groups the groups to set
	 */
	public synchronized void setGroups(Group[] groups) {
		this.groups = groups;
	}
	
	 

}
