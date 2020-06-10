package it.istat.is2.gsbpm.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class GsbpmDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4938433927233324394L;
	private Long id;
	private String name;
	private String description;

	public GsbpmDTO() {
		super();
		
	}
	public GsbpmDTO(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

}
