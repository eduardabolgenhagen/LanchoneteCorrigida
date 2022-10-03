package br.senai.sc.lanchonete.model.entities;

public class Bebida {
    private double preco, volume;
    private Integer codigo;
    private String descricao;

    public Bebida(Integer codigo, double preco, String descricao, double volume) {
        this.codigo = codigo;
        this.preco = preco;
        this.descricao = descricao;
        this.volume = volume;
    }

    public static Bebida cadastrar(Integer codigo, String descricao, double preco, double adicional) {
        return new Bebida(codigo, preco, descricao, adicional);
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getVolume() {
        return volume;
    }

    //VERIFICAR UTILIDADE
    public void setVolume(double volume) {
        this.volume = volume;
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
