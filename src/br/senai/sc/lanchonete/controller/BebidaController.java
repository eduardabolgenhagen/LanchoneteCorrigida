package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Bebida;
import br.senai.sc.lanchonete.model.service.BebidaService;

public class BebidaController {

    public static Bebida buscarBebidas() {
        return new BebidaService().buscarBebidas();
    }

}
