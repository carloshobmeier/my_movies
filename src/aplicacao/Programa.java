package aplicacao;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entidades.*;
import telas.*;


public class Programa {
    private List<Filme> filmes;
    private static List<Genero> generos;
    private List<Serie> series;
    private static final String FILMES_FILE = "filmes.txt";
    private static final String GENEROS_FILE = "generos.txt";
    private static final String SERIES_FILE = "series.txt";

    public Programa() {
        filmes = new ArrayList<>();
        generos = new ArrayList<>();
        series = new ArrayList<>();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	Programa app = new Programa();
            app.carregarGeneros();
            app.carregarFilmes();
            app.carregarSeries();

            JFrame frame = new TelaInicialFrame("MyMovies", app);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            centerFrame(frame);
            frame.setVisible(true);
        });
    }

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
        salvarFilmeEmArquivo(filme, FILMES_FILE);
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void adicionarSerie(Serie serie) {
        series.add(serie);
        salvarSerieEmArquivo(serie, SERIES_FILE);
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void adicionarGenero(Genero genero) {
        generos.add(genero);
        salvarGeneroEmArquivo(genero, GENEROS_FILE);
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void carregarFilmes() {
        try {
            Scanner scanner = new Scanner(new File(FILMES_FILE));
            while (scanner.hasNextLine()) {
                String nome = scanner.nextLine();
                String generoNome = scanner.nextLine();
                int duracao = Integer.parseInt(scanner.nextLine());
                double nota = Double.parseDouble(scanner.nextLine());

                Genero genero = null;
                for (Genero g : generos) {
                    if (g.getNome().equals(generoNome)) {
                        genero = g;
                        break;
                    }
                }

                if (genero != null) {
                    filmes.add(new Filme(nome, nota, genero, duracao));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum filme cadastrado.");
        }
    }

    public void carregarSeries() {
        try {
            Scanner scanner = new Scanner(new File(SERIES_FILE));
            while (scanner.hasNextLine()) {
                String nome = scanner.nextLine();
                String generoNome = scanner.nextLine();
                int duracao = Integer.parseInt(scanner.nextLine());
                double nota = Double.parseDouble(scanner.nextLine());

                Genero genero = null;
                for (Genero g : generos) {
                    if (g.getNome().equals(generoNome)) {
                        genero = g;
                        break;
                    }
                }

                if (genero != null) {
                    series.add(new Serie(nome, nota, genero, duracao));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum filme cadastrado.");
        }
    }



    public void carregarGeneros() {
        try {
            Scanner scanner = new Scanner(new File(GENEROS_FILE));
            while (scanner.hasNextLine()) {
                String generoNome = scanner.nextLine();
                generos.add(new Genero(generoNome));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum gênero cadastrado.");
        }
    }

    private void salvarFilmeEmArquivo(Filme filme, String nomeArquivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true));
            writer.write(filme.toFileString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar o filme no arquivo.");
        }
    }

    private void salvarSerieEmArquivo(Serie serie, String nomeArquivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true));
            writer.write(serie.toFileString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar o filme no arquivo.");
        }
    }

    private void salvarGeneroEmArquivo(Genero genero, String nomeArquivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true));
            writer.write(genero.getNome() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar o gênero no arquivo.");
        }
    }

    public static void centerFrame(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}




