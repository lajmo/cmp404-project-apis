package com.complaints.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.model.User;

@Service
public class ComplaintServices {
	
	@Autowired
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
	
	public Complaint updateComplaint (Complaint ac) {
		if(compRepo.existsById(ac.getId())) {
			compRepo.save(ac);
			return ac;
		}
		else {
			return null;
		}
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