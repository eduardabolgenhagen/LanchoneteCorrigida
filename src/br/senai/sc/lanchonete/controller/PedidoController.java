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
     * @param codigo    do Pedido
     * @param descricao do Pedido
     * @param preco     do Pedido
     * @param adicional de cada Pedido, que difere conforme o seu tipo
     * @param tipo      do Pedido: Lanche, Bebida ou Porção
     * @autor Eduarda Bolgenhagen De Campos
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
     * Buscar todos os Lanches cadastrados
     *
     * @return Collection de Lanche
     * @autor Eduarda Bolgenhagen De Campos
     */
    public Collection<Lanche> buscarPedidosLanche() throws SQLException {
        return new LancheController().buscarTodosLanches();
    }

    /**
     * Busca todas as Bebidas cadastradas
     *
     * @return Collection de Bebida
     * @autor Eduarda Bolgenhagen De Campos
     */
    public Collection<Bebida> buscarPedidosBebidas() throws SQLException {
        return new BebidaController().buscarTodasBebidas();
    }

    /**
     * Busca todas as porções cadastradas
     *
     * @return Collection de Porção
     * @autor Eduarda Bolgenhagen De Campos
     */
    public Collection<Porcao> buscarPedidosPorcoes() throws SQLException {
        return new PorcaoController().buscarTodasPorcoes();
    }

    /**
     * Remove um tipo de pedido, recebendo os seguintes parâmetros:
     *
     * @param tipo   do Pedido
     * @param codigo do Pedido
     * @autor Eduarda Bolgenhagen De Campos
     */
    public void removerPedido(Integer tipo, Integer codigo) throws SQLException {
        switch (tipo) {
            case 1 -> {
                new LancheController().removerLanche(codigo);
            }
            case 2 -> {
                new BebidaController().removerBebida(codigo);
            }
            case 3 -> {
                new PorcaoController().removerPorcao(codigo);
            }
        }

    }

    /**
     * Edita o preço do pedido já cadastrado, recebendo os seguintes parâmetros:
     *
     * @param tipo      do Pedido
     * @param codigo    do Pedido
     * @param novoPreco a ser atribuído ao Pedido
     * @autor Eduarda Bolgenhagen De Campos
     */
    public void editarPedido(Integer tipo, Integer codigo, double novoPreco) throws SQLException {
        switch (tipo) {
            case 1 -> {
                new LancheController().editarLanche(codigo, novoPreco);
            }
            case 2 -> {
                new BebidaController().editarBebida(codigo, novoPreco);
            }
            case 3 -> {
                new PorcaoController().editarPorcao(codigo, novoPreco);
            }
        }
    }
}

