package com.publicService.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class PublicServiceServices {
	@Autowired
	private PublicServiceRepo ServiceRepo;
	
	public List<PublicService> getPublicServices(){
		return ServiceRepo.findAll();
	}
	
	public PublicService getPublicService(int id) {
		return accessabilityRepo.findById(id).orElse(null);
	}
	
	public PublicService createPublicService(PublicService p) {
		return ServiceRepo.save(p);
	}
	
	public PublicService updatePublicService (PublicService p) {
		if(ServiceRepo.existsById(p.getId())) {
			ServiceRepo.save(p);
			return p;
		}
		else {
			return null;
		}
	}
 
	
	public String removePublicService(int id) {
		if(ServiceRepo.existsById(id)) {
			ServiceRepo.deleteById(id);
			return "Accessability point Removed";
		}
		else {
			return "Error";
		}

	}

}
