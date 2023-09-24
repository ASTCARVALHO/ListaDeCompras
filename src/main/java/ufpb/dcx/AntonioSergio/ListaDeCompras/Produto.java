package ufpb.dcx.AntonioSergio.ListaDeCompras;

import java.io.Serializable;

public class Produto implements Serializable {
    private String nome;
    private double preco;
    private String tipoProduto;
    private int quantidade;
    public Produto(String nome, double preco,String tipoProduto, int quantidade){
        this.nome = nome;
        this.preco = preco;
        this.tipoProduto = tipoProduto;
        this.quantidade = quantidade;
    }
    public Produto(String nome, double preco, int quantidade){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String toString(){
        return "Nome :" + this.nome + " tipo: " + this.tipoProduto + " preço: " + this.preco + " quantidade:" + this.quantidade;
    }
}
