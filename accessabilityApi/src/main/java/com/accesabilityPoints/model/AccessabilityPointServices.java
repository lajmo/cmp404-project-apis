package com.accesabilityPoints.model;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessabilityPointServices{
	@Autowired
	private AccessabilityPointsRepository accessabilityRepo;
	
	public List<AccessabilityPoint> getAccessabilityPoints(){
		return accessabilityRepo.findAll();
	}
	
	public AccessabilityPoint getAccessabilityPoint(int id) {
		return accessabilityRepo.findById(id).orElse(null);
	}
	
	public AccessabilityPoint createAccessabilityPoint(AccessabilityPoint a) {
		return accessabilityRepo.save(a);
	}
	
	public AccessabilityPoint updateAccessabilityPoint (AccessabilityPoint a) {
		if(accessabilityRepo.existsById(a.getId())) {
			accessabilityRepo.save(a);
			return a;
		}
		else {
			return null;
		}
	}
 
	
	public String removeAccessabilityPoint(int id) {
		if(accessabilityRepo.existsById(id)) {
			accessabilityRepo.deleteById(id);
			return "Accessability point Removed";
		}
		else {
			return "Error";
		}

	}

}