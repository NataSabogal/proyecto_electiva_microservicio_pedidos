package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import model.Pedido;
import service.PedidoService;

@RestController
@RequestMapping("/farmasync/pedidos")
@Tag(name = "Microservicio de Pedidos", description = "Gestión de pedidos a proveedores")
public class PedidoController {

	private final PedidoService pedidoService;

	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GetMapping("/")
	@Operation(summary = "Página de inicio", description = "Página de bienvenida del servicio de pedidos")
	public String home() {
		return "Servicio de Pedidos funcionando correctamente!!!";
	}

	@PostMapping
	@Operation(summary = "Crear pedido", description = "Registrar un nuevo pedido")
	public Boolean crearPedido(@RequestBody Pedido pedido) {
		return pedidoService.crearPedido(pedido);
	}

	@GetMapping
	@Operation(summary = "Listar pedidos", description = "Obtener todos los pedidos registrados")
	public List<Pedido> listarPedidos() {
		return pedidoService.listarPedidos();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Buscar pedido por ID", description = "Obtener un pedido específico por su ID")
	public Pedido obtenerPedido(@PathVariable String id) {
		return pedidoService.obtenerPedidoPorId(id);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Actualizar pedido", description = "Modificar los datos de un pedido existente")
	public Pedido actualizarPedido(@PathVariable String id, @RequestBody Pedido pedido) {
		pedido.setId(id);
		return pedidoService.actualizarPedido(pedido);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Eliminar pedido", description = "Eliminar un pedido por su identificador")
	public boolean eliminarPedido(@PathVariable String id) {
		return pedidoService.eliminarPedido(id);
	}
}