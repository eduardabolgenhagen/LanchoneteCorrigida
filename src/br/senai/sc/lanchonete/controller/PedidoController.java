package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Pedido;
import br.senai.sc.lanchonete.model.entities.Tipo;
import br.senai.sc.lanchonete.model.service.PedidoService;

import java.util.Collection;

public class PedidoController {
    //Cadastro enviado para o PedidoService
    public boolean cadastrarPedido(Integer codigo, String descricao, double preco, String adicional, Tipo tipo) {
        new PedidoService().cadastrar(Pedido.cadastrar(codigo, descricao, preco, adicional, tipo));
        return true;
    }

    //Buscar pedidos
    public Collection<Pedido> buscarPedidos(Integer tipo) {
        switch (tipo) {
            case 1 -> {
                return (Collection<Pedido>) LancheController.buscarLanches();
            }
            case 2 -> {
                return (Collection<Pedido>) BebidaController.buscarBebidas();
            }
            case 3 -> {
                return (Collection<Pedido>) PorcaoController.buscarPorcoes();
            }
        }
        return null;
    }

    //Buscar pedido por código
    public Pedido buscarPorCodigo(Integer codigo) {
        return new PedidoService().buscarPorCódigo(codigo);
    }

    //Editar pedidos
    public void atualizarPedido(Pedido pedido) {
        new PedidoService().atualizarPedido(pedido);
        return;
    }


}

