package ufpb.dcx.AntonioSergio.ListaDeCompras;

import javax.swing.*;

public class ListaDeCompras {

    //adicionar e remover produtos
    //cada produto será um objeto com preço tipo e nome
    //terá uma funcionalidade para prever a quantidade de dinheiro que irá gstar nessas compras
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListaDeComprasGUI();
            }
        });
        public void adicionar(){

        }
    }
}
