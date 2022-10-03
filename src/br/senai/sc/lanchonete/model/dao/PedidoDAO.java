package br.senai.sc.lanchonete.model.dao;

import br.senai.sc.lanchonete.model.entities.Pedido;
import br.senai.sc.lanchonete.model.factory.ConexaoFactory;

import java.sql.Connection;

public class PedidoDAO {
    private Connection conn;

    public PedidoDAO() {
        this.conn = new ConexaoFactory().connectDB();
    }

    public static Pedido buscarPorCodigo(Integer codigo) {
        return null;
    }

    public void atualizarPedido(Integer codigoPedido, Pedido pedido) {

    }

    public void inserir(Pedido pedido) {
    }

}
