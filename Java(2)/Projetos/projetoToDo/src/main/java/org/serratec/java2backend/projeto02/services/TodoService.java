package org.serratec.java2backend.projeto02.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.serratec.java2backend.projeto02.Exceptions.TodoNotFoundException;
import org.serratec.java2backend.projeto02.dominio.Todo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private List<Todo> todos = new ArrayList<>(Arrays.asList(new Todo(1, "Comrpas", "Ir no mercado e fazer comrpas"),
			new Todo(2, "Remedio", "Passar na farmacia com a receita"),
			new Todo(3, "Aula", "Ir no mercado e fazer comrpas")));

	private Todo findTodo(Integer id) throws TodoNotFoundException {
		Todo achado = null;
		for (Todo todo : todos) {
			if (todo.getId().equals(id)) {
				achado = todo;
				break;
			}
		}
		if (achado == null) {
			throw new TodoNotFoundException(id);
		}
		return achado;
	}

	public Todo getTodo(Integer id) throws TodoNotFoundException {
		return findTodo(id);
	}

	public List<Todo> getAll() {
		return todos;
	}

	public Todo addTodo(Todo todo) {
		todos.add(todo);
		return todo;
	}

	public Todo updateTodo(Integer id, Todo todoNovo) throws TodoNotFoundException {
		Todo achado = findTodo(id);
		if (todoNovo.getId() != null)
			achado.setId(todoNovo.getId());
		if (todoNovo.getTitulo() != null)
			achado.setTitulo(todoNovo.getTitulo());
		if (todoNovo.getDescricao() != null)
			achado.setDescricao(todoNovo.getDescricao());
		return achado;
	}

	public void deleteTodo(Integer id) throws TodoNotFoundException {
		Todo todo = findTodo(id);
		todos.remove(todo);
	}

}
