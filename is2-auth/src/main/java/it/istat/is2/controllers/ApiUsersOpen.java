package it.istat.is2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.istat.is2.dao.UserDao;
import it.istat.is2.dto.UserDTO;
import it.istat.is2.service.UserService;

@RestController
@RequestMapping(value = "/api/v1/open/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiUsersOpen {

	@Autowired
	private UserService userservice;

	@PostMapping
	public UserDTO createUser(@RequestParam(name = "username", required = true) final String username,
			@RequestParam(name = "password", required = true) final String password,
			@RequestParam(name = "name", required = false) final String name,
			@RequestParam(name = "role") final Long role) {

		return userservice.createUser(username, password, name, role);

	}
}
