package br.com.mouseweb.fornecedor.repository;

import br.com.mouseweb.fornecedor.entity.InfoFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository  extends JpaRepository<InfoFornecedor, Long> {
    InfoFornecedor findByEstado(String estado);
}
