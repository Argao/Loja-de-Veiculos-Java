package CONTROLLER;

import CONECTADB.ConnMySQL;
import MODEL.Caminhao;
import MODEL.Carro;
import MODEL.Cliente;
import SERVICES.Conexao;
import SERVICES.MudaValores;
import VIEW.CadastroCarros;
import VIEW.CadastroClientes;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CarroController {

    public static void cadastra(CadastroCarros tela, Carro c){
        Connection conexao = ConnMySQL.conectar();
        boolean retorno;
        if (conexao != null){
            LocalDate data = LocalDate.now();
            String sql = "INSERT INTO tab_carros (modelo,marca,placa,renavam,chassi,ano," +
                    "preco,tracao,cambio,hp,disponivel)"+
                    " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

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
                statement.setBoolean(11, c.isDisponivel());


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

    public static ArrayList<Carro> getAll(){
        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_carros WHERE disponivel = 1 ORDER BY modelo;";
        ArrayList<Carro> listaCarros = new ArrayList<>();
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                Carro c = new Carro();
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
                c.setDisponivel(result.getBoolean("disponivel"));

                listaCarros.add(c);
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaCarros;
    }

    public static ArrayList<Carro> getAllRoot(){
        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_carros  ORDER BY modelo;";
        ArrayList<Carro> listaCarros = new ArrayList<>();
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                Carro c = new Carro();
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
                c.setDisponivel(result.getBoolean("disponivel"));

                listaCarros.add(c);
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaCarros;
    }

    public static String relatorioGeral(){

        ArrayList<Carro> lista = getAll();
        String txt = "";

        for (Carro c : lista){
            txt += "\nModelo: " + c.getModelo()+ "\n"+
                    "Marca: " + c.getMarca()+ "\n"+
                    "Placa: " + c.getPlaca() +"\n"+
                    "Ano: " + c.getAno() + "\n"+
                    "Tração: " + c.getTracao()+ "\n" +
                    "Cambio: " + c.getCambio() + "\n" +
                    "Potencia: " + c.getHp() + " cavalos\n" +
                    "RENAVAM: " +c.getRenavam()+ "\n" +
                    "Chassi: " + c.getChassi() + "\n" +
                    "Preço: " +c.getPreco() +
                    "\n\n";
        }
        return txt;
    }

    public static String relatorioGeralRoot(){

        ArrayList<Carro> lista = getAllRoot();
        String txt = "";

        for (Carro c : lista){
            txt += "\nModelo: " + c.getModelo()+ "\n"+
                    "Marca: " + c.getMarca()+ "\n"+
                    "Placa: " + c.getPlaca() +"\n"+
                    "Ano: " + c.getAno() + "\n"+
                    "Potencia: " + c.getHp() + " cavalos\n" +
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

        String sql = "SELECT * FROM tab_carros WHERE disponivel = 1 AND modelo LIKE '%"+modelo+"%'ORDER BY modelo;";
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
                            "Preço: " + result.getDouble("preco") +
                            "\n\n";

            }
            if (txt.equals("")){
                txt = "Nenhum modelo de carro com esse nome foi encontrado!";
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

        String sql = "SELECT * FROM tab_carros WHERE modelo LIKE '%"+modelo+"%'ORDER BY modelo;";
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
                            "Preço: " + result.getDouble("preco") + "\n" +
                            "Disponivel: " + result.getBoolean("disponivel") +
                            "\n\n";

            }
            if (txt.equals("")){
                txt = "Nenhum modelo de carro com esse nome foi encontrado!";
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

        String sql = "SELECT * FROM tab_carros WHERE disponivel = 1 AND marca LIKE '%"+marca+"%'ORDER BY modelo;";
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
                            "Preço: " + result.getDouble("preco") +
                            "\n\n";
            }
            if (txt.equals("")){
                txt = "Nenhum carro dessa marca foi encontrado!";
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

        String sql = "SELECT * FROM tab_carros WHERE marca LIKE '%"+marca+"%'ORDER BY modelo;";
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
                            "Preço: " + result.getDouble("preco") + "\n" +
                            "Disponivel: " + result.getBoolean("disponivel") +
                            "\n\n";
            }
            if (txt.equals("")){
                txt = "Nenhum carro dessa marca foi encontrado!";
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

        String sql = "SELECT * FROM tab_carros WHERE disponivel = 1 AND placa LIKE '%"+placa+"%'ORDER BY modelo;";
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
                            "Preço: " + result.getDouble("preco") +
                            "\n\n";
            }
            if (txt.equals("")){
                txt = "Nenhum carro com essa placa foi encontrado!";
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

        String sql = "SELECT * FROM tab_carros WHERE placa LIKE '%"+placa+"%'ORDER BY modelo;";
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
                            "Preço: " + result.getDouble("preco") +  "\n" +
                            "Disponivel: " + result.getBoolean("disponivel") +
                            "\n\n";
                }

            if (txt.equals("")){
                txt = "Nenhum carro com essa placa  foi encontrado!";
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

        String sql = "SELECT * FROM tab_carros WHERE id = "+id+";";
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
        String sql = "UPDATE tab_carros SET disponivel = 0 WHERE id = "+id+";";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.executeUpdate();

            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
