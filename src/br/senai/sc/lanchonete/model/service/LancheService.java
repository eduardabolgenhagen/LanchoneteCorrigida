package br.senai.sc.lanchonete.model.service;

import br.senai.sc.lanchonete.model.dao.LancheDAO;
import br.senai.sc.lanchonete.model.entities.Lanche;

public class LancheService {
    public Lanche buscarLanches (){
        new LancheDAO().buscarLanches();
        return null;
    }
}
