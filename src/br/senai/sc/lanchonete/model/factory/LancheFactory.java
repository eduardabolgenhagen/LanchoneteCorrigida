package br.senai.sc.lanchonete.model.factory;

import br.senai.sc.lanchonete.model.entities.Lanche;

public class LancheFactory {

    public Lanche getLanche(Integer codigoLanche, String descricao, double preco, double peso) {
        return new Lanche(codigoLanche, preco, descricao, peso);
    }
}

