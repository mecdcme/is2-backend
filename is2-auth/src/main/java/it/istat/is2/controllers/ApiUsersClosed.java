package it.istat.is2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.istat.is2.dto.UserDTO;
import it.istat.is2.service.UserService;

@RestController
@RequestMapping(value = "/api/v1/closed/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiUsersClosed {

	@Autowired
	private UserService userservice;

	@GetMapping
	public List<UserDTO> getUsers() {

		return userservice.getUsers();

	}
}
