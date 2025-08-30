package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "Microservicio de Pedidos", description = "Gestión de pedidos a proveedores")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

//    @GetMapping("/mensaje")
//    @Operation(summary = "Mensaje de prueba", description = "Verificar que el microservicio de pedidos está activo")
//    public String mostrarMensaje() {
//        return pedidoService.obtenerMensaje();
//    }

    @GetMapping("/")
    @Operation(summary = "Página de inicio", description = "Página de bienvenida del servicio de pedidos")
    public String home() {
        return "Servicio de Pedidos funcionando correctamente!!!";
    }
}