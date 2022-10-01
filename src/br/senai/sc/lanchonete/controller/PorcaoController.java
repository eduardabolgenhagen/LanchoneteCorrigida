package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Bebida;
import br.senai.sc.lanchonete.model.entities.Porcao;
import br.senai.sc.lanchonete.model.service.BebidaService;
import br.senai.sc.lanchonete.model.service.PorcaoService;

import java.sql.SQLException;
import java.util.Collection;

public class PorcaoController {

    /**
     * Recebe os parâmetros do PedidoController para enviá-los para PorcaoService
     *
     * @param codigo
     * @param descricao
     * @param preco
     * @param adicional
     * @throws SQLException
     */
    public void cadastrarPorcao(Integer codigo, String descricao, double preco, String adicional) throws SQLException {
        new PorcaoService().inserirLPorcao(Porcao.cadastrar(codigo, descricao, preco, adicional));
    }

    public static Collection<Porcao> buscarTodasPorcoes() throws SQLException {
        return new PorcaoService().buscarPorcoes();
    }
}
