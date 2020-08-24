package org.serratec.backend.mercado.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vendedor")
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;

	@NotNull
	@Size(min = 3, max = 20)
	@Column(name = "matricula", nullable = false, length = 20)
	private String matricula;

	public Vendedor() {
		super();
	}

	public Vendedor(Integer id, @NotNull @Size(min = 3, max = 50) String nome,
			@NotNull @Size(min = 3, max = 20) String matricula) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
