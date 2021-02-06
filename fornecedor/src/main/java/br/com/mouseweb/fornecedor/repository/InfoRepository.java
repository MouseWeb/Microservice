package br.com.mouseweb.fornecedor.repository;

import br.com.mouseweb.fornecedor.entity.InfoFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface InfoRepository extends CrudRepository<InfoFornecedor, Long> {
    InfoFornecedor findByEstado(String estado);
}
