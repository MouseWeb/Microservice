package br.com.mouseweb.fornecedor.service;

import br.com.mouseweb.fornecedor.dto.ItemDoPedidoDTO;
import br.com.mouseweb.fornecedor.entity.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido realizaPedido(List<ItemDoPedidoDTO> produtos);

    Pedido getPedidoPorId(Long id);
}
