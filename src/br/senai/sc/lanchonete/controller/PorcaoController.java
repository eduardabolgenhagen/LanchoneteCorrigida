package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Porcao;
import br.senai.sc.lanchonete.model.service.PorcaoService;

import java.sql.SQLException;
import java.util.Collection;

public class PorcaoController {

    /**
     * Recebe os parâmetros do PedidoController para enviá-los para PorcaoService para realizar o cadastro
     *
     * @param codigo    do Pedido
     * @param descricao do Pedido
     * @param preco     do Pedido
     * @param adicional do Pedido - tamanho
     * @autor Eduarda Bolgenhagen De Campos
     */
    public void cadastrarPorcao(Integer codigo, String descricao, double preco, String adicional) throws SQLException {
        new PorcaoService().inserirLPorcao(Porcao.cadastrar(codigo, descricao, preco, adicional));
    }

    /**
     * Busca todas as Porções cadastradas
     *
     * @return Collection de Porção
     * @autor Eduarda Bolgenhagen De Campos
     */
    public static Collection<Porcao> buscarTodasPorcoes() throws SQLException {
        return new PorcaoService().buscarPorcoes();
    }

    /**
     * Recebe de PedidoController o código do Pedido a ser removido
     *
     * @param codigo do Pedido
     * @autor Eduarda Bolgenhagen De Campos
     */
    public void removerPorcao(Integer codigo) throws SQLException {
        new PorcaoService().removerPorcao(codigo);
    }

    /**
     * Recebe de PedidoController o código e o novo preço do Pedido a ser editado
     *
     * @param codigo    do Pedido
     * @param novoPreco do Pedido
     * @autor Eduarda Bolgenhagen De Campos
     */
    public void editarPorcao(Integer codigo, double novoPreco) throws SQLException {
        new PorcaoService().editarPorcao(codigo, novoPreco);
    }
}
