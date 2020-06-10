package it.istat.is2.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name="ROLES" ,schema = "public")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="NAME")
	private String name;

	

}