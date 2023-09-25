package ufpb.dcx.AntonioSergio.ListaDeCompras;

public interface ListaDecomprasInterface {
    public void adicionarProduto(String nome, double preco,String tipoProduto, int quantidade);
    public  void removerProduto(String nome);
    public double somaVaoloresTotal();
    public void limparLista();

}
