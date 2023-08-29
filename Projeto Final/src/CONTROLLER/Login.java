package CONTROLLER;

import CONECTADB.ConnMySQL;
import MODEL.Moto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

    public static int logar(String login, String senha) {


           Connection conexao = ConnMySQL.conectar();
           if (conexao != null){
               String sql = "SELECT id FROM tab_funcionarios " +
                       "WHERE login = '"+login+"' AND senha = '"+senha+"'";
               try{
                   Statement statement = conexao.createStatement();
                   ResultSet result = statement.executeQuery(sql);

                   if (result.next()){
                       return result.getInt("id");
                   }

                   return -1;//usuario ou senha errados
               } catch (SQLException throwables) {
                   System.out.println(throwables);
                   return  -2;//erro
               }
           }else {
               return -3;
           }

    }

}
