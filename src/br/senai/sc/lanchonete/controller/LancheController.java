package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.service.LancheService;

import java.sql.SQLException;
import java.util.Collection;

public class LancheController {
    /**
     * Recebe de PedidoController os parâmetros para enviá-los para o LacheService cadastrar um Pedido do tipo Lanche
     *
     * @param codigo    do Pedido
     * @param descricao do Pedido
     * @param preco     do Pedido
     * @param adicional do Pedido - peso
     * @autor Eduarda Bolgenhagen De Campos
     */
    public void cadastrarLanche(Integer codigo, String descricao, double preco, double adicional) throws SQLException {
        new LancheService().inserirLanche(Lanche.cadastrar(codigo, descricao, preco, adicional));
    }

    /**
     * Buscar todos os Lanches cadastrados
     *
     * @return Collection de Lanche
     * @autor Eduarda Bolgenhagen De Campos
     */
    public Collection<Lanche> buscarTodosLanches() throws SQLException {
        return new LancheService().buscarLanches();
    }

    /**
     * Recebe de PedidoController o código do Pedido a ser removido do tipo Lanche
     *
     * @param codigo do Pedido
     * @autor Eduarda Bolgenhagen De Campos
     */
    public void removerLanche(Integer codigo) throws SQLException {
        new LancheService().removerLanche(codigo);
    }

    /**
     * Recebe de PedidoController o código e o novo preço para editar o Pedido do tipo Lanche
     *
     * @param codigo    do Pedido
     * @param novoPreco do Pedido
     * @autor Eduarda Bolgenhagen De Campos
     */
    public void editarLanche(Integer codigo, double novoPreco) throws SQLException {
        new LancheService().editarLanche(codigo, novoPreco);
    }
}
