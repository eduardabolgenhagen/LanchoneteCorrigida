package br.senai.sc.lanchonete.model.service;

import br.senai.sc.lanchonete.model.dao.LancheDAO;
import br.senai.sc.lanchonete.model.dao.PorcaoDAO;
import br.senai.sc.lanchonete.model.entities.Porcao;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Recebe do Controller para enviar para o DAO
 */
public class PorcaoService {
    public void inserirLPorcao(Porcao porcao) throws SQLException {
        new PorcaoDAO().inserirPorcao(porcao);
    }

    public Collection<Porcao> buscarPorcoes() throws SQLException {
        return new PorcaoDAO().buscarPorcoes();
    }

    public void removerPorcao(Integer codigo) throws SQLException {
        new PorcaoDAO().removerPorcao(codigo);

    }

}
