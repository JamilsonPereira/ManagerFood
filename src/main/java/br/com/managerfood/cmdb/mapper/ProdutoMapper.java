package br.com.managerfood.cmdb.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.managerfood.cmdb.dto.CategoriaDto;
import br.com.managerfood.cmdb.dto.ProdutoDto;
import br.com.managerfood.cmdb.model.Categoria;
import br.com.managerfood.cmdb.model.Produtos;

@Component
public class ProdutoMapper {

	public Produtos converteDtoParaEntidade(ProdutoDto produtoDto) {

		Produtos produto = new Produtos();
		
		produto.setId(produtoDto.getId());
		produto.setDescricao(produtoDto.getDescricao());
		produto.setNome(produtoDto.getNome());
		produto.setValor(produtoDto.getValor());
		
		Categoria categoria = new Categoria();

		categoria.setId(produtoDto.getCategoria().getId());
		categoria.setNome(produtoDto.getNome());
		categoria.setDescricao(produtoDto.getDescricao());

		return produto;

	}

	public ProdutoDto converteEntidadeParaDto(Produtos produtos) {
		return new ProdutoDto(produtos.getId(), produtos.getNome(), produtos.getDescricao(), produtos.getValor(), 
				new CategoriaDto(produtos.getCategoria().getId(), produtos.getCategoria().getNome(), produtos.getCategoria().getDescricao()));
	}

	public List<Produtos> converterListaDtoParaEntidade(List<ProdutoDto> list) {

		return list.stream()
				.map(valor -> new Produtos(valor.getId(), valor.getNome(), valor.getDescricao(), valor.getValor(),
						new Categoria(valor.getCategoria().getId(), valor.getCategoria().getNome(), valor.getCategoria().getDescricao()) ))
				.collect(Collectors.toList());

	}

	public List<ProdutoDto> converterListaProdutosParaDto(List<Produtos> produtoList) {

		return produtoList.stream()
				.map(valor -> new ProdutoDto(valor.getId(), valor.getNome(), valor.getDescricao(), valor.getValor(), 
						new CategoriaDto(valor.getCategoria().getId(), valor.getCategoria().getNome(), valor.getCategoria().getDescricao())))
				.collect(Collectors.toList());
	}
}
