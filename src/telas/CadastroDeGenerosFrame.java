package telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import aplicacao.*;
import entidades.Genero;

public class CadastroDeGenerosFrame extends JFrame {
        private Programa app;
        private JTextField generoField;
        private DefaultListModel<Genero> generoListModel;
        private JList<Genero> generoList;

    public CadastroDeGenerosFrame(String title, Programa app) {
        super(title);
        this.app = app;

        generoListModel = new DefaultListModel<>();
        generoList = new JList<>(generoListModel);

        // Componentes da interface gráfica
        generoField = new JTextField(20);

        JButton cadastrarGeneroButton = new JButton("Cadastrar Gênero");
        JButton voltarButton = new JButton("Voltar");

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarParaTelaInicial();
            }
        });

        cadastrarGeneroButton.addActionListener(new CadastrarGeneroListener());


        setLayout(new FlowLayout());
        add(new JLabel("Nome do Gênero:"));
        add(generoField);
        add(new JScrollPane(generoList));
        add(cadastrarGeneroButton);
        add(voltarButton);


        // Aumentando o tamanho dos botões
        Dimension tamanhoBotao = new Dimension(180, 40);
        cadastrarGeneroButton.setPreferredSize(tamanhoBotao);
        voltarButton.setPreferredSize(tamanhoBotao);


        // Colocando cor nos botões
        cadastrarGeneroButton.setBackground(new Color(242, 18, 78));
        voltarButton.setBackground(new Color(242, 18, 78));


        // Colocando cor nas letras dos botões
        cadastrarGeneroButton.setForeground(Color.white);
        voltarButton.setForeground(Color.white);


        // Alterando fonte dos botões
        Font fonteBotao = new Font("Lucida Fax", Font.BOLD, 16);
        cadastrarGeneroButton.setFont(fonteBotao);
        voltarButton.setFont(fonteBotao);

        // Colocando bordas nos botões
        cadastrarGeneroButton.setBorder(new LineBorder(Color.WHITE, 4));
        voltarButton.setBorder(new LineBorder(Color.WHITE, 4));


        // Cor do plano de fundo
        getContentPane().setBackground(new Color(236,121,131));


        carregarGeneros();
        setSize(610, 680);
        Programa.centerFrame(this);
    }

    private void carregarGeneros() {
        generoListModel.clear();
        List<Genero> generos = app.getGeneros();

        for (Genero genero : generos) {
            generoListModel.addElement(genero);
        }
    }

    private class CadastrarGeneroListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nomeGenero = generoField.getText().trim();

            if (!nomeGenero.isEmpty()) {
                Genero genero = new Genero(nomeGenero);
                app.adicionarGenero(genero);
                generoField.setText("");
                carregarGeneros();
            }
        }
    }

    private void voltarParaTelaInicial() {
        JFrame frame = new TelaInicialFrame("MyMovies", app);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Programa.centerFrame(frame);
        frame.setVisible(true);
        this.setVisible(false);
    }
}


