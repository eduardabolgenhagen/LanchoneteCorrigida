package br.senai.sc.lanchonete.model.factory;

import br.senai.sc.lanchonete.model.entities.Bebida;

public class BebidaFactory {
    public Bebida getBebida(Integer codigoLanche, String descricao, double preco, double volume) {
        return new Bebida(codigoLanche, preco, descricao, volume);
    }
}
