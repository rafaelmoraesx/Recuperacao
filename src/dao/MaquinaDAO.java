package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Maquina;

public class MaquinaDAO {

    // ================= INSERIR =================
    public boolean inserir(Maquina maquina) {

        String sql = "INSERT INTO maquina (nome, especificacoes, status, laboratorio_id) "
                   + "VALUES (?, ?, ?, ?)";

        try {
            Connection con = ConexaoDAO.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maquina.getNome());
            ps.setString(2, maquina.getEspecificacoes());
            ps.setString(3, maquina.getStatus());
            ps.setInt(4, maquina.getLaboratorioId());

            ps.execute();

            ps.close();
            con.close();

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir máquina: " + e.getMessage());
            return false;
        }
    }

    // ================= LISTAR =================
    public List<Maquina> listar() {

        List<Maquina> lista = new ArrayList<>();
        String sql = "SELECT * FROM maquina";

        try {
            Connection con = ConexaoDAO.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Maquina m = new Maquina();
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setEspecificacoes(rs.getString("especificacoes"));
                m.setStatus(rs.getString("status"));
                m.setLaboratorioId(rs.getInt("laboratorio_id"));

                lista.add(m);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Erro ao listar máquinas: " + e.getMessage());
        }

        return lista;
    }

    // ================= EXCLUIR =================
    public boolean excluir(int id) {

        String sql = "DELETE FROM maquina WHERE id = ?";

        try {
            Connection con = ConexaoDAO.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.execute();

            ps.close();
            con.close();

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir máquina: " + e.getMessage());
            return false;
        }
    }

    // ================= ATUALIZAR =================
    public boolean atualizar(Maquina maquina) {

        String sql = "UPDATE maquina SET nome = ?, especificacoes = ?, status = ?, laboratorio_id = ? "
                   + "WHERE id = ?";

        try {
            Connection con = ConexaoDAO.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maquina.getNome());
            ps.setString(2, maquina.getEspecificacoes());
            ps.setString(3, maquina.getStatus());
            ps.setInt(4, maquina.getLaboratorioId());
            ps.setInt(5, maquina.getId());

            ps.executeUpdate();

            ps.close();
            con.close();

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar máquina: " + e.getMessage());
            return false;
        }
    }
}
