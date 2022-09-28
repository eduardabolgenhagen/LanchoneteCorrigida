package br.senai.sc.lanchonete.model.service;

import br.senai.sc.lanchonete.model.dao.BebidaDAO;
import br.senai.sc.lanchonete.model.entities.Bebida;

public class BebidaService {
    public Bebida buscarBebidas (){
        new BebidaDAO().buscarBebidas();
        return null;
    }
}
