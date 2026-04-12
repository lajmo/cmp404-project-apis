package com.complaints.model;

import java.util.List;

public class ComplaintServices {
	private ComplaintRepository compRepo;
	
	public List<Complaint> getComplaints(){
		return compRepo.findAll();
	}
	
	public Complaint getComplaint(int id) {
		return compRepo.findById(id).orElse(null);
	}
	
	public Complaint makeComplaint(Complaint c) {
		return compRepo.save(c);
	}
	
	public String removeComplaint(int id) {
		if(compRepo.existsById(id)) {
			compRepo.deleteById(id);
			return "Complaint Removed";
		}
		else {
			return "Error";
		}

	}

}