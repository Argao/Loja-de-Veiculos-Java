package CONECTADB;

import VIEW.TelaInicial;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class ConnMySQL {
    public static Connection conectar(){
        String server = "localhost";
        String port = "3306";
        String banco = "loja_de_veiculos";
        String url = "jdbc:mysql://" + server + ":" + port + "/" + banco;
        //jdbc:mysql://localhost:3306/teste
        String user = "root";
        String password = "";
        Connection conn = null;
        TelaInicial tela = new TelaInicial();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
        }catch(SQLTimeoutException e ){
            JOptionPane.showMessageDialog(tela,"Tempo de conexão esgotado!","Erro",JOptionPane.ERROR_MESSAGE,null);
            System.err.println("\nTempo de conexão esgotado!\n");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(tela,"Erro inesperado:\n" + e + "\nContate o suporte","Erro",JOptionPane.ERROR_MESSAGE,null);
            System.out.println("\nErro inesperado:\n" + e);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(tela,"DRIVER NÃO CARREGADO!\nCONTATE SUPORTE!","Erro",JOptionPane.ERROR_MESSAGE,null);
            System.out.println("\nDRIVER NÃO CARREGADO!\n");
        }
        return conn;
    }
}
