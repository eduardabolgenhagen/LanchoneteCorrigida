package br.senai.sc.lanchonete.model.service;

import br.senai.sc.lanchonete.model.dao.BebidaDAO;
import br.senai.sc.lanchonete.model.entities.Bebida;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Recebe do Controller para enviar para o DAO
 */
public class BebidaService {
    public void inserirBebida(Bebida bebida) throws SQLException {
        new BebidaDAO().inserirBebida(bebida);
    }

    public Collection<Bebida> buscarBebidas() throws SQLException {
        return new BebidaDAO().buscarTodasBebidas();
    }
}
