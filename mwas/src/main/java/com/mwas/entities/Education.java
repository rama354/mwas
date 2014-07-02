package com.mwas.entities;

import java.io.Serializable;
import java.util.Date;

public class Education implements Serializable {

	private String university;
	private String college;
	private Date startDate;
	private Date endDate;
	private String major;
	private String degree;
	private float percentile;
	private String remarks;
	/**
	 * @return the university
	 */
	public synchronized String getUniversity() {
		return university;
	}
	/**
	 * @param university the university to set
	 */
	public synchronized void setUniversity(String university) {
		university = university;
	}
	/**
	 * @return the college
	 */
	public synchronized String getCollege() {
		return college;
	}
	/**
	 * @param college the college to set
	 */
	public synchronized void setCollege(String college) {
		college = college;
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
	 * @return the major
	 */
	public synchronized String getMajor() {
		return major;
	}
	/**
	 * @param major the major to set
	 */
	public synchronized void setMajor(String major) {
		major = major;
	}
	/**
	 * @return the degree
	 */
	public synchronized String getDegree() {
		return degree;
	}
	/**
	 * @param degree the degree to set
	 */
	public synchronized void setDegree(String degree) {
		this.degree = degree;
	}
	/**
	 * @return the percentile
	 */
	public synchronized float getPercentile() {
		return percentile;
	}
	/**
	 * @param percentile the percentile to set
	 */
	public synchronized void setPercentile(float percentile) {
		this.percentile = percentile;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
