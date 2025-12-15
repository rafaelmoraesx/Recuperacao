package model;

import java.sql.Date;

public class Manutencao {

    private int id;
    private String tipo;
    private Date data;
    private int maquinaId;
    private int peca;
    private String descricao;

    // Construtor vazio (OBRIGATÓRIO para Swing/DAO)
    public Manutencao() {
    }

    // Construtor usado na tela
    public Manutencao(String tipo, Date data, int maquinaId, int peca, String descricao) {
        this.tipo = tipo;
        this.data = data;
        this.maquinaId = maquinaId;
        this.peca = peca;
        this.descricao = descricao;
    }

    // ===== GETTERS E SETTERS =====

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getMaquinaId() {
        return maquinaId;
    }

    public void setMaquinaId(int maquinaId) {
        this.maquinaId = maquinaId;
    }

    public int getPeca() {
        return peca;
    }

    public void setPeca(int peca) {
        this.peca = peca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Object getPecaId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPecaId(int pecaId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
