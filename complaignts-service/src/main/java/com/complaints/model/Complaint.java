package com.complaints.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Float xCoord;
	private Float yCoord;
	private String description;
	private Boolean approved;
	
	public Complaint(int id, Float x, Float y, String description, Boolean approved) {
		this.id = id;
		this.xCoord = x;
		this.yCoord = y;
		this.description = description;
		this.setApproved(approved);
	}
	
	public Complaint() {}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	
	public float getXCoord() {
		return this.xCoord;
	}
	public void setXCoord(Float x) {
		this.xCoord = x;
	}
	
	public float getYCoord() {
		return this.yCoord;
	}
	public void setYCoord(Float y) {
		this.yCoord = y;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String d) {
		this.description = d;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	
}