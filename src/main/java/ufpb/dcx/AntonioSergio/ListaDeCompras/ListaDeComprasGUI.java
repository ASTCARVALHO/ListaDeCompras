package ufpb.dcx.AntonioSergio.ListaDeCompras;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ListaDeComprasGUI extends JFrame {
    SistemaLista sistema = new SistemaLista();

    DefaultListModel<String> listaModel;
    public ListaDeComprasGUI(){
        setTitle("Listade compras");
        setSize(400,700);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,3));
        listaModel = new DefaultListModel<>();
        JList<String> lista = new JList<>(listaModel);
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
        removertbtn.addActionListener(this::remover);
    }

    private void adicionar(ActionEvent actionEvent){
        String nome = JOptionPane.showInputDialog("Digite o nome");
        if (nome != null){
        String tipo = JOptionPane.showInputDialog("Digite o tipo do produto");
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor previsto"));
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade prevista"));
        sistema.adicionarProduto(nome,preco,tipo,quantidade);
        listaModel.removeAllElements();
        for (Produto p: sistema.produtos) {
            listaModel.addElement(p.toString());
        }
        }
    }
    public void remover(ActionEvent actionEvent){
        String nome = JOptionPane.showInputDialog("Digite o nome");
        sistema.removerProduto(nome);
        listaModel.removeAllElements();
        for (Produto p: sistema.produtos) {
            listaModel.addElement(p.toString());
        }

    }

}
