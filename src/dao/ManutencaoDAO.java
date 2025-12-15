package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Manutencao;

public class ManutencaoDAO {

    // ================= INSERIR =================
    public boolean inserir(Manutencao manutencao) {

        String sql = "INSERT INTO manutencao (tipo, data, maquina_id, peca, descricao) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try {
            Connection con = ConexaoDAO.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, manutencao.getTipo());
            ps.setDate(2, manutencao.getData());
            ps.setInt(3, manutencao.getMaquinaId());
            ps.setInt(4, manutencao.getPeca());
            ps.setString(5, manutencao.getDescricao());

            ps.execute();

            ps.close();
            con.close();

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir manutenção: " + e.getMessage());
            return false;
        }
    }

    // ================= LISTAR =================
    public List<Manutencao> listar() {

        List<Manutencao> lista = new ArrayList<>();
        String sql = "SELECT * FROM manutencao";

        try {
            Connection con = ConexaoDAO.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Manutencao m = new Manutencao();
                m.setId(rs.getInt("id"));
                m.setTipo(rs.getString("tipo"));
                m.setData(rs.getDate("data"));
                m.setMaquinaId(rs.getInt("maquina_id"));
                m.setPeca(rs.getInt("peca"));
                m.setDescricao(rs.getString("descricao"));

                lista.add(m);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Erro ao listar manutenções: " + e.getMessage());
        }

        return lista;
    }

    // ================= EXCLUIR =================
    public boolean excluir(int id) {

        String sql = "DELETE FROM manutencao WHERE id = ?";

        try {
            Connection con = ConexaoDAO.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.execute();

            ps.close();
            con.close();

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir manutenção: " + e.getMessage());
            return false;
        }
    }    
        //ATUALIZAR//
        public boolean atualizar(Manutencao m) {

    String sql = "UPDATE manutencao SET tipo = ?, data = ?, maquina_id = ?, peca = ?, descricao = ? WHERE id = ?";

    try {
        Connection con = ConexaoDAO.conectar();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, m.getTipo());
        ps.setDate(2, m.getData());
        ps.setInt(3, m.getMaquinaId());
        ps.setInt(4, m.getPeca());
        ps.setString(5, m.getDescricao());
        ps.setInt(6, m.getId());

        ps.executeUpdate();

        ps.close();
        con.close();

        return true;

    } catch (Exception e) {
        System.out.println("Erro ao atualizar manutenção: " + e.getMessage());
        return false;
    
    }
        
        
    }

}