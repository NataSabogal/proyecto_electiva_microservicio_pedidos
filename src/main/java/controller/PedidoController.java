package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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

	@PostMapping
	@Operation(summary = "Crear pedido", description = "Registrar un nuevo pedido")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Pedido creado exitosamente"),
			@ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud") })
	public ResponseEntity<Pedido> crearPedido(@Valid @RequestBody Pedido pedido) {
		Pedido nuevoPedido = pedidoService.crearPedido(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedido);
	}

	@GetMapping
	@Operation(summary = "Listar pedidos", description = "Obtener todos los pedidos registrados")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de pedidos obtenida exitosamente") })
	public ResponseEntity<List<Pedido>> listarPedidos() {
		return ResponseEntity.ok(pedidoService.listarPedidos());
	}

	@GetMapping("/{id}")
	@Operation(summary = "Buscar pedido por ID", description = "Obtener un pedido específico por su ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Pedido encontrado"),
			@ApiResponse(responseCode = "404", description = "Pedido no encontrado") })
	public ResponseEntity<Pedido> obtenerPedido(
			@Parameter(description = "ID del pedido", required = true) @PathVariable String id) {
		Pedido pedido = pedidoService.obtenerPedidoPorId(id);
		if (pedido != null) {
			return ResponseEntity.ok(pedido);
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Operation(summary = "Actualizar pedido", description = "Modificar los datos de un pedido existente")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Pedido actualizado exitosamente"),
			@ApiResponse(responseCode = "400", description = "Datos inválidos"),
			@ApiResponse(responseCode = "404", description = "Pedido no encontrado") })
	public ResponseEntity<Pedido> actualizarPedido(
			@Parameter(description = "ID del pedido a actualizar", required = true) @PathVariable String id,
			@Valid @RequestBody Pedido pedido) {
		pedido.setId(id);
		Pedido actualizado = pedidoService.actualizarPedido(pedido);
		if (actualizado != null) {
			return ResponseEntity.ok(actualizado);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Eliminar pedido", description = "Eliminar un pedido por su identificador")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Pedido eliminado exitosamente"),
			@ApiResponse(responseCode = "404", description = "Pedido no encontrado") })
	public ResponseEntity<Void> eliminarPedido(
			@Parameter(description = "ID del pedido a eliminar", required = true) @PathVariable String id) {
		boolean eliminado = pedidoService.eliminarPedido(id);
		if (eliminado) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}