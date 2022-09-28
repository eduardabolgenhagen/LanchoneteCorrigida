package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.service.LancheService;

public class LancheController {

    public static Lanche buscarLanches() {
        return new LancheService().buscarLanches();
    }
}
