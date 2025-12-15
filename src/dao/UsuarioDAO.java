package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Usuario;

public class UsuarioDAO {

    public void inserir(Usuario usuario) {

        String sql = "INSERT INTO usuario (nome, email, senha, papel) VALUES (?, ?, ?, ?)";

        try {
            Connection con = ConexaoDAO.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getPapel());

            ps.execute();

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
        }
    }
}
