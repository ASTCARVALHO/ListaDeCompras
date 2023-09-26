package ufpb.dcx.AntonioSergio.ListaDeCompras;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ListaDeComprasGUI extends JFrame {
    SistemaLista sistema = new SistemaLista();
    DefaultListModel<String> listaModel;
    JLabel valorTotal,indice;
    JList<String> lista;
    JButton adicionarbtn,removerbtn,limpaListabtn;
    public static final String text = "Valor total: ";
    public ListaDeComprasGUI(){
        setTitle("Listade compras");
        setSize(360,800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        indice = new JLabel();
        String textIndice =  String.format("%-30s%-30s%-30s%-30s", "Nome", "Tipo", "Valor", "Qtn");
        indice.setText(textIndice);
        indice.setBounds(0,0,360,22);
        add(indice);

        listaModel = new DefaultListModel<>();
        lista = new JList<>(listaModel);
        lista.setBounds(0,20,360,462);
        add(lista);

        valorTotal = new JLabel();
        valorTotal.setBounds(10,506,145,46);
        valorTotal.setForeground(new Color(0, 0, 0));
        add(valorTotal);

        adicionarbtn = new JButton(new ImageIcon("src/main/java/ufpb/dcx/AntonioSergio/ListaDeCompras/images/botao-adicionar.png"));
        adicionarbtn.setBounds(85,603,189,59);
        adicionarbtn.setBackground(new Color(39, 225, 26));
        add(adicionarbtn);

        removerbtn = new JButton(new ImageIcon("src/main/java/ufpb/dcx/AntonioSergio/ListaDeCompras/images/remover.png"));
        removerbtn.setBounds(85,680,189,59);
        removerbtn.setBackground(new Color(255, 0, 0));
        add(removerbtn);

        limpaListabtn = new JButton(new ImageIcon("src/main/java/ufpb/dcx/AntonioSergio/ListaDeCompras/images/excluir.png"));
        limpaListabtn.setBounds(280,509,52,43);
        limpaListabtn.setBackground(new Color(255, 255, 255));
        add(limpaListabtn);

        setVisible(true);
        adicionarbtn.addActionListener(this::adicionar);
        removerbtn.addActionListener(this::remover);
        limpaListabtn.addActionListener(this::limparlista);
        atualizar();
    }

    private void adicionar(ActionEvent actionEvent){
        String nome = JOptionPane.showInputDialog("Digite o nome");
        if (nome != null){
            try {
                String tipo = JOptionPane.showInputDialog("Digite o tipo do produto");
                double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor previsto"));
                int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade prevista"));
                sistema.adicionarProduto(nome,preco,tipo,quantidade);
                atualizar();
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Digite um valor válido", "ERRO", JOptionPane.WARNING_MESSAGE);
                adicionar(actionEvent);
            }

        }
    }

    public void remover(ActionEvent actionEvent) throws RuntimeException{
        if (sistema.produtos.size() == 0){
            JOptionPane.showMessageDialog(null,"Não há produtos na lista", "ERRO", JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException("Não há produtos");
        }
        String nome = JOptionPane.showInputDialog("Digite o nome");
        for (Produto p: sistema.produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) sistema.removerProduto(nome);
            else JOptionPane.showMessageDialog(null,"Produto não enontrado", "ERRO", JOptionPane.WARNING_MESSAGE);
        }
        atualizar();
    }

    public void atualizar(){
        listaModel.removeAllElements();
        for (Produto p: sistema.produtos) {
            listaModel.addElement(p.toString());
        }
        sistema.salvarDados();
        double valorTotalCalc = sistema.somaVaoloresTotal();
        valorTotal.setText(text + Double.toString(valorTotalCalc) + " R$");
    }

    public void limparlista(ActionEvent e){
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja realmente limpar a lista? ","AVISO",JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION ) sistema.limparLista();
        atualizar();
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
