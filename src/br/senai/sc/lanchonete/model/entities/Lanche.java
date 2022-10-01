package br.senai.sc.lanchonete.model.entities;

public class Lanche {
    private double preco, peso;
    Integer codigo;
    String descricao;

    public Lanche(Integer codigo, double preco, String descricao, double peso) {
        this.codigo = codigo;
        this.preco = preco;
        this.descricao = descricao;
        this.peso = peso;
    }

    public static Lanche cadastrar(Integer codigo, String descricao, double preco, double peso) {
        return new Lanche(codigo, preco, descricao, peso);
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
