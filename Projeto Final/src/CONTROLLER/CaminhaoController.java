package CONTROLLER;

import CONECTADB.ConnMySQL;
import MODEL.Caminhao;
import MODEL.Carro;
import MODEL.Moto;
import SERVICES.Conexao;
import VIEW.CadastroCaminhoes;
import VIEW.CadastroCarros;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CaminhaoController {

    public static void cadastra(CadastroCaminhoes tela, Caminhao c){
        Connection conexao = ConnMySQL.conectar();
        boolean retorno;
        if (conexao != null){
            LocalDate data = LocalDate.now();
            String sql = "INSERT INTO tab_caminhoes (modelo,marca,placa,renavam,chassi,ano," +
                    "preco,tracao,cambio,hp,capacidade_de_carga,disponivel)"+
                    " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement statement = conexao.prepareStatement(sql);
                statement.setString(1,c.getModelo());
                statement.setString(2,c.getMarca());
                statement.setString(3,c.getPlaca());
                statement.setString(4,c.getRenavam());
                statement.setString(5,c.getChassi());
                statement.setInt(6,c.getAno());
                statement.setDouble(7,c.getPreco());
                statement.setString(8,c.getTracao());
                statement.setString(9, c.getCambio());
                statement.setInt(10,c.getHp());
                statement.setInt(11,c.getCapacidadeDeCarga());
                statement.setBoolean(12, c.isDisponivel());


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

    public static ArrayList<Caminhao> getAll(){
        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_caminhoes WHERE disponivel = 1 ORDER BY modelo;";
        ArrayList<Caminhao> listaCaminhoes = new ArrayList<>();
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                Caminhao c = new Caminhao();
                c.setId(result.getInt("id"));
                c.setModelo(result.getString("modelo"));
                c.setMarca(result.getString("marca"));
                c.setPlaca(result.getString("placa"));
                c.setRenavam(result.getString("renavam"));
                c.setChassi(result.getString("chassi"));
                c.setAno(result.getInt("ano"));
                c.setPreco(result.getDouble("preco"));
                c.setTracao(result.getString("tracao"));
                c.setCambio(result.getString("cambio"));
                c.setHp(result.getInt("hp"));
                c.setCapacidadeDeCarga(result.getInt("capacidade_de_carga"));
                c.setDisponivel(result.getBoolean("disponivel"));

                listaCaminhoes.add(c);
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaCaminhoes;
    }

    public static ArrayList<Caminhao> getAllRoot(){
        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_caminhoes  ORDER BY modelo;";
        ArrayList<Caminhao> listaCaminhao = new ArrayList<>();
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                Caminhao c = new Caminhao();
                c.setId(result.getInt("id"));
                c.setModelo(result.getString("modelo"));
                c.setMarca(result.getString("marca"));
                c.setPlaca(result.getString("placa"));
                c.setRenavam(result.getString("renavam"));
                c.setChassi(result.getString("chassi"));
                c.setAno(result.getInt("ano"));
                c.setPreco(result.getDouble("preco"));
                c.setTracao(result.getString("tracao"));
                c.setCambio(result.getString("cambio"));
                c.setHp(result.getInt("hp"));
                c.setCapacidadeDeCarga(result.getInt("capacidade_de_carga"));
                c.setDisponivel(result.getBoolean("disponivel"));

                listaCaminhao.add(c);
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaCaminhao;
    }


    public static String relatorioGeral(){

        ArrayList<Caminhao> lista = getAll();
        String txt = "";

        for (Caminhao c : lista){
            txt += "\nModelo: " + c.getModelo()+ "\n"+
                    "Marca: " + c.getMarca()+ "\n"+
                    "Placa: " + c.getPlaca() +"\n"+
                    "Ano: " + c.getAno() + "\n"+
                    "Tração: " + c.getTracao()+ "\n" +
                    "Cambio: " + c.getCambio() + "\n" +
                    "Potencia: " + c.getHp() + " cavalos\n" +
                    "RENAVAM: " +c.getRenavam()+ "\n" +
                    "Chassi: " + c.getChassi() + "\n" +
                    "Capacidade: " + c.getCapacidadeDeCarga() + " KG\n"+
                    "Preço: " +c.getPreco() +
                    "\n\n";
        }
        return txt;
    }

    public static String relatorioGeralRoot(){

        ArrayList<Caminhao> lista = getAllRoot();
        String txt = "";

        for (Caminhao c : lista){
            txt += "\nModelo: " + c.getModelo()+ "\n"+
                    "Marca: " + c.getMarca()+ "\n"+
                    "Placa: " + c.getPlaca() +"\n"+
                    "Ano: " + c.getAno() + "\n"+
                    "Potencia: " + c.getHp() + " cavalos\n" +
                    "RENAVAM: " +c.getRenavam()+ "\n" +
                    "Chassi: " + c.getChassi() + "\n" +
                    "Preço: " +c.getPreco() + "\n" +
                    "Capacidade: " + c.getCapacidadeDeCarga() + " KG\n"+
                    "Disponivel: " + c.isDisponivel() +
                    "\n\n";
        }

        return txt;
    }



    public static String relatorioPorModelo(String modelo){
        String txt = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_caminhoes WHERE disponivel = 1 AND modelo LIKE '%"+modelo+"%'ORDER BY modelo;";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){


                    txt += "\nModelo: " + result.getString("modelo")+ "\n"+
                            "Marca: " + result.getString("marca")+ "\n"+
                            "Placa: " + result.getString("placa") +"\n"+
                            "Ano: " + result.getInt("ano") + "\n"+
                            "Tração: " + result.getString("tracao") + "\n" +
                            "Cambio: " + result.getString("cambio") + "\n" +
                            "Potencia: " + result.getInt("hp") + " cavalos\n" +
                            "RENAVAM: " +result.getString("renavam")+ "\n" +
                            "Chassi: " + result.getString("chassi") + "\n" +
                            "Capacidade: " + result.getInt("capacidade_de_carga") + " KG\n"+
                            "Preço: " + result.getDouble("preco") +
                            "\n\n";

            }
            if (txt.equals("")){
                txt = "Nenhum modelo de caminhao com esse nome foi encontrado!";
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

        String sql = "SELECT * FROM tab_caminhoes WHERE modelo LIKE '%"+modelo+"%'ORDER BY modelo;";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){


                    txt += "\nModelo: " + result.getString("modelo")+ "\n"+
                            "Marca: " + result.getString("marca")+ "\n"+
                            "Placa: " + result.getString("placa") +"\n"+
                            "Ano: " + result.getInt("ano") + "\n"+
                            "Tração: " + result.getString("tracao") + "\n" +
                            "Cambio: " + result.getString("cambio") + "\n" +
                            "Potencia: " + result.getInt("hp") + " cavalos\n" +
                            "RENAVAM: " +result.getString("renavam")+ "\n" +
                            "Chassi: " + result.getString("chassi") + "\n" +
                            "Capacidade: " + result.getInt("capacidade_de_carga") + " KG\n"+
                            "Preço: " + result.getDouble("preco") + "\n" +
                            "Disponivel: " + result.getBoolean("disponivel") +
                            "\n\n";

            }
            if (txt.equals("")){
                txt = "Nenhum modelo de caminhão com esse nome foi encontrado!";
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

        String sql = "SELECT * FROM tab_caminhoes WHERE disponivel = 1 AND marca LIKE '%"+marca+"%'ORDER BY modelo;";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){


                    txt += "\nModelo: " + result.getString("modelo")+ "\n"+
                            "Marca: " + result.getString("marca")+ "\n"+
                            "Placa: " + result.getString("placa") +"\n"+
                            "Ano: " + result.getInt("ano") + "\n"+
                            "Tração: " + result.getString("tracao") + "\n" +
                            "Cambio: " + result.getString("cambio") + "\n" +
                            "Potencia: " + result.getInt("hp") + " cavalos\n" +
                            "RENAVAM: " +result.getString("renavam")+ "\n" +
                            "Chassi: " + result.getString("chassi") + "\n" +
                            "Capacidade: " + result.getInt("capacidade_de_carga") + " KG\n"+
                            "Preço: " + result.getDouble("preco") +
                            "\n\n";

            }
            if (txt.equals("")){
                txt = "Nenhum caminhão dessa marca foi encontrado!";
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

        String sql = "SELECT * FROM tab_caminhoes WHERE marca LIKE '%"+marca+"%'ORDER BY modelo;";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){


                    txt += "\nModelo: " + result.getString("modelo")+ "\n"+
                            "Marca: " + result.getString("marca")+ "\n"+
                            "Placa: " + result.getString("placa") +"\n"+
                            "Ano: " + result.getInt("ano") + "\n"+
                            "Tração: " + result.getString("tracao") + "\n" +
                            "Cambio: " + result.getString("cambio") + "\n" +
                            "Potencia: " + result.getInt("hp") + " cavalos\n" +
                            "RENAVAM: " +result.getString("renavam")+ "\n" +
                            "Chassi: " + result.getString("chassi") + "\n" +
                            "Capacidade: " + result.getInt("capacidade_de_carga") + " KG\n"+
                            "Preço: " + result.getDouble("preco") + "\n" +
                            "Disponivel: " + result.getBoolean("disponivel") +
                            "\n\n";

            }
            if (txt.equals("")){
                txt = "Nenhum caminhão dessa marca foi encontrado!";
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

        String sql = "SELECT * FROM tab_caminhoes WHERE disponivel = 1 AND placa LIKE '%"+placa+"%'ORDER BY modelo;";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){

                    txt += "\nModelo: " + result.getString("modelo")+ "\n"+
                            "Marca: " + result.getString("marca")+ "\n"+
                            "Placa: " + result.getString("placa") +"\n"+
                            "Ano: " + result.getInt("ano") + "\n"+
                            "Tração: " + result.getString("tracao") + "\n" +
                            "Cambio: " + result.getString("cambio") + "\n" +
                            "Potencia: " + result.getInt("hp") + " cavalos\n" +
                            "RENAVAM: " +result.getString("renavam")+ "\n" +
                            "Chassi: " + result.getString("chassi") + "\n" +
                            "Capacidade: " + result.getInt("capacidade_de_carga") + " KG\n"+
                            "Preço: " + result.getDouble("preco") +
                            "\n\n";

            }
            if (txt.equals("")){
                txt = "Nenhum caminhão com essa placa foi encontrado!";
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

        String sql = "SELECT * FROM tab_caminhoes WHERE placa LIKE '%"+placa+"%'ORDER BY modelo;";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){


                    txt += "\nModelo: " + result.getString("modelo")+ "\n"+
                            "Marca: " + result.getString("marca")+ "\n"+
                            "Placa: " + result.getString("placa") +"\n"+
                            "Ano: " + result.getInt("ano") + "\n"+
                            "Tração: " + result.getString("tracao") + "\n" +
                            "Cambio: " + result.getString("cambio") + "\n" +
                            "Potencia: " + result.getInt("hp") + " cavalos\n" +
                            "RENAVAM: " +result.getString("renavam")+ "\n" +
                            "Chassi: " + result.getString("chassi") + "\n" +
                            "Capacidade: " + result.getInt("capacidade_de_carga") + " KG\n"+
                            "Preço: " + result.getDouble("preco") +
                            "Disponivel: " + result.getBoolean("disponivel") +
                            "\n\n";

            }
            if (txt.equals("")){
                txt = "Nenhum caminhão com essa placa foi encontrado!";
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

        String sql = "SELECT * FROM tab_caminhoes WHERE id = "+id+";";
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
        String sql = "UPDATE tab_caminhoes SET disponivel = 0 WHERE id = "+id+";";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.executeUpdate();

            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
