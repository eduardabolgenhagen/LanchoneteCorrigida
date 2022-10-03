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
     * @return
     */
    public Collection<Lanche> buscarPedidosLanche() throws SQLException {
        return new LancheController().buscarTodosLanches();
    }

    public Collection<Bebida> buscarPedidosBebidas() throws SQLException {
        return new BebidaController().buscarTodasBebidas();
    }

    public Collection<Porcao> buscarPedidosPorcoes() throws SQLException {
        return new PorcaoController().buscarTodasPorcoes();
    }

    public void removerPedido(Integer tipo,Integer codigo) throws SQLException {
        switch (tipo) {
            case 1 -> {
                new LancheController().removerLanche(codigo);
            }
            case 2 -> {
                new BebidaController().removerBebida(codigo);
            }
            case 3 -> {
//                PorcaoController().removerPorcao(codigo);
            }
        }

    }

    public void editarPedido(Integer tipo, Integer codigo, double novoPreco){
        switch (tipo){
            case 1 -> {
                new LancheController().editarLanche(codigo, novoPreco);
            }
            case 2 ->{
//                new BebidaController().editarBebida(codigo, novoPreco);
            }
            case 3 ->{
//                new PorcaoController().editarPorcao(codigo, novoPreco);
            }
        }
    }

//    /**
//     * Buscar pedido por código, parrando como parâmetro:
//     *
//     * @param codigo
//     */
//    public Pedido buscarPorCodigo(Integer codigo) {
//        return new PedidoService().buscarPorCódigo(codigo);
//    }




}

