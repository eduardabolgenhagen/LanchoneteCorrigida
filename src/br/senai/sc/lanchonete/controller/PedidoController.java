package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Bebida;
import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.entities.Porcao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;

public class PedidoController {
    /**
     * Cadastro sendo enviado para seu respectivo Controller, conforme o seu tipo, passando os seguintes parâmetros:
     *
     * @param codigo
     * @param descricao
     * @param preco
     * @param adicional
     * @param tipo
     */
    public static void cadastrarPedido(Integer codigo, String descricao, double preco, String adicional, Integer tipo)
            throws SQLException {
        switch (tipo) {
            case 1 -> {
                double peso = Double.parseDouble(adicional);
                new LancheController().cadastrarLanche(codigo, descricao, preco, peso);
            }
            case 2 -> {
                double volume = Double.parseDouble(adicional);
                new BebidaController().cadastrarBebida(codigo, descricao, preco, volume);
            }
            case 3 -> {
                new PorcaoController().cadastrarPorcao(codigo, descricao, preco, adicional);
            }
        }
    }

    /**
     * Buscar pedidos no qual direciona para Lanche, Bebida ou Porções dependendo do parâmetro:
     *
     * @param tipo
     * @return
     */
    public Collection<Lanche> buscarPedidosLanche(Integer tipo) throws SQLException {
        return LancheController.buscarTodosLanches();
    }

    public Collection<Bebida> buscarPedidosBebidas(Integer tipo) throws SQLException {
        return BebidaController.buscarTodasBebidas();
    }

    public Collection<Porcao> buscarPedidosPorcoes(Integer tipo) throws SQLException {
        return new PorcaoController().buscarTodasPorcoes();
    }

    public void removerPedido(Integer tipo, Integer codigo) throws SQLException {
        switch (tipo) {
            case 1 -> {
                LancheController.removerLanche(codigo);
            }
            case 2 -> {
//                BebidaController.removerBebida(codigo);
            }
            case 3 -> {
//                PorcaoController.removerPorcao(codigo);
            }
        }

    }


//
//
//
//    //Buscar pedido por código
//
//    /**
//     * Buscar pedido por código, parrando como parâmetro:
//     *
//     * @param codigo
//     */
//    public Pedido buscarPorCodigo(Integer codigo) {
//        return new PedidoService().buscarPorCódigo(codigo);
//    }
//
//    /**
//     * Editar preço do pedido passando como parâmetro:
//     *
//     * @param pedido
//     */
//    //Editar pedidos
//    public void atualizarPedido(Pedido pedido, Double novoPreco) {
//        new PedidoService().atualizarPedido(pedido, novoPreco);
//        return;
//    }


}

