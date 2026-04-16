package com.accesabilityPoints.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AccessabilityPoint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Float xCoord;
	private Float yCoord;
	private int type;
	
	AccessabilityPoint(int id, Float xcoord, Float ycoord, int type){
		this.id = id;
		this.xCoord = xcoord;
		this.yCoord = ycoord;
		this.type = type;
	}
	
	AccessabilityPoint(){}
	
	public int getId() {
		return this.id;
	}
	
	public int getType() {
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
	
	public void setType(int type) {
		this.type = type;
	}
	
	public void setX(Float x) {
		this.xCoord = x;
	}
	
	public void setY(Float y) {
		this.yCoord = y;
	}
}
