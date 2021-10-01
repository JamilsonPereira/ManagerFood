package br.com.managerfood.cmdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.managerfood.cmdb.dto.PedidoDto;
import br.com.managerfood.cmdb.mapper.PedidoMapper;
import br.com.managerfood.cmdb.model.Pedido;
import br.com.managerfood.cmdb.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PedidoMapper pedidoMapper;

	public List<PedidoDto> listarPedido() {
		List<PedidoDto> listaPedido = pedidoMapper.converterListaPedidoParaDto(pedidoRepository.findAll());
		return listaPedido;
	}
	public PedidoDto adicionarPedido(PedidoDto dto) {
		Pedido retornoPedido = pedidoMapper.converteDtoParaEntidade(dto);
			Pedido retornoEntidade =	pedidoRepository.save(retornoPedido);
		return pedidoMapper.converteEntidadeParaDto(retornoEntidade);
	}

	public PedidoDto listarPorId(Long id){
		PedidoDto retornoPedidoId = pedidoMapper.converteEntidadeParaDto(pedidoRepository.findById(id).get());
		return retornoPedidoId;
	}
	public  void deletarPedido(Long id) {
		pedidoRepository.deleteById(id);
	}
}
