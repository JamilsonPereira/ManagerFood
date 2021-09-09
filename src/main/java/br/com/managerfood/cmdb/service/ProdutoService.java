package br.com.managerfood.cmdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.managerfood.cmdb.model.Produtos;
import br.com.managerfood.cmdb.repository.ProdutosRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutosRepository produtosRepository;

	public List<Produtos> listarProdutos() {
		List<Produtos> produtosLista = produtosRepository.findAll();
		return produtosLista;

	}

	public Produtos adicionarProdutos(Produtos entity) {
		Produtos retornoProdutos = produtosRepository.save(entity);
		return retornoProdutos;
	}
	
	public Produtos buscarProdutosPorId(Long id){
		Optional<Produtos> buscarId = produtosRepository.findById(id); 
		return buscarId.get();
		
	}
	public void deletaProdutos(Long id) {
		produtosRepository.deleteById(id);
	}
}
