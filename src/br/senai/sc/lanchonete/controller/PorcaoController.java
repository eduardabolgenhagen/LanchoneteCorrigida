package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Porcao;
import br.senai.sc.lanchonete.model.service.PorcaoService;

public class PorcaoController {

    public static Porcao buscarPorcoes() {
        return new PorcaoService().buscarPorcoes();
    }
}
