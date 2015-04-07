package com.springmvc.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cv_exppro")
public class PersonCVExpPro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String client;
	private String activityClient;
	private String place;
	private String function;
	private Date dateBegin;
	private Date dateEnd;
	private String summaryMission;
	private String detailsMission;
	private String activityMission;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getActivityClient() {
		return activityClient;
	}
	public void setActivityClient(String activityClient) {
		this.activityClient = activityClient;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public Date getDateBegin() {
		return dateBegin;
	}
	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public String getSummaryMission() {
		return summaryMission;
	}
	public void setSummaryMission(String summaryMission) {
		this.summaryMission = summaryMission;
	}
	public String getDetailsMission() {
		return detailsMission;
	}
	public void setDetailsMission(String detailsMission) {
		this.detailsMission = detailsMission;
	}
	public String getActivityMission() {
		return activityMission;
	}
	public void setActivityMission(String activityMission) {
		this.activityMission = activityMission;
	}
	
	public PersonCVExpPro(String client, String activityClient, String place,
			String function, Date dateBegin, Date dateEnd,
			String summaryMission, String detailsMission, String activityMission) {
		super();
		this.client = client;
		this.activityClient = activityClient;
		this.place = place;
		this.function = function;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.summaryMission = summaryMission;
		this.detailsMission = detailsMission;
		this.activityMission = activityMission;
	}
	
	public PersonCVExpPro() {
		
	}
	
	
}
