package com.complaints.complaints_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.complaints.model.Complaint;
import com.complaints.model.ComplaintServices;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {
	
	@Autowired
	private ComplaintServices compService;
	
	@GetMapping
	public List<Complaint> getComplaints(){
		return compService.getComplaints();
	}
	
	@GetMapping(path = "{compid}")
	public Complaint getComplaint(@PathVariable("compid") int id) {
		return compService.getComplaint(id);
	}

	@PostMapping
	public Complaint addComplaint(@RequestBody Complaint acomp) {
		return compService.makeComplaint(acomp);
	}
	
	
	@DeleteMapping(path = "{compid}")
	public String deleteHost(@PathVariable("compid") int id) {
		return compService.removeComplaint(id);
	}
	
}