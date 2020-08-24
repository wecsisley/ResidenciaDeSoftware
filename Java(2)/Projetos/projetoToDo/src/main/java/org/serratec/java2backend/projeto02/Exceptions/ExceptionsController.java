package org.serratec.java2backend.projeto02.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsController {

	@ExceptionHandler(TodoNotFoundException.class)
	public ResponseEntity<String> trataTodoNotFound(TodoNotFoundException exception) {
		String msg = String.format("O Todo com o ID %d não foi encontrado.", exception.getId());
		return ResponseEntity.notFound().header("x-erro-msg", msg).header("x-erro-code", "TODO_NOT_FOUND")
				.header("x-erro-value", exception.getId().toString()).build();

	}
}
