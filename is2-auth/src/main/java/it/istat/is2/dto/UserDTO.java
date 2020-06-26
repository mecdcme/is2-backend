package it.istat.is2.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String username;

	private String password;

	public UserDTO(Long id, String name, String username, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public UserDTO() {
		super();
	}

 	private String role;

}
