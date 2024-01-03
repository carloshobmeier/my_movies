package entidades;


public class Genero {
    private String nome;

    public Genero(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
    public String toString() {
        return nome;
    }
}