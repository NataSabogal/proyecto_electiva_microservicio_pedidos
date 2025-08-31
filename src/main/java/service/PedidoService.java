package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Pedido;
import repository.PedidoRepository;

@Service

public class PedidoService {

	@Autowired

	private PedidoRepository repository;

	public Pedido crearPedido(Pedido pedido) {
		return repository.save(pedido);
	}

	public Pedido obtenerPedidoPorId(String id) {
		return repository.findById(id);
	}

	public List<Pedido> listarPedidos() {
		return repository.findAll();
	}

	public Pedido actualizarPedido(Pedido pedido) {
		return repository.update(pedido);
	}

	public boolean eliminarPedido(String id) {
		return repository.delete(id);
	}

}
