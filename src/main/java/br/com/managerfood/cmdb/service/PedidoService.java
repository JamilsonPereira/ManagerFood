package br.com.managerfood.cmdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.managerfood.cmdb.model.Pedido;
import br.com.managerfood.cmdb.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;

	public List<Pedido> listarPedido() {
		List<Pedido> listaPedido = pedidoRepository.findAll();
		return listaPedido;
	}
	public Pedido adicionarPedido(Pedido entity) {
		Pedido retornoPedido = pedidoRepository.save(entity);
		return retornoPedido;
	}

	public Pedido listarPorId(Long id){
		Optional<Pedido> retornoPedidoId = pedidoRepository.findById(id);
		return retornoPedidoId.get();
	}
	public  void deletarPedido(Long id) {
		pedidoRepository.deleteById(id);
	}
}
