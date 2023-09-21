package ufpb.dcx.AntonioSergio.ListaDeCompras;

import javax.swing.*;
import java.awt.*;

public class ListaDeComprasGUI extends JFrame {
    public ListaDeComprasGUI(){
        setTitle("Listade compras");
        setSize(400,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,3));
        JButton adicionarbtn = new JButton("Adicionar");
        adicionarbtn.setForeground(new Color(255, 0, 0));
        add(adicionarbtn);
        JButton removertbtn = new JButton("Remover");
        removertbtn.setBackground(new Color(255, 0, 0));
        getContentPane().add(removertbtn);
    }
}
