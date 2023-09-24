package ufpb.dcx.AntonioSergio.ListaDeCompras;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PropertyResourceBundle;

public class SistemaLista implements  ListaDecomprasInterface{
    //cadastra novo produto na lista
    // remover produto na lista
    //somar valor total dos produtos da lista
    List<Produto> produtos;
    GravadorDeDados gravador = new GravadorDeDados();
    public SistemaLista(){
         produtos = new LinkedList<>();
         recuperarLista();
    }
    public void salvarDados(){
        try {
            this.gravador.salvarLista(this.produtos);
        }catch (Exception e ){
            System.err.println(e.getMessage());
        }
    }
    public void recuperarLista(){
        try {
            List<Produto> produtosRecuperados = gravador.recuperarLista();
            this.produtos.addAll(produtosRecuperados);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    @Override
    public void adicionarProduto(String nome, double preco,String tipoProduto, int quantidade) {
        Produto produto = new Produto(nome, preco,tipoProduto,quantidade);
        produtos.add(produto);
    }
    @Override
    public void removerProduto(String nome) {
        for (Produto p: produtos) {
            if(p.getNome().equals(nome)) produtos.remove(p);
        }
    }
    @Override
    public double somaVaoloresTotal() {
        double valorTotal = 0;
        for (Produto p: produtos) {
            valorTotal += (p.getPreco() * p.getQuantidade());
        }
        return valorTotal;
    }
}
