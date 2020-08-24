package org.serratec.backend.mercado.entidades;

import java.util.Date;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Size(min = 3, max = 40)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "categoria_id", referencedColumnName = "id", nullable = false)
	private Categoria categoria;

	@NotNull
	@Size(min = 10, max = 20)
	@Column(name = "codigoDeBarras", nullable = false, length = 20, unique = true)
	private Integer codigoDeBarras;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-mm-yyyy")
	@Column(name = "data_fabricacao", nullable = false)
	private Date dataFabricacao;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "produto_fornecedor", joinColumns = @JoinColumn(name = "produto_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "fornecedor_id", referencedColumnName = "id"))
	private Set<Fornecedor> fornecedor;

	public Produto() {
		super();
	}

	public Produto(Integer id, @NotNull @Size(min = 3, max = 40) String nome, Categoria categoria,
			@NotNull @Size(min = 10, max = 20) Integer codigoDeBarras, Date dataFabricacao,
			Set<Fornecedor> fornecedor) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.codigoDeBarras = codigoDeBarras;
		this.dataFabricacao = dataFabricacao;
		this.fornecedor = fornecedor;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(Integer codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Set<Fornecedor> getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Set<Fornecedor> fornecedor) {
		this.fornecedor = fornecedor;
	}

}
