package telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import aplicacao.Programa;

public class TelaInicialFrame extends JFrame {
    private Programa app;
    private ImageIcon filmesIcon;
    private JLabel myLabelFilmes;
    private ImageIcon seriesIcon;
    private JLabel myLabelSeries;
    private JLabel myLabelMain;
    private ImageIcon mainIcon;
    private JLabel MyLabelLogo;
    private ImageIcon logoIcon;
    private JLabel myLabelGeneros;
    private ImageIcon generosIcon;

    public TelaInicialFrame(String title, Programa app) {
        super(title);
        this.app = app;

        // Componentes da interface gráfica
        JButton logo = new JButton("|");
        JButton cadastrarFilmesButton = new JButton("Cadastrar Filmes");
        JButton cadastrarGenerosButton = new JButton("Cadastrar Gêneros");
        JButton cadastrarSeriesButton = new JButton("Cadastrar Séries");

        // Aumentando o tamanho dos botões
        Dimension tamanhoBotao = new Dimension(180, 40);
        logo.setPreferredSize(new Dimension(25,30));
        cadastrarFilmesButton.setPreferredSize(tamanhoBotao);
        cadastrarGenerosButton.setPreferredSize(tamanhoBotao);
        cadastrarSeriesButton.setPreferredSize(tamanhoBotao);


        // Gambiarra para tirar a 'caixa' que envolvia o texto do botão 'cadastrar filmes
        logoIcon = new ImageIcon(this.getClass().getResource("/recursos/popcorn.png"));
        MyLabelLogo = new JLabel(logoIcon);
        MyLabelLogo.setSize(51, 51);
        logo.setBackground(new Color(3,5,54));
        logo.setBorder(null);
        logo.setIcon(logoIcon);

        // Colocando cor nos botões
        cadastrarFilmesButton.setBackground(new Color(242, 18, 78));
        cadastrarGenerosButton.setBackground(new Color(242, 18, 78));
        cadastrarSeriesButton.setBackground(new Color(242, 18, 78));

        // Colocando cor nas letras dos botões
        cadastrarFilmesButton.setForeground(Color.white);
        cadastrarGenerosButton.setForeground(Color.white);
        cadastrarSeriesButton.setForeground(Color.white);

        // Alterando a fonte dos botões
        Font fonteBotao = new Font("Lucida Fax", Font.BOLD, 16);
        cadastrarFilmesButton.setFont(fonteBotao);
        cadastrarGenerosButton.setFont(fonteBotao);
        cadastrarSeriesButton.setFont(fonteBotao);

        // Colocando bordas nos botões
        cadastrarFilmesButton.setBorder(new LineBorder(Color.WHITE, 4));
        cadastrarSeriesButton.setBorder(new LineBorder(Color.WHITE, 4));
        cadastrarGenerosButton.setBorder(new LineBorder(Color.WHITE, 4));

        // Cor no plano de fundo
        getContentPane().setBackground(new Color(3,5,54));


        filmesIcon = new ImageIcon(this.getClass().getResource("/recursos/imagem-filmes.jpg"));
        myLabelFilmes = new JLabel(filmesIcon);
        myLabelFilmes.setSize(650, 650);

        seriesIcon = new ImageIcon(this.getClass().getResource("/recursos/imagem-series.jpg"));
        myLabelSeries = new JLabel(seriesIcon);
        myLabelSeries.setSize(650, 650);

        mainIcon = new ImageIcon(this.getClass().getResource("/recursos/main.jpg"));
        myLabelMain = new JLabel(mainIcon);
        myLabelMain.setSize(384, 384);

        generosIcon = new ImageIcon(this.getClass().getResource("/recursos/generos.jpg"));
        myLabelGeneros = new JLabel(generosIcon);
        myLabelGeneros.setSize(650, 450);

        setLayout(new FlowLayout());
        add(logo);
        add(cadastrarFilmesButton);
        add(cadastrarSeriesButton);
        add(cadastrarGenerosButton);

        cadastrarFilmesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastroFilmes();
            }
        });

        cadastrarGenerosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastroGeneros();
            }
        });

        cadastrarSeriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastroSeries();
            }
        });

        setSize(660, 710);
        add(myLabelMain);
        Programa.centerFrame(this);
    }

    private void abrirTelaCadastroFilmes() {
        JFrame frame = new CadastroDeFilmesFrame("Cadastro de Filmes", app);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(myLabelFilmes);
        Programa.centerFrame(frame);
        frame.setVisible(true);
        this.setVisible(false);
    }

    private void abrirTelaCadastroGeneros() {
        JFrame frame = new CadastroDeGenerosFrame("Cadastro de Gêneros", app);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(myLabelGeneros);
        Programa.centerFrame(frame);
        frame.setVisible(true);
        this.setVisible(false);
    }

    private void abrirTelaCadastroSeries() {
        JFrame frame = new CadastroDeSeriesFrame("Cadastro de Séries", app);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(myLabelSeries);
        Programa.centerFrame(frame);
        frame.setVisible(true);
        this.setVisible(false);
    }
}
