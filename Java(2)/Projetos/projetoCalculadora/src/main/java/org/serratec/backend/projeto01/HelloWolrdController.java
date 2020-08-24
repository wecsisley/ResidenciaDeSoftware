package org.serratec.backend.projeto01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWolrdController {
	
	@RequestMapping("/ola")
	public String olaMundo() {
		return "Ola Mundo";
	}

}
