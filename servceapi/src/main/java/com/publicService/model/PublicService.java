package com.publicService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PublicService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Float xCoord;
	private Float yCoord;
	private String type;
	
	public PublicService(Integer id, Float xcoord, Float ycoord, String type){
		this.id = id;
		this.xCoord = xcoord;
		this.yCoord = ycoord;
		this.type = type;
	}
	
	public PublicService(){}
	
	public Integer getId() {
		return this.id;
	}
	
	public String getType() {
		return this.type;
	}
	
	public Float getXCoord() {
		return this.xCoord;
	}
	
	public Float getYCoord() {
		return this.yCoord;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setXCoord(Float x) {
		this.xCoord = x;
	}
	
	public void setYCoord(Float y) {
		this.yCoord = y;
	}
}
