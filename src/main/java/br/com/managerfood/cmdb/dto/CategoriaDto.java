package br.com.managerfood.cmdb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {

	private Long id;
	private String nome;
	private String descricao;
	
}
