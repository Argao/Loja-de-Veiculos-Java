package CONTROLLER;

import CONECTADB.ConnMySQL;
import MODEL.Cliente;
import MODEL.Funcionario;
import SERVICES.Conexao;
import SERVICES.MudaValores;
import VIEW.CadastroClientes;
import VIEW.CadastroFuncionarios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClienteController {
    public static void cadastra(CadastroClientes tela, Cliente c){
        Connection conexao = ConnMySQL.conectar();
        boolean retorno;
        if (conexao != null){
            LocalDate data = LocalDate.now();
            String sql = "INSERT INTO tab_clientes (nome,email,cpf,sexo,tel,nascimento," +
                    "cnh,cep,ativo)"+
                    " VALUES (?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement statement = conexao.prepareStatement(sql);
                statement.setString(1,c.getNome());
                statement.setString(2,c.getEmail());
                statement.setString(3,c.getCpf());
                statement.setString(4,c.getSexo());
                statement.setString(5,c.getTel());
                statement.setDate(6, MudaValores.localDateToDate(c.getNascimento()));
                statement.setString(7,c.getCnh());
                statement.setString(8,c.getCep());
                statement.setBoolean(9, c.isAtivo());



                int rows = statement.executeUpdate();
                if(rows>0){
                    tela.limpaOsCampos();
                    tela.sucessoTxt1.setText("Cadastro realizado com sucesso!");
                    //veiculo disponivel
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

    public static ArrayList<Cliente> getAll(){
        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_clientes WHERE ativo = 1 ORDER BY nome;";
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                Cliente c = new Cliente();
                c.setId(result.getInt("id"));
                c.setNome(result.getString("nome"));
                c.setEmail(result.getString("email"));
                c.setCpf(result.getString("cpf"));
                c.setSexo(result.getString("sexo"));
                c.setNascimento(MudaValores.dateToLocalDate(result.getDate("nascimento")));
                c.setTel(result.getString("tel"));
                c.setCnh(result.getString("cnh"));
                c.setCep(result.getString("cep"));
                c.setAtivo(result.getBoolean("ativo"));

                listaClientes.add(c);
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaClientes;
    }
    public static ArrayList<Cliente> getAllRoot(){
        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_clientes  ORDER BY nome;";
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                Cliente c = new Cliente();
                c.setId(result.getInt("id"));
                c.setNome(result.getString("nome"));
                c.setEmail(result.getString("email"));
                c.setCpf(result.getString("cpf"));
                c.setSexo(result.getString("sexo"));
                c.setNascimento(MudaValores.dateToLocalDate(result.getDate("nascimento")));
                c.setTel(result.getString("tel"));
                c.setCnh(result.getString("cnh"));
                c.setCep(result.getString("cep"));
                c.setAtivo(result.getBoolean("ativo"));

                listaClientes.add(c);
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaClientes;
    }

    public static String relatorioGeral(){

        ArrayList<Cliente> lista = getAll();
        String txt = "";

        for (Cliente c : lista){
            txt += "\nNome: " + c.getNome() + "\n"+
            "CPF: " + c.getCpf()+ "\n"+
            "Sexo: " + MudaValores.sexoCompleto(c.getSexo()) +"\n"+
            "Email: " + c.getEmail() + "\n"+
            "Nascimento: " + MudaValores.localDateToString(c.getNascimento()) + "\n" +
            "Telefone: " + c.getTel() + "\n" +
            "Cep: " + c.getCep() + "\n" +
            "CNH: " + c.getCnh() + "\n\n";
        }
        return txt;
    }

    public static String relatorioGeralRoot(){

        ArrayList<Cliente> lista = getAllRoot();
        String txt = "";

        for (Cliente c : lista){
            txt += "\nNome: " + c.getNome() + "\n"+
                    "CPF: " + c.getCpf()+ "\n"+
                    "Sexo: " + MudaValores.sexoCompleto(c.getSexo()) +"\n"+
                    "Email: " + c.getEmail() + "\n"+
                    "Nascimento: " + MudaValores.localDateToString(c.getNascimento()) + "\n" +
                    "Telefone: " + c.getTel() + "\n" +
                    "Cep: " + c.getCep() + "\n" +
                    "CNH: " + c.getCnh() + "\n"+
                    "Ativo: "+c.isAtivo()+ "\n\n";
        }
        return txt;
    }




    public static String relatorioPorNome(String nome){
        String txt = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_clientes WHERE ativo = 1 AND nome LIKE '%"+nome+"%';";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                txt += "\nNome: " + result.getString("nome") + "\n"+
                        "CPF: " + result.getString("cpf") + "\n"+
                        "Sexo: " + MudaValores.sexoCompleto(result.getString("sexo") ) +"\n"+
                        "Email: " + result.getString("email")  + "\n"+
                        "Nascimento: " + MudaValores.localDateToString(MudaValores.dateToLocalDate(result.getDate("nascimento"))) + "\n" +
                        "Telefone: " + result.getString("tel") + "\n" +
                        "Cep: " + result.getString("cep")+ "\n" +
                        "CNH: " + result.getString("cnh")  + "\n\n";
            }
            if (txt.equals("")){
                txt = "Nenhum cliente com esse nome foi encontrado!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return txt;
    }

    public static String relatorioPorNomeRoot(String nome){
        String txt = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_clientes WHERE nome LIKE '%"+nome+"%';";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                txt += "\nNome: " + result.getString("nome") + "\n"+
                        "CPF: " + result.getString("cpf") + "\n"+
                        "Sexo: " + MudaValores.sexoCompleto(result.getString("sexo") ) +"\n"+
                        "Email: " + result.getString("email")  + "\n"+
                        "Nascimento: " + MudaValores.localDateToString(MudaValores.dateToLocalDate(result.getDate("nascimento"))) + "\n" +
                        "Telefone: " + result.getString("tel") + "\n" +
                        "Cep: " + result.getString("cep")+ "\n" +
                        "CNH: " + result.getString("cnh")  + "\n\n";
            }
            if (txt.equals("")){
                txt = "Nenhum cliente com esse nome foi encontrado!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return txt;
    }



    public static String relatorioPorCpf(String cpf){
        String txt = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_clientes WHERE ativo = 1 AND cpf = '"+ cpf+"';";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                txt += "\nNome: " + result.getString("nome") + "\n"+
                        "CPF: " + result.getString("cpf") + "\n"+
                        "Sexo: " + MudaValores.sexoCompleto(result.getString("sexo") ) +"\n"+
                        "Email: " + result.getString("email")  + "\n"+
                        "Nascimento: " + MudaValores.localDateToString(MudaValores.dateToLocalDate(result.getDate("nascimento"))) + "\n" +
                        "Telefone: " + result.getString("tel") + "\n" +
                        "Cep: " + result.getString("cep")+ "\n" +
                        "CNH: " + result.getString("cnh")  + "\n\n";
            }
            if (txt.equals("")){
                txt = "Nenhum cliente com esse cpf foi encontrado!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return txt;
    }

    public static String relatorioPorCpfRoot(String cpf){
        String txt = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_clientes WHERE cpf = '"+ cpf+"';";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                txt += "\nNome: " + result.getString("nome") + "\n"+
                        "CPF: " + result.getString("cpf") + "\n"+
                        "Sexo: " + MudaValores.sexoCompleto(result.getString("sexo") ) +"\n"+
                        "Email: " + result.getString("email")  + "\n"+
                        "Nascimento: " + MudaValores.localDateToString(MudaValores.dateToLocalDate(result.getDate("nascimento"))) + "\n" +
                        "Telefone: " + result.getString("tel") + "\n" +
                        "Cep: " + result.getString("cep")+ "\n" +
                        "CNH: " + result.getString("cnh")  + "\n\n";
            }
            if (txt.equals("")){
                txt = "Nenhum cliente com esse cpf foi encontrado!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return txt;
    }

    public static void exportaTxt(String arquivo,String texto){
        try{
            FileWriter file1 = new FileWriter("c:\\SAIDAJAVA\\"+arquivo+".txt",false);
            BufferedWriter buff2 = new BufferedWriter(file1);
            buff2.write(texto);
            buff2.close();
        } catch (IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public static String achaNomePorId(int id){
        String nome = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_clientes WHERE id = "+id+";";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                nome = result.getString("nome");
            }
            if (nome.equals("")){
                nome = "Erro!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return nome;
    }
}





