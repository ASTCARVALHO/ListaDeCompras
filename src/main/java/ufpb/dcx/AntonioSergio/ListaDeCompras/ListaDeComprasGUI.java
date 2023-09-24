package ufpb.dcx.AntonioSergio.ListaDeCompras;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ListaDeComprasGUI extends JFrame {
    SistemaLista sistema = new SistemaLista();

    DefaultListModel<String> listaModel;
    JLabel valorTotal;
    public ListaDeComprasGUI(){
        setTitle("Listade compras");
        setSize(381,729);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,0));
        listaModel = new DefaultListModel<>();
        JList<String> lista = new JList<>(listaModel);
        add(lista);
        valorTotal = new JLabel();
        valorTotal.setBackground(new Color(0x0000FF));
        add(valorTotal);
        JButton adicionarbtn = new JButton();
        adicionarbtn.setText("Adicionar");
        adicionarbtn.setForeground(new Color(255, 0, 0));
        add(adicionarbtn);
        JButton removertbtn = new JButton("Remover");
        removertbtn.setBackground(new Color(255, 0, 0));
        removertbtn.setSize(600,100);
        getContentPane().add(removertbtn);
        setVisible(true);
        atualizar();
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
        double valorTotalCalc = sistema.somaVaoloresTotal();
        valorTotal.setText(Double.toString(valorTotalCalc));
        listaModel.removeAllElements();
        atualizar();
        }
    }
    public void remover(ActionEvent actionEvent) throws RuntimeException{
        if (sistema.produtos.size() == 0){
            throw new RuntimeException("Não há produtos");
        }
        String nome = JOptionPane.showInputDialog("Digite o nome");
        sistema.removerProduto(nome);
        listaModel.removeAllElements();
        double valorTotalCalc = sistema.somaVaoloresTotal();
        valorTotal.setText(Double.toString(valorTotalCalc));
        atualizar();

    }
    public void atualizar(){
        for (Produto p: sistema.produtos) {
            listaModel.addElement(p.toString());
        }
        sistema.salvarDados();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListaDeComprasGUI();
            }
        });
    }

}
