package br.com.managerfood.cmdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.managerfood.cmdb.model.Categoria;
import br.com.managerfood.cmdb.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> listarCategoria() {

		List<Categoria> listaCategoria = categoriaRepository.findAll();
		return listaCategoria;
	}

	public Categoria buscarPorId(@PathVariable(value = "id") long id) {

		Categoria listarPorId = categoriaRepository.findById(id);
		return listarPorId;
	}

	public Categoria criarCategoria(Categoria entity) {
		Categoria retornoCategoria = categoriaRepository.save(entity);
		return retornoCategoria;
	}

	public void deletarCategoria(Categoria entity) {
		categoriaRepository.delete(entity);
		
	}

}
