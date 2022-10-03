package br.senai.sc.lanchonete.model.service;

import br.senai.sc.lanchonete.model.dao.LancheDAO;
import br.senai.sc.lanchonete.model.entities.Lanche;

import java.sql.SQLException;
import java.util.Collection;

public class LancheService {
    /**
     * Recebe do Controller para enviar para o DAO
     */
    public void inserirLanche(Lanche lanche) throws SQLException {
        new LancheDAO().inserirLanche(lanche);
    }

    /**
     * Manda para o DAO o tipo necessário que deve buscar
     *
     * @return
     */
    public Collection<Lanche> buscarLanches() throws SQLException {
        return new LancheDAO().buscarTodosLanches();
    }

    public void removerLanche(Integer codigo) throws SQLException {
        new LancheDAO().removerLanche(codigo);
    }

    public void editarLanche(Integer codigo, double novoPreco) {
//        new LancheDAO().editarLanche(codigo, novoPreco);
    }
}
