package it.istat.is2.domain;

import java.io.Serializable;
import javax.persistence.*;


import lombok.Data;

@Data
@Entity
@Table(name = "USERS", schema = "public")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String username;

	private String password;

	public User(Long id, String name, String username, String password, UserRole role) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
	}

	public User(User user) {
		this.id = user.id;
		this.name = user.name;
		this.username = user.username;
		this.password = user.password;
	}

	// bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name = "role")
	private UserRole role;

}