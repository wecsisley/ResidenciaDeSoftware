package org.serratec.backend.mercado.entidades;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@Entity
@Table(name = "produto_vendido")
public class ProdutoVendido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @DecimalMin(value = "1", inclusive = true)
  @DecimalMax(value = "999", inclusive = true)
  @Column(name = "quantidade", nullable = false, scale = 3)
  private Integer quantidade;

  @ManyToOne
  @JoinColumn(name = "produto_vendido_id", referencedColumnName = "id", nullable = false)
  private Produto produto;

  @OneToOne
  @JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = false)
  private Produto prod;

  public ProdutoVendido() {}

  public ProdutoVendido(
      Integer id,
      @DecimalMin(value = "1", inclusive = true) @DecimalMax(value = "999", inclusive = true)
          Integer quantidade,
      Produto produto,
      Produto prod) {
    this.id = id;
    this.quantidade = quantidade;
    this.produto = produto;
    this.prod = prod;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public Produto getProd() {
    return prod;
  }

  public void setProd(Produto prod) {
    this.prod = prod;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
