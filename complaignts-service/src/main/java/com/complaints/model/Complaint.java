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
	
	public Complaint(int id, Float x, Float y, String description) {
		this.id = id;
		this.xCoord = x;
		this.yCoord = y;
		this.description = description;
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
	
}