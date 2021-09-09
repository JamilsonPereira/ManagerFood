package br.com.managerfood.cmdb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.managerfood.cmdb.model.Produtos;
import br.com.managerfood.cmdb.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoService produtosService;

	@GetMapping
	public ResponseEntity<List<Produtos>> responseProdutos() {

		return ResponseEntity.ok(produtosService.listarProdutos());
	}

	@PostMapping
	public ResponseEntity<Produtos> adicionarProdutos(@RequestBody Produtos produtos) {

		return ResponseEntity.ok(produtosService.adicionarProdutos(produtos));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produtos> responseBuscaId(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok(produtosService.buscarProdutosPorId(id));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarProdutos(@PathVariable(value = "id") Long id) {
		produtosService.deletaProdutos(id);
		return ResponseEntity.noContent().build();

	}
}
