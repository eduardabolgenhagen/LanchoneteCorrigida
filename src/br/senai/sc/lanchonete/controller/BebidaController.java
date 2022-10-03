package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Bebida;
import br.senai.sc.lanchonete.model.service.BebidaService;

import java.sql.SQLException;
import java.util.Collection;

public class BebidaController {

    /**
     * Recebe os parâmetros do PedidoController para enviá-los para BebidaService para cadastrar um novo pedido
     *
     * @param codigo    do Pedido
     * @param descricao do Pedido
     * @param preco     do Pedido
     * @param adicional de Bebida - volume
     * @autor Eduarda Bolgenhagen De Campos
     */
    public void cadastrarBebida(Integer codigo, String descricao, double preco, double adicional) throws SQLException {
        new BebidaService().inserirBebida(Bebida.cadastrar(codigo, descricao, preco, adicional));
    }

    /**
     * Buscar todas as Bebidas cadastradas
     *
     * @return Collection de Bebida
     * @autor Eduarda Bolgenhagen De Campos
     */
    public Collection<Bebida> buscarTodasBebidas() throws SQLException {
        return new BebidaService().buscarBebidas();
    }

    /**
     * Recebe o código do Pedido através do PedidoController para remover algum Pedido do tipo Bebida
     *
     * @param codigo do Pedido
     * @autor Eduarda Bolgenhagen De Campos
     */
    public void removerBebida(Integer codigo) throws SQLException {
        new BebidaService().removerBebida(codigo);
    }

    /**
     * Recebe de PedidoController o código e o novo preço para editar um Pedido do tipo Bebida
     *
     * @param codigo    do Pedido
     * @param novoPreco do Pedido
     * @autor Eduarda Bolgenhagen De Campos
     */
    public void editarBebida(Integer codigo, double novoPreco) {
        new BebidaService().editarBebida(codigo, novoPreco);
    }
}






