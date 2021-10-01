package br.com.managerfood.cmdb.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.managerfood.cmdb.dto.ProdutoDto;
import br.com.managerfood.cmdb.model.Categoria;
import br.com.managerfood.cmdb.model.Produtos;

@Component
public class ProdutoMapper {

	public Produtos converteDtoParaEntidade(ProdutoDto produtoDto) {

		return new Produtos(produtoDto.getId(), produtoDto.getNome(), produtoDto.getDescricao(), produtoDto.getValor());
	}
	
	public ProdutoDto converteEntidadeParaDto(Produtos produtos) {
		return new ProdutoDto(produtos.getId(), produtos.getNome(), produtos.getDescricao(), produtos.getValor());
	}
	
	public List<Produtos> converterListaDtoParaEntidade(List<ProdutoDto> list){

		return list.stream().map(valor -> new Produtos(valor.getId(), valor.getNome(), valor.getDescricao(), valor.getValor()))
				.collect(Collectors.toList());
		
	}
	
	public List<ProdutoDto> converterListaProdutosParaDto(List<Produtos> produtoList){

		return produtoList.stream().map(valor -> new ProdutoDto(valor.getId(), valor.getNome(), valor.getDescricao(), valor.getValor()))
				.collect(Collectors.toList()); 
	}
}
