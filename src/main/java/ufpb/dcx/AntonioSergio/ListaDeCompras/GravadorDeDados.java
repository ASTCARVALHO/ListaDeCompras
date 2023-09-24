package ufpb.dcx.AntonioSergio.ListaDeCompras;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeDados {
    public static  final String ARQUIVO_LISTA = "lista.dat";

    public void salvarLista(List<Produto> produtos) throws IOException{
        ObjectOutputStream out = null;
        try {
        out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_LISTA));
        out.writeObject(produtos);
        }catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar a lista de compras no arquivo: " + ARQUIVO_LISTA);
        }
    }

    public List<Produto> recuperarLista() throws IOException{
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(ARQUIVO_LISTA));
            return (List<Produto>) in.readObject();
        } catch (Exception e) {
            System.out.println("Não foi possivel recuperar a lista");
            throw new IOException("Não foi possivel recuperar a lista no arquivo: " + ARQUIVO_LISTA);
        }finally {
            if(in!= null) in.close();
        }
    }

}
