package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.service.LancheService;

import java.sql.SQLException;
import java.util.Collection;

public class LancheController {
    /**
     * Recebe de PedidoController os parâmetros para enviá-los para o LacheService
     *
     * @param codigo
     * @param descricao
     * @param preco
     * @param adicional
     * @throws SQLException
     */
    public void cadastrarLanche(Integer codigo, String descricao, double preco, double adicional) throws SQLException {
        new LancheService().inserirLanche(Lanche.cadastrar(codigo, descricao, preco, adicional));
    }

    /**
     * Buscar todos os Lanches existentes
     *
     * @return
     */
    public Collection<Lanche> buscarTodosLanches() throws SQLException {
        return new LancheService().buscarLanches();
    }

    public void removerLanche(Integer codigo) throws SQLException {
        new LancheService().removerLanche(codigo);
    }

    public void editarLanche(Integer codigo, double novoPreco){
        new LancheService().editarLanche(codigo, novoPreco);
    }
}
