package org.saurabh.restexample.messenger.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {
	@QueryParam("year") 
	private int yearPassed;
	@QueryParam("start") 
	private int start;
	@QueryParam("size") 
	private int pageSize;
	
	public int getYearPassed() {
		return yearPassed;
	}
	public void setYearPassed(int yearPassed) {
		this.yearPassed = yearPassed;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
