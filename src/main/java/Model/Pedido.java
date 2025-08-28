package Model;

public class Pedido {
	
	private String nombre;
	private String id;
	private String descripcion;
	private int cantidad;
	private double total;
	private String estado;
	
	public Pedido(String nombre, String id, String descripcion, int cantidad, double total, String estado) {
		this.nombre = nombre;
		this.id = id;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.total = total;
		this.estado = estado;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
