package org.serratec.java2backend.projeto02.controllers;

import java.util.List;

import org.serratec.java2backend.projeto02.Exceptions.TodoNotFoundException;
import org.serratec.java2backend.projeto02.dominio.Todo;
import org.serratec.java2backend.projeto02.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;

	public List<Todo> getTodo() {
		return todoService.getAll();
	}

	@GetMapping
	public List<Todo> getAll() {
		return todoService.getAll();
	}

	@GetMapping("/{id}")
	public Todo getTodo(@PathVariable Integer id) throws TodoNotFoundException {
		return todoService.getTodo(id);
	}

	@PostMapping
	public Todo postTodo(@RequestBody String todo) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Todo todoObj = objectMapper.readValue(todo, Todo.class);
		return todoService.addTodo(todoObj);
	}
	
	@PutMapping("/{id}")
	public Todo putTodo(@PathVariable Integer id, @RequestBody Todo todo) throws TodoNotFoundException {
		return todoService.updateTodo(id, todo);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable Integer id) throws TodoNotFoundException{
		todoService.deleteTodo(id);
	}
}
