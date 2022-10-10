package br.senai.sc.lanchonete.model.entities;

public class Porcao {
    private String descricao, tamanho;
    private Integer codigo;
    private double preco;

    public Porcao(int codigo, double preco, String descricao, String tamanho) {
        this.codigo = codigo;
        this.preco = preco;
        this.descricao = descricao;
        this.tamanho = tamanho;
    }

    public static Porcao cadastrar(Integer codigo, String descricao, double preco, String tamanho) {
        return new Porcao(codigo, preco, descricao, tamanho);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
