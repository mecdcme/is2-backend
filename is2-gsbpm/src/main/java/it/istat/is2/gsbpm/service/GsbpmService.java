package it.istat.is2.gsbpm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.istat.is2.gsbpm.dto.GsbpmDTO;

@Service
public class GsbpmService {

	public List<GsbpmDTO> getGsbpms() {
		
		List<GsbpmDTO> gsbpms=new ArrayList<>();
		gsbpms.add(new GsbpmDTO(1L, "gsbpm1 name", "gsbpm1 description"));
		gsbpms.add(new GsbpmDTO(2L, "gsbpm2 name", "gsbpm2 description"));
		gsbpms.add(new GsbpmDTO(3L, "gsbpm3 name", "gsbpm3 description"));
		return gsbpms;
	}

}
