package br.senai.sc.lanchonete.model.service;

import br.senai.sc.lanchonete.model.dao.PorcaoDAO;
import br.senai.sc.lanchonete.model.entities.Porcao;

public class PorcaoService {
    public Porcao buscarPorcoes (){
        new PorcaoDAO().buscarPorcoes();
        return null;
    }

}
