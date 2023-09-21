package ufpb.dcx.AntonioSergio.ListaDeCompras;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaDeComprasGUI extends JFrame {
    public ListaDeComprasGUI(){
        setTitle("Listade compras");
        setSize(400,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,3));
        JLabel lista = new JLabel();
        add(lista);
        JButton adicionarbtn = new JButton();
        adicionarbtn.setText("Adicionar");
        adicionarbtn.setForeground(new Color(255, 0, 0));
        add(adicionarbtn);
        JButton removertbtn = new JButton("Remover");
        removertbtn.setBackground(new Color(255, 0, 0));
        removertbtn.setSize(600,100);
        getContentPane().add(removertbtn);
        setVisible(true);
        adicionarbtn.addActionListener(this::adicionar);
    }

    private void adicionar(ActionEvent actionEvent){
        ListaDeCompras.adicionar();
    }

}
