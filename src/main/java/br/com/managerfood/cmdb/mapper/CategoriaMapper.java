package br.com.managerfood.cmdb.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.managerfood.cmdb.dto.CategoriaDto;
import br.com.managerfood.cmdb.model.Categoria;

@Component
public class CategoriaMapper {

	public Categoria converterDtoParaEntidade(CategoriaDto categoriaDto) {
		Categoria cat = new Categoria();

		cat.setId(categoriaDto.getId());
		cat.setNome(categoriaDto.getNome());
		cat.setDescricao(categoriaDto.getDescricao());

		return cat;

	}

	public CategoriaDto converterEntidadeParaDto(Categoria categoria) {

		return new CategoriaDto(categoria.getId(), categoria.getNome(), categoria.getDescricao());

	}

	public List<Categoria> converterListaDtoParaEntidade(List<CategoriaDto> listaCatDto) {

		return listaCatDto.stream().map(valor -> new Categoria(valor.getId(), valor.getNome(), valor.getDescricao()))
				.collect(Collectors.toList());

	}

	public List<CategoriaDto> converterListaCategoriaParaDto(List<Categoria> listaCat) {

		List<CategoriaDto> listaCategoriaDto = new ArrayList<CategoriaDto>();

		for (Categoria categoria : listaCat) {

			CategoriaDto catDto = new CategoriaDto();

			catDto.setId(categoria.getId());
			catDto.setNome(categoria.getNome());
			catDto.setDescricao(categoria.getDescricao());

			listaCategoriaDto.add(catDto);
		}

		return listaCategoriaDto;

	}
}
