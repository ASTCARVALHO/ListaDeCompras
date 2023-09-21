package ufpb.dcx.AntonioSergio.ListaDeCompras;

public class Produto {
    private String nome;
    private double preco;
    private TipoProduto tipoProduto;
    private int quantidade;
    public Produto(String nome, double preco, TipoProduto tipoProduto, int quantidade){
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

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}
