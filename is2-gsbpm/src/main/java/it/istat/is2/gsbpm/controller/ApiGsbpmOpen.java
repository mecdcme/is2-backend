package it.istat.is2.gsbpm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.istat.is2.gsbpm.dto.GsbpmDTO;
import it.istat.is2.gsbpm.service.GsbpmService;

@RestController
@RequestMapping(value = "/api/v1/open/gsbpm", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiGsbpmOpen {

	@Autowired
	GsbpmService gsbpmService;

	@GetMapping
    public  ResponseEntity<List<GsbpmDTO>> getGsbpms() {
    
    	        return ResponseEntity.ok(gsbpmService.getGsbpms());
 

    }
}
