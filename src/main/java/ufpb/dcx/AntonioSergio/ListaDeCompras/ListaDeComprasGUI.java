package ufpb.dcx.AntonioSergio.ListaDeCompras;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ListaDeComprasGUI extends JFrame {
    SistemaLista sistema = new SistemaLista();
    DefaultListModel<String> listaModel;
    JLabel valorTotal;
    JList<String> lista;
    JButton adicionarbtn,removerbtn,limpaListabtn;
    public ListaDeComprasGUI(){
        setTitle("Listade compras");
        setSize(360,800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);


        listaModel = new DefaultListModel<>();
        lista = new JList<>(listaModel);
        lista.setBounds(0,0,360,484);
        add(lista);

        valorTotal = new JLabel();
        valorTotal.setBounds(0,506,145,46);
        valorTotal.setForeground(new Color(241, 5, 139));
        valorTotal.setBackground(new Color(0, 100, 255,134));
        add(valorTotal);

        adicionarbtn = new JButton(new ImageIcon("src/main/java/ufpb/dcx/AntonioSergio/ListaDeCompras/images/botao-adicionar.png"));
        adicionarbtn.setBounds(85,603,189,59);
        adicionarbtn.setBackground(new Color(39, 225, 26));
        adicionarbtn.setForeground(new Color(255, 0, 0));
        add(adicionarbtn);

        removerbtn = new JButton(new ImageIcon("src/main/java/ufpb/dcx/AntonioSergio/ListaDeCompras/images/remover.png"));
        removerbtn.setBounds(85,680,189,59);
        removerbtn.setBackground(new Color(255, 0, 0));
        add(removerbtn);

        limpaListabtn = new JButton(new ImageIcon("src/main/java/ufpb/dcx/AntonioSergio/ListaDeCompras/images/excluir.png"));
        limpaListabtn.setBounds(295,509,52,43);
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
            throw new RuntimeException("Não há produtos");
        }
        String nome = JOptionPane.showInputDialog("Digite o nome");
        sistema.removerProduto(nome);
        atualizar();
    }

    public void atualizar(){
        String text = "Valor Total: ";
        listaModel.removeAllElements();
        for (Produto p: sistema.produtos) {
            listaModel.addElement(p.toString());
        }
        sistema.salvarDados();
        double valorTotalCalc = sistema.somaVaoloresTotal();
        valorTotal.setText(text + Double.toString(valorTotalCalc) + " R$");
    }

    public void limparlista(ActionEvent e){
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja realmente limpar a lista? ");
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
