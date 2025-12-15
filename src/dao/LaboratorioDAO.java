package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Laboratorio;

public class LaboratorioDAO {
public boolean inserir(Laboratorio laboratorio) {

    String sql = "INSERT INTO laboratorio (nome, localizacao) VALUES (?, ?)";

    try {
        Connection con = ConexaoDAO.conectar();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, laboratorio.getNome());
        ps.setString(2, laboratorio.getLocalizacao());

        ps.execute();

        ps.close();
        con.close();

        return true;

    } catch (Exception e) {
        System.out.println("Erro ao inserir laboratório: " + e.getMessage());
        return false;
    }
    }
}
