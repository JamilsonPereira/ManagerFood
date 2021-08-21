package br.com.managerfood.cmdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.managerfood.cmdb.model.Categoria;
import br.com.managerfood.cmdb.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<Categoria>> responseListaCategoria() {

		return ResponseEntity.ok(categoriaService.listarCategoria());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> responseBuscarPorId(@PathVariable(value = "id") long id) {

		return ResponseEntity.ok(categoriaService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria) {

		return ResponseEntity.ok(categoriaService.criarCategoria(categoria));

	}

	@DeleteMapping
	public ResponseEntity<Categoria> deletaCategoria(@RequestBody Categoria categoria) {

		categoriaService.deletarCategoria(categoria);
		return null;

	}
}
