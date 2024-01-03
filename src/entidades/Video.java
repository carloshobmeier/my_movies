package entidades;

public abstract class Video {
    private String nome;
    private double nota;
    private Genero genero;

    public Video(String nome, double nota, Genero genero) {
        this.nome = nome;
        this.nota = nota;
        this.genero = genero;
    }

    public abstract void reproduzir();

    public void exibirDetalhes() {
        System.out.println("Detalhes do vídeo:");
        System.out.println("Nome: " + nome);
        System.out.println("Nota: " + nota);
        System.out.println("Gênero: " + genero);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public abstract String toFileString();

    @Override
    public String toString() {
        return "Video{" +
                "nome='" + nome + '\'' +
                ", nota=" + nota +
                ", genero='" + genero + '\'' +
                '}';
    }
}
