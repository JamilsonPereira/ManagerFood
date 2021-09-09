package br.com.managerfood.cmdb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	public Categoria buscarPorId(Long id){

		Optional<Categoria> listarPorId = categoriaRepository.findById(id);
		return listarPorId.get();
	}

	public Categoria criarCategoria(Categoria entity) {
		Categoria retornoCategoria = categoriaRepository.save(entity);
		return retornoCategoria;
	}

	public void deletarCategoria(Long id) {
		categoriaRepository.deleteById(id);
		
	}

}
