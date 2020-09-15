package org.serratec.backend.mercado.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "pedido_compra")
public class PedidoCompra {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @Temporal(TemporalType.DATE)
  @JsonFormat(pattern = "dd-mm-yyyy")
  @Column(name = "data_pedido_compra", nullable = false)
  private Date dataPedidoCompra;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "pedido_compra_id")
  private Set<ProdutoVendido> produtoVendido;

  public PedidoCompra() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
