package com.accesabilityPoints.accessabilityApi;

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

import com.accesabilityPoints.model.AccessabilityPoint;
import com.accesabilityPoints.model.AccessabilityPointServices;

@RestController
@RequestMapping("/accessabilityPoint")
public class AccessabilityPointController {
	@Autowired
	private AccessabilityPointServices accessabilityServices;
	
	@GetMapping
	public List<AccessabilityPoint> getAccessabilityPoints(){
		return accessabilityServices.getAccessabilityPoints();
	}
	
	@GetMapping(path="{accessabilityid}")
	public AccessabilityPoint getAccessabilityPoint(@PathVariable("accessabilityid") int id) {
		return accessabilityServices.getAccessabilityPoint(id);
	}
	
	
	@PostMapping
	public AccessabilityPoint createAccessabilityPoint(@RequestBody AccessabilityPoint a) {
		return accessabilityServices.createAccessabilityPoint(a);
	}
	
	@PutMapping
	public AccessabilityPoint updateAccessabilityPoint (@RequestBody AccessabilityPoint a) {
		return accessabilityServices.updateAccessabilityPoint(a);
	}
 
	@DeleteMapping(path = "{accessabilityid}")
	public String removeAccessabilityPoint(@PathVariable("accessabilityid") int id) {
		return accessabilityServices.removeAccessabilityPoint(id);
	}

}
