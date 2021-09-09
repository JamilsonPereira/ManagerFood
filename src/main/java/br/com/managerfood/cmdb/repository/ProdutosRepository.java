package br.com.managerfood.cmdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.managerfood.cmdb.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
	Produtos findById(long id);

}
