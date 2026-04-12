package com.complaints.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	double x_coord;
	double y_coord;
	String description;
	
	public Complaint(int id, double x, double y, String description) {
		this.id = id;
		this.x_coord = x;
		this.y_coord = y;
		this.description = description;
	}
	
	public Complaint() {}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	
	public double getXCoord() {
		return this.x_coord;
	}
	public void setXCoord(double x) {
		this.x_coord = x;
	}
	
	public double getYCoord() {
		return this.y_coord;
	}
	public void setYCoord(double y) {
		this.y_coord = y;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String d) {
		this.description = d;
	}
	
}