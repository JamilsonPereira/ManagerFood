package br.com.managerfood.cmdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.managerfood.cmdb.dto.PedidoDto;
import br.com.managerfood.cmdb.model.Pedido;
import br.com.managerfood.cmdb.service.PedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<PedidoDto>> responseListaDePedidos(){
		return ResponseEntity.ok(pedidoService.listarPedido());
		
	}
	@PostMapping
	public ResponseEntity<PedidoDto> adicionarPedido(@RequestBody PedidoDto entity) {
		return ResponseEntity.ok(pedidoService.adicionarPedido(entity));
	}
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDto> listarPedidoPorId(@PathVariable(value= "id") Long id){
		return ResponseEntity.ok(pedidoService.listarPorId(id));
	}
	@DeleteMapping("/{id}")
	
	public ResponseEntity<Void> deletarPedidoId(@PathVariable(value ="id")Long id){
		
		pedidoService.deletarPedido(id);
		return ResponseEntity.noContent().build(); 
	}
}
