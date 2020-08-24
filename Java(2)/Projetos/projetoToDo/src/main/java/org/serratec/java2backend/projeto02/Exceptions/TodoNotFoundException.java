package org.serratec.java2backend.projeto02.Exceptions;

public class TodoNotFoundException extends Exception{

	private static final long serialVersionUID = -7580404419897048916L;
	private Integer id;
	
	public TodoNotFoundException(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}
