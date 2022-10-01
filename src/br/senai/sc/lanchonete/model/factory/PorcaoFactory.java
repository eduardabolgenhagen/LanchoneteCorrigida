package br.senai.sc.lanchonete.model.factory;

import br.senai.sc.lanchonete.model.entities.Porcao;

public class PorcaoFactory {

    public Porcao getPorcao(Integer codigoLanche, String descricao, double preco, String tamanho) {
        return new Porcao(codigoLanche, preco, descricao, tamanho);
    }
}
