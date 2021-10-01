package br.com.managerfood.cmdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.managerfood.cmdb.dto.ProdutoDto;
import br.com.managerfood.cmdb.mapper.PedidoMapper;
import br.com.managerfood.cmdb.mapper.ProdutoMapper;
import br.com.managerfood.cmdb.model.Produtos;
import br.com.managerfood.cmdb.repository.ProdutosRepository;

@Service
public class ProdutoService {
	@Autowired
	ProdutosRepository produtosRepository;
	
	@Autowired
    ProdutoMapper produtosMapper;

	public List<ProdutoDto> listarProdutos() {
		List<ProdutoDto> produtosLista = produtosMapper.converterListaProdutosParaDto(produtosRepository.findAll());
		return produtosLista;

	}

	public ProdutoDto adicionarProdutos(ProdutoDto produtoDto) {
		Produtos retornoProdutos = produtosMapper.converteDtoParaEntidade(produtoDto);
		Produtos retornoEntidade = produtosRepository.save(retornoProdutos);
		return produtosMapper.converteEntidadeParaDto(retornoEntidade);
	}
	
	public ProdutoDto buscarProdutosPorId(Long id){
		ProdutoDto buscarId = produtosMapper.converteEntidadeParaDto( produtosRepository.findById(id).get()); 
		return buscarId;
		
	}
	public void deletaProdutos(Long id) {
		produtosRepository.deleteById(id);
	}
}
