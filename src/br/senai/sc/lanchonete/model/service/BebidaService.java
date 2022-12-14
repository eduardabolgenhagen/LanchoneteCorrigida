package br.senai.sc.lanchonete.model.service;

import br.senai.sc.lanchonete.model.dao.BebidaDAO;
import br.senai.sc.lanchonete.model.entities.Bebida;

import java.sql.SQLException;
import java.util.Collection;

public class BebidaService {
    public void inserirBebida(Bebida bebida) throws SQLException {
        new BebidaDAO().inserirBebida(bebida);
    }

    public Collection<Bebida> buscarBebidas() throws SQLException {
        return new BebidaDAO().buscarTodasBebidas();
    }

    public void removerBebida(Integer codigo) throws SQLException {
        new BebidaDAO().removerBebida(codigo);
    }

    public void editarBebida(Integer codigo, double novoPreco) {
        new BebidaDAO().editarBebida(codigo, novoPreco);
    }
}
