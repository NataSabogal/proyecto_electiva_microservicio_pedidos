package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DETALLE_PEDIDO")
public class DetallePedidoEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long idDetalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", nullable = false)
    private PedidoEntity pedido;

    @Column(name = "id_producto_pedido", nullable = false)
    private Long idProductoPedido;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

	public Long getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Long idDetalle) {
		this.idDetalle = idDetalle;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public Long getIdProductoPedido() {
		return idProductoPedido;
	}

	public void setIdProductoPedido(Long idProductoPedido) {
		this.idProductoPedido = idProductoPedido;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
    
    

}
