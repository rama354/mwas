package com.mwas.entities;

import java.io.Serializable;
import java.util.Date;

public class Work implements Serializable {
	
	private String company;
	private String division;
	private Date startDate;
	private Date endDate;
	private String designation;
	private String[] projects;
	private String[] awards;
	private String remarks;
	/**
	 * @return the company
	 */
	public synchronized String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public synchronized void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the division
	 */
	public synchronized String getDivision() {
		return division;
	}
	/**
	 * @param division the division to set
	 */
	public synchronized void setDivision(String division) {
		this.division = division;
	}
	/**
	 * @return the startDate
	 */
	public synchronized Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public synchronized void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public synchronized Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public synchronized void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the designation
	 */
	public synchronized String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public synchronized void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the projects
	 */
	public synchronized String[] getProjects() {
		return projects;
	}
	/**
	 * @param projects the projects to set
	 */
	public synchronized void setProjects(String[] projects) {
		this.projects = projects;
	}
	/**
	 * @return the awards
	 */
	public synchronized String[] getAwards() {
		return awards;
	}
	/**
	 * @param awards the awards to set
	 */
	public synchronized void setAwards(String[] awards) {
		this.awards = awards;
	}
	/**
	 * @return the remarks
	 */
	public synchronized String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public synchronized void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
