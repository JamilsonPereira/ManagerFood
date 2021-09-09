package br.com.managerfood.cmdb.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "dataPedido")
	private LocalDate dataPedido;
	@Column(name = "quantidade")
	private Long quantidade;
	@Column(name = "valor")
	private Float valor;

}
