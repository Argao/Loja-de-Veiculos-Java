package SERVICES;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {
    public static void encerraConexao(Connection conexao) {
        try{
            conexao.close();
        } catch (SQLException e) {
            System.err.println("\nErro inesperado:\n" + e);
        }
    }
}
