package com.publicService.servceapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.publicService.model.PublicService;
import com.publicService.model.PublicServiceServices;

@RestController
@RequestMapping("/publicService")
public class PublicServiceController {
	@Autowired
	private PublicServiceServices services;
	
	@GetMapping
	public List<PublicService> getAccessabilityPoints(){
		return services.getPublicServices();
	}
	
	@GetMapping(path="{serviceid}")
	public PublicService getAccessabilityPoint(@PathVariable("serviceid") int id) {
		return services.getPublicService(id);
	}
	
	
	@PostMapping
	public PublicService createAccessabilityPoint(@RequestBody PublicService p) {
		return services.createPublicService(p);
	}
	
	@PutMapping
	public PublicService updateAccessabilityPoint (@RequestBody PublicService p) {
		return services.updatePublicService(p);
	}
 
	@DeleteMapping(path = "{accessabilityid}")
	public String removeAccessabilityPoint(@PathVariable("serviceid") int id) {
		return services.removePublicService(id);
	}

}
