package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDAO {

    private static final String URL =
        "jdbc:mysql://127.0.0.1:3306/gerenciamento_hardware";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException("Erro na conexão: " + e.getMessage());
        }
    }
}
