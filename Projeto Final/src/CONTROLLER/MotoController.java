package CONTROLLER;

import CONECTADB.ConnMySQL;
import MODEL.Carro;
import MODEL.Funcionario;
import MODEL.Moto;
import SERVICES.Conexao;
import SERVICES.MudaValores;
import VIEW.CadastroCarros;
import VIEW.CadastroMotos;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MotoController {

    public static void cadastra(CadastroMotos tela, Moto c){
        Connection conexao = ConnMySQL.conectar();
        boolean retorno;
        if (conexao != null){
            LocalDate data = LocalDate.now();
            String sql = "INSERT INTO tab_motos (modelo,marca,placa,renavam,chassi,ano," +
                    "preco,cilindradas,disponivel)"+
                    " VALUES (?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement statement = conexao.prepareStatement(sql);
                statement.setString(1,c.getModelo());
                statement.setString(2,c.getMarca());
                statement.setString(3,c.getPlaca());
                statement.setString(4,c.getRenavam());
                statement.setString(5,c.getChassi());
                statement.setInt(6,c.getAno());
                statement.setDouble(7,c.getPreco());
                statement.setInt(8,c.getCilindrada());
                statement.setBoolean(9, c.isDisponivel());


                int rows = statement.executeUpdate();
                if(rows>0){
                    tela.limpaOsCampos();
                    tela.sucessoTxt1.setText("Cadastro realizado com sucesso!");
                }else{

                }
            }catch (SQLException throwables) {
                throwables.printStackTrace();
                retorno = false;
            }
        }else {
            retorno = false;
        }

        Conexao.encerraConexao(conexao);
    }

    public static ArrayList<Moto> getAll(){
        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_motos WHERE disponivel = 1  ORDER BY modelo;";
        ArrayList<Moto> listaMotos = new ArrayList<>();
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                Moto c = new Moto();
                c.setId(result.getInt("id"));
                c.setModelo(result.getString("modelo"));
                c.setMarca(result.getString("marca"));
                c.setPlaca(result.getString("placa"));
                c.setRenavam(result.getString("renavam"));
                c.setChassi(result.getString("chassi"));
                c.setAno(result.getInt("ano"));
                c.setPreco(result.getDouble("preco"));
                c.setCilindrada(result.getInt("cilindradas"));
                c.setDisponivel(result.getBoolean("disponivel"));

                listaMotos.add(c);
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaMotos;
    }

    public static ArrayList<Moto> getAllRoot(){
        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_motos  ORDER BY modelo;";
        ArrayList<Moto> listaMotos = new ArrayList<>();
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                Moto c = new Moto();
                c.setId(result.getInt("id"));
                c.setModelo(result.getString("modelo"));
                c.setMarca(result.getString("marca"));
                c.setPlaca(result.getString("placa"));
                c.setRenavam(result.getString("renavam"));
                c.setChassi(result.getString("chassi"));
                c.setAno(result.getInt("ano"));
                c.setPreco(result.getDouble("preco"));
                c.setCilindrada(result.getInt("cilindradas"));
                c.setDisponivel(result.getBoolean("disponivel"));

                listaMotos.add(c);
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaMotos;
    }


    public static String relatorioGeral(){

        ArrayList<Moto> lista = getAll();
        String txt = "";

        for (Moto c : lista){
            txt += "\nModelo: " + c.getModelo()+ "\n"+
                    "Marca: " + c.getMarca()+ "\n"+
                    "Placa: " + c.getPlaca() +"\n"+
                    "Ano: " + c.getAno() + "\n"+
                    "Potencia: " + c.getCilindrada() + " cilindradas\n" +
                    "RENAVAM: " +c.getRenavam()+ "\n" +
                    "Chassi: " + c.getChassi() + "\n" +
                    "Preço: " +c.getPreco() +
                    "\n\n";
        }
        return txt;
    }

    public static String relatorioGeralRoot(){

        ArrayList<Moto> lista = getAllRoot();
        String txt = "";

        for (Moto c : lista){
            txt += "\nModelo: " + c.getModelo()+ "\n"+
                    "Marca: " + c.getMarca()+ "\n"+
                    "Placa: " + c.getPlaca() +"\n"+
                    "Ano: " + c.getAno() + "\n"+
                    "Potencia: " + c.getCilindrada() + " cilindradas\n" +
                    "RENAVAM: " +c.getRenavam()+ "\n" +
                    "Chassi: " + c.getChassi() + "\n" +
                    "Preço: " +c.getPreco() + "\n" +
                    "Disponivel: " + c.isDisponivel() +
                    "\n\n";
        }

        return txt;
    }


    public static String relatorioPorModelo(String modelo){
        String txt = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_motos WHERE disponivel = 1 AND modelo LIKE '%"+modelo+"%'ORDER BY modelo;";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){


                    txt += "\nModelo: " + result.getString("modelo")+ "\n"+
                            "Marca: " + result.getString("marca")+ "\n"+
                            "Placa: " + result.getString("placa") +"\n"+
                            "Ano: " + result.getInt("ano") + "\n"+
                            "Potencia: " + result.getInt("cilindradas") + " cilindradas\n" +
                            "RENAVAM: " +result.getString("renavam")+ "\n" +
                            "Chassi: " + result.getString("chassi") + "\n" +
                            "Preço: " + result.getDouble("preco") +
                            "\n\n";

            }
            if (txt.equals("")){
                txt = "Nenhum modelo de moto com esse nome foi encontrado!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return txt;
    }

    public static String relatorioPorModeloRoot(String modelo){
        String txt = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_motos WHERE modelo LIKE '%"+modelo+"%'ORDER BY modelo;";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){


                    txt += "\nModelo: " + result.getString("modelo")+ "\n"+
                            "Marca: " + result.getString("marca")+ "\n"+
                            "Placa: " + result.getString("placa") +"\n"+
                            "Ano: " + result.getInt("ano") + "\n"+
                            "Potencia: " + result.getInt("cilindradas") + " cilindradas\n" +
                            "RENAVAM: " +result.getString("renavam")+ "\n" +
                            "Chassi: " + result.getString("chassi") + "\n" +
                            "Preço: " + result.getDouble("preco") + "\n"+
                            "Disponivel: " + result.getBoolean("disponivel") +
                            "\n\n";

            }
            if (txt.equals("")){
                txt = "Nenhum modelo de moto com esse nome foi encontrado!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return txt;
    }

    public static String relatorioPorMarca(String marca){
        String txt = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_motos WHERE disponivel = 1 AND marca LIKE '%"+marca+"%'ORDER BY modelo;";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){


                    txt += "\nModelo: " + result.getString("modelo")+ "\n"+
                            "Marca: " + result.getString("marca")+ "\n"+
                            "Placa: " + result.getString("placa") +"\n"+
                            "Ano: " + result.getInt("ano") + "\n"+
                            "Potencia: " + result.getInt("cilindradas") + " cilindradas\n" +
                            "RENAVAM: " +result.getString("renavam")+ "\n" +
                            "Chassi: " + result.getString("chassi") + "\n" +
                            "Preço: " + result.getDouble("preco") +
                            "\n\n";

            }
            if (txt.equals("")){
                txt = "Nenhuma moto dessa marca foi encontrada!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return txt;
    }

    public static String relatorioPorMarcaRoot(String marca){
        String txt = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_motos WHERE marca LIKE '%"+marca+"%'ORDER BY modelo;";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){


                    txt += "\nModelo: " + result.getString("modelo")+ "\n"+
                            "Marca: " + result.getString("marca")+ "\n"+
                            "Placa: " + result.getString("placa") +"\n"+
                            "Ano: " + result.getInt("ano") + "\n"+
                            "Potencia: " + result.getInt("cilindradas") + " cilindradas\n" +
                            "RENAVAM: " +result.getString("renavam")+ "\n" +
                            "Chassi: " + result.getString("chassi") + "\n" +
                            "Preço: " + result.getDouble("preco") + "\n" +
                            "Disponivel: " + result.getBoolean("disponivel") +
                            "\n\n";

            }
            if (txt.equals("")){
                txt = "Nenhuma moto dessa marca foi encontrada!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return txt;
    }

    public static String relatorioPorPlaca(String placa){
        String txt = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_motos WHERE disponivel = 1 AND placa LIKE '%"+placa+"%'ORDER BY modelo;";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){


                    txt += "\nModelo: " + result.getString("modelo")+ "\n"+
                            "Marca: " + result.getString("marca")+ "\n"+
                            "Placa: " + result.getString("placa") +"\n"+
                            "Ano: " + result.getInt("ano") + "\n"+
                            "Potencia: " + result.getInt("cilindradas") + " cilindradas\n" +
                            "RENAVAM: " +result.getString("renavam")+ "\n" +
                            "Chassi: " + result.getString("chassi") + "\n" +
                            "Preço: " + result.getDouble("preco") +
                            "\n\n";

            }
            if (txt.equals("")){
                txt = "Nenhuma moto com essa placa foi encontrada!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return txt;
    }

    public static String relatorioPorPlacaRoot(String placa){
        String txt = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_motos WHERE placa LIKE '%"+placa+"%'ORDER BY modelo;";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){


                    txt += "\nModelo: " + result.getString("modelo")+ "\n"+
                            "Marca: " + result.getString("marca")+ "\n"+
                            "Placa: " + result.getString("placa") +"\n"+
                            "Ano: " + result.getInt("ano") + "\n"+
                            "Potencia: " + result.getInt("cilindradas") + " cilindradas\n" +
                            "RENAVAM: " +result.getString("renavam")+ "\n" +
                            "Chassi: " + result.getString("chassi") + "\n" +
                            "Preço: " + result.getDouble("preco") + "\n" +
                            "Disponivel: " + result.getBoolean("disponivel") +
                            "\n\n";

            }
            if (txt.equals("")){
                txt = "Nenhuma moto com essa  placa foi encontrada!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return txt;
    }

    public static String achaModeloPorId(int id){
        String modelo = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_motos WHERE id = "+id+";";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                modelo = result.getString("modelo");
            }
            if (modelo.equals("")){
                modelo = "Erro!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return modelo;
    }





    public static void desativa(int id){
        Connection conexao = ConnMySQL.conectar();
        String sql = "UPDATE tab_motos SET disponivel = 0 WHERE id = "+id+";";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.executeUpdate();

            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
