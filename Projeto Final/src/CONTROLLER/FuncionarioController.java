package CONTROLLER;

import CONECTADB.ConnMySQL;
import MODEL.Cliente;
import MODEL.Funcionario;
import SERVICES.Conexao;
import SERVICES.MudaValores;
import VIEW.CadastroFuncionarios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FuncionarioController  {
    public static void cadastra(CadastroFuncionarios tela,Funcionario f){
        Connection conexao = ConnMySQL.conectar();
        boolean retorno;
        if (conexao != null){
            LocalDate data = LocalDate.now();
            String sql = "INSERT INTO tab_funcionarios (nome,email,cpf,login,senha,sexo,tel,nascimento," +
                    "titulo_de_eleitor,certificado_de_reservista,cargo,ativo )"+
                    " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement statement = conexao.prepareStatement(sql);
                statement.setString(1,f.getNome());
                statement.setString(2,f.getEmail());
                statement.setString(3,f.getCpf());
                statement.setString(4,f.getLogin());
                statement.setString(5,f.getSenha());
                statement.setString(6,f.getSexo());
                statement.setString(7,f.getTel());
                statement.setDate(8, MudaValores.localDateToDate(f.getNascimento()));
                statement.setString(9,f.getTituloDeEleitor());
                statement.setString(10,f.getCertificadoDeReservista());
                statement.setString(11,f.getCargo());
                statement.setBoolean(12,f.isAtivo());


                int rows = statement.executeUpdate();
                if(rows>0){
                  tela.limpaOsCampos();
                  tela.sucessoTxt.setText("Cadastro realizado com sucesso!");
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

    public static ArrayList<Funcionario> getAll(){
        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_funcionarios WHERE ativo = 1 AND id <> 1 ORDER BY nome;";
        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                Funcionario c = new Funcionario();
                c.setId(result.getInt("id"));
                c.setNome(result.getString("nome"));
                c.setEmail(result.getString("email"));
                c.setCpf(result.getString("cpf"));
                c.setSexo(result.getString("sexo"));
                c.setNascimento(MudaValores.dateToLocalDate(result.getDate("nascimento")));
                c.setTel(result.getString("tel"));
                c.setTituloDeEleitor(result.getString("titulo_de_eleitor"));
                c.setCertificadoDeReservista(result.getString("certificado_de_reservista"));
                c.setAtivo(result.getBoolean("ativo"));
                c.setLogin(result.getString("login"));
                c.setSenha(result.getString("senha"));
                c.setCargo(result.getString("cargo"));

                listaFuncionario.add(c);
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaFuncionario;
    }

    public static ArrayList<Funcionario> getAllRoot(){
        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_funcionarios WHERE id <> 1 ORDER BY nome;";
        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                Funcionario c = new Funcionario();
                c.setId(result.getInt("id"));
                c.setNome(result.getString("nome"));
                c.setEmail(result.getString("email"));
                c.setCpf(result.getString("cpf"));
                c.setSexo(result.getString("sexo"));
                c.setNascimento(MudaValores.dateToLocalDate(result.getDate("nascimento")));
                c.setTel(result.getString("tel"));
                c.setTituloDeEleitor(result.getString("titulo_de_eleitor"));
                c.setCertificadoDeReservista(result.getString("certificado_de_reservista"));
                c.setAtivo(result.getBoolean("ativo"));
                c.setLogin(result.getString("login"));
                c.setSenha(result.getString("senha"));
                c.setCargo(result.getString("cargo"));

                listaFuncionario.add(c);
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaFuncionario;
    }



    public static String relatorioGeral(){

        ArrayList<Funcionario> lista = getAll();
        String txt = "";

        for (Funcionario c : lista){
            txt += "\nNome: " + c.getNome() + "\n"+
                    "CPF: " + c.getCpf()+ "\n"+
                    "Sexo: " + MudaValores.sexoCompleto(c.getSexo()) +"\n"+
                    "Email: " + c.getEmail() + "\n"+
                    "Nascimento: " + MudaValores.localDateToString(c.getNascimento()) + "\n" +
                    "Telefone: " + c.getTel() + "\n" +
                    "Cargo: " + c.getCargo() + "\n" +
                    "Titulo de eleitor: " + c.getTituloDeEleitor() + "\n" +
                    "Certificado de reservista: " + c.getCertificadoDeReservista() +
                    "\n\n";
        }
        return txt;
    }

    public static String relatorioGeralRoot(){

        ArrayList<Funcionario> lista = getAllRoot();
        String txt = "";

        for (Funcionario c : lista){
            txt += "\nNome: " + c.getNome() + "\n"+
                    "CPF: " + c.getCpf()+ "\n"+
                    "Sexo: " + MudaValores.sexoCompleto(c.getSexo()) +"\n"+
                    "Email: " + c.getEmail() + "\n"+
                    "Nascimento: " + MudaValores.localDateToString(c.getNascimento()) + "\n" +
                    "Telefone: " + c.getTel() + "\n" +
                    "Cargo: " + c.getCargo() + "\n" +
                    "Titulo de eleitor: " + c.getTituloDeEleitor() + "\n" +
                    "Certificado de reservista: " + c.getCertificadoDeReservista() + "\n" +
                    "Ativo: " + c.isAtivo() +
                    "\n\n";
        }

        return txt;
    }




    public static String relatorioPorNome(String nome){
        String txt = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_funcionarios WHERE ativo = 1 AND nome LIKE '%"+nome+"%';";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                txt += "\nNome: " + result.getString("nome")+ "\n"+
                        "CPF: " + result.getString("cpf")+ "\n"+
                        "Sexo: " + MudaValores.sexoCompleto(result.getString("sexo")) +"\n"+
                        "Email: " + result.getString("email") + "\n"+
                        "Nascimento: " + MudaValores.localDateToString(MudaValores.dateToLocalDate(result.getDate("nascimento"))) + "\n" +
                        "Telefone: " + result.getString("tel") + "\n" +
                        "Cargo: " + result.getString("cargo") + "\n" +
                        "Titulo de eleitor: " +result.getString("titulo_de_eleitor")+ "\n" +
                        "Certificado de reservista: " + result.getString("certificado_de_reservista") +
                        "\n\n";
            }
            if (txt.equals("")){
                txt = "Nenhum funcionario com esse nome foi encontrado!";
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

        String sql = "SELECT * FROM tab_funcionarios WHERE nome LIKE '%"+nome+"%';";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                txt += "\nNome: " + result.getString("nome")+ "\n"+
                        "CPF: " + result.getString("cpf")+ "\n"+
                        "Sexo: " + MudaValores.sexoCompleto(result.getString("sexo")) +"\n"+
                        "Email: " + result.getString("email") + "\n"+
                        "Nascimento: " + MudaValores.localDateToString(MudaValores.dateToLocalDate(result.getDate("nascimento"))) + "\n" +
                        "Telefone: " + result.getString("tel") + "\n" +
                        "Cargo: " + result.getString("cargo") + "\n" +
                        "Titulo de eleitor: " +result.getString("titulo_de_eleitor")+ "\n" +
                        "Certificado de reservista: " + result.getString("certificado_de_reservista") +
                        "Ativo: " + result.getBoolean("ativo") +"\n"+
                        "\n\n";
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

        String sql = "SELECT * FROM tab_funcionarios WHERE ativo = 1 AND cpf = '"+ cpf+"';";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                txt += "\nNome: " + result.getString("nome")+ "\n"+
                        "CPF: " + result.getString("cpf")+ "\n"+
                        "Sexo: " + MudaValores.sexoCompleto(result.getString("sexo")) +"\n"+
                        "Email: " + result.getString("email") + "\n"+
                        "Nascimento: " + MudaValores.localDateToString(MudaValores.dateToLocalDate(result.getDate("nascimento"))) + "\n" +
                        "Telefone: " + result.getString("tel") + "\n" +
                        "Cargo: " + result.getString("cargo") + "\n" +
                        "Titulo de eleitor: " +result.getString("titulo_de_eleitor")+ "\n" +
                        "Certificado de reservista: " + result.getString("certificado_de_reservista") +
                        "\n\n";
            }
            if (txt.equals("")){
                txt = "Nenhum funcionario com esse cpf foi encontrado!";
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

        String sql = "SELECT * FROM tab_funcionarios WHERE cpf = '"+ cpf+"';";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                txt += "\nNome: " + result.getString("nome")+ "\n"+
                        "CPF: " + result.getString("cpf")+ "\n"+
                        "Sexo: " + MudaValores.sexoCompleto(result.getString("sexo")) +"\n"+
                        "Email: " + result.getString("email") + "\n"+
                        "Nascimento: " + MudaValores.localDateToString(MudaValores.dateToLocalDate(result.getDate("nascimento"))) + "\n" +
                        "Telefone: " + result.getString("tel") + "\n" +
                        "Cargo: " + result.getString("cargo") + "\n" +
                        "Titulo de eleitor: " +result.getString("titulo_de_eleitor")+ "\n" +
                        "Certificado de reservista: " + result.getString("certificado_de_reservista") +"\n"+
                        "Ativo: " + result.getBoolean("ativo") +
                        "\n\n";
            }
            if (txt.equals("")){
                txt = "Nenhum Funcionario com esse cpf foi encontrado!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return txt;
    }

    public static String relatorioPorCargo(String cargo){
        String txt = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_funcionarios WHERE ativo = 1 AND cargo LIKE '%"+ cargo +"%';";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                txt += "\nNome: " + result.getString("nome")+ "\n"+
                        "CPF: " + result.getString("cpf")+ "\n"+
                        "Sexo: " + MudaValores.sexoCompleto(result.getString("sexo")) +"\n"+
                        "Email: " + result.getString("email") + "\n"+
                        "Nascimento: " + MudaValores.localDateToString(MudaValores.dateToLocalDate(result.getDate("nascimento"))) + "\n" +
                        "Telefone: " + result.getString("tel") + "\n" +
                        "Cargo: " + result.getString("cargo") + "\n" +
                        "Titulo de eleitor: " +result.getString("titulo_de_eleitor")+ "\n" +
                        "Certificado de reservista: " + result.getString("certificado_de_reservista") +
                        "\n\n";
            }
            if (txt.equals("")){
                txt = "Nenhum funcionario com esse cargo foi encontrado!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return txt;
    }

    public static String relatorioPorCargoRoot(String cargo){
        String txt = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_funcionarios WHERE cargo LIKE '%"+ cargo +"%';";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                txt += "\nNome: " + result.getString("nome")+ "\n"+
                        "CPF: " + result.getString("cpf")+ "\n"+
                        "Sexo: " + MudaValores.sexoCompleto(result.getString("sexo")) +"\n"+
                        "Email: " + result.getString("email") + "\n"+
                        "Nascimento: " + MudaValores.localDateToString(MudaValores.dateToLocalDate(result.getDate("nascimento"))) + "\n" +
                        "Telefone: " + result.getString("tel") + "\n" +
                        "Cargo: " + result.getString("cargo") + "\n" +
                        "Titulo de eleitor: " +result.getString("titulo_de_eleitor")+ "\n" +
                        "Certificado de reservista: " + result.getString("certificado_de_reservista") +
                        "Ativo: " + result.getBoolean("ativo") + "\n"+
                        "\n\n";
            }
            if (txt.equals("")){
                txt = "Nenhum funcionario com esse cargo foi encontrado!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return txt;
    }

    public static String achaNomePorId(int id){
        String nome = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_funcionarios WHERE id = "+id+";";
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


}
