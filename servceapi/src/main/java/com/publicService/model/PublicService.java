package com.publicService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PublicService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Float xCoord;
	private Float yCoord;
	private String type;
	
	AccessabilityPoint(int id, Float xcoord, Float ycoord, String type){
		this.id = id;
		this.xCoord = xcoord;
		this.yCoord = ycoord;
		this.type = type;
	}
	
	AccessabilityPoint(){}
	
	public int getId() {
		return this.id;
	}
	
	public String getType() {
		return this.type;
	}
	
	public Float getX() {
		return this.xCoord;
	}
	
	public Float getY() {
		return this.yCoord;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setX(Float x) {
		this.xCoord = x;
	}
	
	public void setY(Float y) {
		this.yCoord = y;
	}
}
