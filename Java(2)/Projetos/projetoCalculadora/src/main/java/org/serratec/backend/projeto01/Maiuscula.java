package org.serratec.backend.projeto01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Maiuscula {

	
	@RequestMapping("/maiuscula")
	public String maiuscula(@RequestParam String valor) {
		return valor.toUpperCase();
	}
}
