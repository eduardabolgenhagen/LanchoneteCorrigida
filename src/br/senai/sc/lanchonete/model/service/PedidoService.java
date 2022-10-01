package br.senai.sc.lanchonete.model.service;

import br.senai.sc.lanchonete.model.dao.PedidoDAO;
import br.senai.sc.lanchonete.model.entities.Pedido;

public class PedidoService {

    /**
     * Mandar pedido para PedidoDAO, como parâmetro:
     *
     * @param pedido
     */
    public void cadastrar(Pedido pedido) {
        new PedidoDAO().inserir(pedido);
    }

    /**
     * Buscar pedido específico, passando o parâmetro:
     *
     * @param codigo
     */
//    public Pedido buscarPorCódigo(Integer codigo) {
//        return PedidoDAO.buscarPorCodigo(codigo);
//    }

    /**
     * Mandar para atualizar em PedidoDAO com os seguintes parâmetros:
     *
     * @param codigoPedido
     * @param pedido
     */
    public void atualizar(Integer codigoPedido, Pedido pedido) {
        new PedidoDAO().atualizarPedido(codigoPedido, pedido);
    }

    /**
     * Trazer parâmetros do Controller e atualizar o objeto
     *
     * @param pedido
     * @param novoPreco
     */
    public void atualizarPedido(Pedido pedido, double novoPreco) {
        pedido.setPreco(novoPreco);
        atualizar(pedido.getCodigo(), pedido);
    }

}


