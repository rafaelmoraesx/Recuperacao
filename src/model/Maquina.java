package model;

public class Maquina {

    private int id;
    private String nome;
    private String especificacoes;
    private String status;
    private int laboratorioId;

    public Maquina() {
    }

    public Maquina(String nome, String especificacoes, String status, int laboratorioId) {
        this.nome = nome;
        this.especificacoes = especificacoes;
        this.status = status;
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

    
    public String getEspecificacoes() {
        return especificacoes;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public int getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(int laboratorioId) {
        this.laboratorioId = laboratorioId;
    }
}
