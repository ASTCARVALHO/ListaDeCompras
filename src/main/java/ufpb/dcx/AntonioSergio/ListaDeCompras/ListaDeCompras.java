package ufpb.dcx.AntonioSergio.ListaDeCompras;

import javax.swing.*;

public class ListaDeCompras {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListaDeComprasGUI();
            }
        });
    }
}
