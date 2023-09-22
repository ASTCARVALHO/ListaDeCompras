package ufpb.dcx.AntonioSergio.ListaDeCompras;

import java.util.LinkedList;
import java.util.List;
import java.util.PropertyResourceBundle;

public class SistemaLista {
    //cadastra novo produto na lista
    // remover produto na lista
    //somar valor total dos produtos da lista
    List<Produto> produtos = new LinkedList<>();

    public void adicionarProduto(String nome, double preco,String tipoProduto, int quantidade){
        Produto produto = new Produto(nome, preco,tipoProduto,quantidade);
        produtos.add(produto);
    }
}
