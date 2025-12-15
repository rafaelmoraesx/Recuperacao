package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Peca;

public class PecaDAO {

    // ================= INSERIR =================
    public boolean inserir(Peca peca) {

        String sql = "INSERT INTO peca (nome, tipo, quantidade, laboratorio_id) "
                   + "VALUES (?, ?, ?, ?)";

        try {
            Connection con = ConexaoDAO.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, peca.getNome());
            ps.setString(2, peca.getTipo());
            ps.setInt(3, peca.getQuantidade());
            ps.setInt(4, peca.getLaboratorioId());

            ps.execute();

            ps.close();
            con.close();

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir peça: " + e.getMessage());
            return false;
        }
    }

    // ================= LISTAR =================
    public List<Peca> listar() {

        List<Peca> lista = new ArrayList<>();
        String sql = "SELECT * FROM peca";

        try {
            Connection con = ConexaoDAO.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Peca p = new Peca();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setTipo(rs.getString("tipo"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setLaboratorioId(rs.getInt("laboratorio_id"));

                lista.add(p);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Erro ao listar peças: " + e.getMessage());
        }

        return lista;
    }

    // ================= EXCLUIR =================
    public boolean excluir(int id) {

        String sql = "DELETE FROM peca WHERE id = ?";

        try {
            Connection con = ConexaoDAO.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.execute();

            ps.close();
            con.close();

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir peça: " + e.getMessage());
            return false;
        }
    }    
        
        //ATUALIZAR//
        
        public boolean atualizar(Peca peca) {

    String sql = "UPDATE peca SET nome = ?, tipo = ?, quantidade = ?, laboratorio_id = ? WHERE id = ?";

    try {
        Connection con = ConexaoDAO.conectar();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, peca.getNome());
        ps.setString(2, peca.getTipo());
        ps.setInt(3, peca.getQuantidade());
        ps.setInt(4, peca.getLaboratorioId());
        ps.setInt(5, peca.getId());

        ps.executeUpdate();

        ps.close();
        con.close();

        return true;

    } catch (Exception e) {
        System.out.println("Erro ao atualizar peça: " + e.getMessage());
        return false;
    
        }
    
        }
}

