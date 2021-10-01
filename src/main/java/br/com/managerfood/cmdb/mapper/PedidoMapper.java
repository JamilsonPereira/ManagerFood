package br.com.managerfood.cmdb.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.managerfood.cmdb.dto.PedidoDto;
import br.com.managerfood.cmdb.model.Pedido;

@Component
public class PedidoMapper {

	public Pedido converteDtoParaEntidade(PedidoDto pedidoDto) {

		Pedido pedido = new Pedido();
		
		pedido.setId(pedidoDto.getId());
		pedido.setDataPedido(pedidoDto.getDataPedido());
		pedido.setQuantidade(pedidoDto.getQuantidade());
		pedido.setValor(pedidoDto.getValor());

		return pedido;
	}

	public PedidoDto converteEntidadeParaDto(Pedido pedido) {
		PedidoDto pedidoDto = new PedidoDto();
		
		pedidoDto.setId(pedido.getId());
		pedidoDto.setDataPedido(pedido.getDataPedido());
		pedidoDto.setQuantidade(pedido.getQuantidade());
		pedidoDto.setValor(pedido.getValor());
		
		
		return pedidoDto;
	}
	
	public List<Pedido> converterListaDtoParaEntidade(List<PedidoDto> listaPedidoDto){
		List<Pedido> listaPedido = new ArrayList<Pedido>();
		for(PedidoDto pedidoDto : listaPedidoDto) {
			
			Pedido pedido = new Pedido();
			
			pedido.setId(pedidoDto.getId());
			pedido.setDataPedido(pedidoDto.getDataPedido());
			pedido.setQuantidade(pedido.getQuantidade());
			pedido.setValor(pedidoDto.getValor());
			
			listaPedido.add(pedido);
		}
		
		return listaPedido;
	}
	
	public List<PedidoDto> converterListaPedidoParaDto(List<Pedido> listaPedido){
		
		List<PedidoDto> listaPedidoDto = new ArrayList<PedidoDto>();
		
		for(Pedido pedido : listaPedido) {
			
			PedidoDto pedidoDto = new PedidoDto();
			
			pedidoDto.setId(pedido.getId());
			pedidoDto.setDataPedido(pedido.getDataPedido());
			pedidoDto.setQuantidade(pedido.getQuantidade());
			pedidoDto.setValor(pedido.getValor());
			
			listaPedidoDto.add(pedidoDto);
		}
		return listaPedidoDto;
	}
	
}
