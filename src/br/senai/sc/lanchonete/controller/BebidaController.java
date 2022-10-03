package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Bebida;
import br.senai.sc.lanchonete.model.service.BebidaService;
import br.senai.sc.lanchonete.model.service.LancheService;

import java.sql.SQLException;
import java.util.Collection;

public class BebidaController {

    /**
     * Recebe os parâmetros do PedidoController para enviá-los para BebidaService
     *
     * @param codigo
     * @param descricao
     * @param preco
     * @param adicional
     * @throws SQLException
     */
    public void cadastrarBebida(Integer codigo, String descricao, double preco, double adicional) throws SQLException {
        new BebidaService().inserirBebida(Bebida.cadastrar(codigo, descricao, preco, adicional));
    }

    /**
     * Buscar todas as Bebidass
     *
     * @return
     */
    public Collection<Bebida> buscarTodasBebidas() throws SQLException{
        return new BebidaService().buscarBebidas();
    }

    public void removerBebida(Integer codigo) throws SQLException {
        new BebidaService().removerBebida(codigo);
    }

}






