package br.senai.sc.lanchonete.model.entities;

public class Pedido {

    private int codigo;
    Tipo tipo;
    private String descricao;
    private double preco;

    public Pedido() {
    }

    public Pedido(int codigo, String descricao, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Pedido(Integer codigo, String descricao, double preco, String adicional, Tipo tipo) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.tipo = tipo;
    }

//    public static Pedido cadastrar(Integer codigo, String descricao, double preco, String adicional, Integer tipo) {
//        return new Pedido(codigo, descricao, preco, adicional, tipo);
//    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
