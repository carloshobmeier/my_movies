package telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import aplicacao.Programa;
import entidades.Filme;
import entidades.Genero;
import entidades.Serie;
import aplicacao.*;

public class CadastroDeSeriesFrame extends JFrame {
    private Programa app;
    private JTextField nomeField;
    private JComboBox<Genero> generoComboBox;
    private JTextField duracaoField;
    private JTextField notaField;
    private JTextArea seriesTextArea;

    public CadastroDeSeriesFrame(String title, Programa app) {
        super(title);
        this.app = app;

        // Componentes da interface gráfica
        nomeField = new JTextField(15);
        generoComboBox = new JComboBox<>(app.getGeneros().toArray(new Genero[0]));
        duracaoField = new JTextField(3);
        notaField = new JTextField(3);

        JButton cadastrarSerieButton = new JButton("Cadastrar Série");
        JButton voltarButton = new JButton("Voltar");

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarParaTelaInicial();
            }
        });

        cadastrarSerieButton.addActionListener(new CadastrarSerieListener());

        seriesTextArea = new JTextArea(10, 40);
        seriesTextArea.setEditable(false);

        JScrollPane seriesScrollPane = new JScrollPane(seriesTextArea);

        setLayout(new FlowLayout());
        add(new JLabel("Nome da série:"));
        add(nomeField);
        add(new JLabel("Gênero da série:"));
        add(generoComboBox);
        add(new JLabel("Duração (minutos):"));
        add(duracaoField);
        add(new JLabel("Nota (1-10):"));
        add(notaField);
        add(cadastrarSerieButton);
        add(voltarButton);
        add(seriesScrollPane);


        // Aumentando o tamanho dos botões
        Dimension tamanhoBotao = new Dimension(150, 40);
        cadastrarSerieButton.setPreferredSize(tamanhoBotao);
        voltarButton.setPreferredSize(tamanhoBotao);


        // Colocando cor nos botões
        cadastrarSerieButton.setBackground(new Color(242, 18, 78));
        voltarButton.setBackground(new Color(242, 18, 78));


        // Colocando cor nas letras dos botões
        cadastrarSerieButton.setForeground(Color.white);
        voltarButton.setForeground(Color.white);


        // Alterando a fonte dos botões
        Font fonteBotao = new Font("Lucida Fax", Font.BOLD, 16);
        cadastrarSerieButton.setFont(fonteBotao);
        voltarButton.setFont(fonteBotao);


        // Colocando bordas nos botões
        cadastrarSerieButton.setBorder(new LineBorder(Color.WHITE, 4));
        voltarButton.setBorder(new LineBorder(Color.WHITE, 4));


        // Cor no plano de fundo
        getContentPane().setBackground(new Color(253,213,1));



        carregarSeries();
        setSize(770, 680);
        Programa.centerFrame(this);
    }

    private void carregarSeries() {
        List<Serie> series = app.getSeries();
        seriesTextArea.setText("");

        for (Serie serie : series) {
            seriesTextArea.append(serie + "\n\n");
        }
    }

    private class CadastrarSerieListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nome = nomeField.getText();
            Genero genero = (Genero) generoComboBox.getSelectedItem();
            String duracaoText = duracaoField.getText();
            String notaText = notaField.getText();

            if (nome.isEmpty() || genero == null || duracaoText.isEmpty() || notaText.isEmpty()) {
                JOptionPane.showMessageDialog(CadastroDeSeriesFrame.this, "Por favor, preencha todos os campos.");
                return;
            }

            try {
                int duracao = Integer.parseInt(duracaoText);
                double nota = Double.parseDouble(notaText);

                Serie serie = new Serie(nome, nota, genero, duracao);
                app.adicionarSerie(serie);
                nomeField.setText("");
                duracaoField.setText("");
                notaField.setText("");
                carregarSeries();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(CadastroDeSeriesFrame.this, "Duração e nota devem ser números válidos.");
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