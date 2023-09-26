package ufpb.dcx.AntonioSergio.ListaDeCompras;

public interface ListaDecomprasInterface {
    /**
     *
     * @param nome
     * @param preco
     * @param tipoProduto
     * @param quantidade
     */
    public void adicionarProduto(String nome, double preco,String tipoProduto, int quantidade);
    public  void removerProduto(String nome);
    public double somaVaoloresTotal();
    public void limparLista();

}
