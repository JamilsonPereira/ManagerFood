package br.com.managerfood.cmdb.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PedidoDto {

	private Long id;
	private LocalDate dataPedido;
	private Long quantidade;
	private Float valor;
}
