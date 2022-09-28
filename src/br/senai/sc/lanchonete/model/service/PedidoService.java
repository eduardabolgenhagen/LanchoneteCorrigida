package br.senai.sc.lanchonete.model.service;

import br.senai.sc.lanchonete.model.dao.PedidoDAO;
import br.senai.sc.lanchonete.model.entities.Pedido;

public class PedidoService {

    //Cadastrar pedido
    public void cadastrar (Pedido pedido){
        new PedidoDAO().inserir(pedido);
    }

    public Pedido buscarPorCódigo(Integer codigo){
        return null;
    }

    public void atualizarPedido(Pedido pedido){

    }


}


