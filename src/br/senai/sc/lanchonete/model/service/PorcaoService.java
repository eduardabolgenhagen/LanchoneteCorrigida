package br.senai.sc.lanchonete.model.service;

import br.senai.sc.lanchonete.model.dao.PorcaoDAO;
import br.senai.sc.lanchonete.model.entities.Porcao;

import java.sql.SQLException;

/**
 * Recebe do Controller para enviar para o DAO
 */
public class PorcaoService {
    public void inserirLPorcao(Porcao porcao) throws SQLException {
        new PorcaoDAO().inserirPorcao(porcao);

    }
    public Porcao buscarPorcoes() throws SQLException{
        return new PorcaoDAO().buscarPorcoes();
    }

}
