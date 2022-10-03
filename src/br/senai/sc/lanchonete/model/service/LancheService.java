package br.senai.sc.lanchonete.model.service;

import br.senai.sc.lanchonete.model.dao.LancheDAO;
import br.senai.sc.lanchonete.model.entities.Lanche;

import java.sql.SQLException;
import java.util.Collection;

public class LancheService {
    public void inserirLanche(Lanche lanche) throws SQLException {
        new LancheDAO().inserirLanche(lanche);
    }

    public Collection<Lanche> buscarLanches() throws SQLException {
        return new LancheDAO().buscarTodosLanches();
    }

    public void removerLanche(Integer codigo) throws SQLException {
        new LancheDAO().removerLanche(codigo);
    }

    public void editarLanche(Integer codigo, double novoPreco) throws SQLException {
        new LancheDAO().editarLanche(codigo, novoPreco);
    }
}
