package org.serratec.backend.projeto01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculadora {

	@RequestMapping("/calculadora")
	public double calculadora(@RequestParam double num1, @RequestParam double num2, 
							@RequestParam String operador) {
		double total = 0;

		switch (operador) {
		case "soma":
			total = num1 + num2;
			break;
		case "subtracao":
			total = num1 - num2;
			break;
		case "multiplicacao":
			total = num1 * num2;
			break;
		case "divisao":
			total = num1 / num2;
			break;
		}

		return total;
	}
}
