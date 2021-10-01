package br.com.managerfood.cmdb.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.managerfood.cmdb.dto.CategoriaDto;
import br.com.managerfood.cmdb.mapper.CategoriaMapper;
import br.com.managerfood.cmdb.model.Categoria;
import br.com.managerfood.cmdb.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private CategoriaMapper categoriaMapper;
	
	
	public List<CategoriaDto> listarCategoria() {

		List<CategoriaDto> listaCategoria = categoriaMapper.converterListaCategoriaParaDto(categoriaRepository.findAll()) ;
		return listaCategoria;
	}

	public CategoriaDto buscarPorId(Long id){

	    CategoriaDto listarPorId = categoriaMapper.converterEntidadeParaDto(categoriaRepository.findById(id).get());
		return listarPorId;
	}

	public CategoriaDto criarCategoria(CategoriaDto dto) {
		Categoria retornoCategoria = categoriaMapper.converterDtoParaEntidade(dto); 
		Categoria retornoEntidade =	categoriaRepository.save(retornoCategoria);
				 
		return categoriaMapper.converterEntidadeParaDto(retornoEntidade);
	}

	public void deletarCategoria(Long id) {
		categoriaRepository.deleteById(id);
		
	}

}
