package br.com.mouseweb.fornecedor.repository;

import br.com.mouseweb.fornecedor.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
