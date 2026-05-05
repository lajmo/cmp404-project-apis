package com.routes.route_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4173", "http://127.0.0.1:4173", "http://localhost:5173", "http://127.0.0.1:5173"})
@RestController
@RequestMapping
public class RouteController {
	@Autowired
	private AzureMapsService azureMapsService;

	@GetMapping(value = "/route-service-status", produces = MediaType.TEXT_PLAIN_VALUE)
	public String status() {
		return "route-service updated: routes errors return 502 with details";
	}

	@GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> search(@RequestParam String query) {
		try {
			return ResponseEntity.ok(azureMapsService.search(query));
		} catch (Exception error) {
			return ResponseEntity
					.status(HttpStatus.BAD_GATEWAY)
					.contentType(MediaType.TEXT_PLAIN)
					.body(error.getMessage());
		}
	}

	@PostMapping(value = "/routes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> route(@RequestBody RouteRequest routeRequest) {
		try {
			return ResponseEntity.ok(azureMapsService.route(routeRequest));
		} catch (Exception error) {
			return ResponseEntity
					.status(HttpStatus.BAD_GATEWAY)
					.contentType(MediaType.TEXT_PLAIN)
					.body(error.getMessage());
		}
	}
}
