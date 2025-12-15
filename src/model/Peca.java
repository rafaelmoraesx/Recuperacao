package model;

public class Peca {

    private int id;
    private String nome;
    private String tipo;
    private int quantidade;
    private int laboratorioId;

    public Peca() {
    }

    public Peca(String nome, String tipo, int quantidade, int laboratorioId) {
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.laboratorioId = laboratorioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(int laboratorioId) {
        this.laboratorioId = laboratorioId;
    }
}
