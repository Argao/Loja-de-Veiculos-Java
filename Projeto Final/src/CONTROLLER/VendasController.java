package CONTROLLER;

import CONECTADB.ConnMySQL;
import MODEL.*;
import SERVICES.Conexao;
import SERVICES.MudaValores;
import SERVICES.Service;
import VIEW.CadastroClientes;
import VIEW.CadastroVendas;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class VendasController {



    public static void cadastra(CadastroVendas tela, Vendas venda){
        Connection conexao = ConnMySQL.conectar();

        if (conexao != null){
            LocalDate data = LocalDate.now();
            String sql = "INSERT INTO tab_ven" +
                    "das (idCliente,idFuncionario,idVeiculo,preco," +
                    "dataCompra,filial,observacoes,pagamento,tipo_de_veiculo)"+
                    " VALUES (?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement statement = conexao.prepareStatement(sql);
                statement.setInt(1,venda.getIdCliente());
                statement.setInt(2,venda.getIdFuncionario());
                statement.setInt(3,venda.getIdVeiculo());
                statement.setDouble(4,venda.getPreco());
                statement.setDate(5,MudaValores.localDateToDate(venda.getData()));
                statement.setString(6,venda.getFilial());
                statement.setString(7,venda.getObservacoes());
                statement.setString(8,venda.getPagamento());
                statement.setString(9,venda.getTipoVeiculo());



                int rows = statement.executeUpdate();
                if(rows>0){
                    desativaVeiculo(venda.getTipoVeiculo(),venda.getIdVeiculo());
                    tela.limpaOsCampos();
                    tela.sucessoTxt1.setText("Cadastro realizado com sucesso!");
                }else{

                }
            }catch (SQLException throwables) {
                throwables.printStackTrace();

            }
        }else {

        }

        Conexao.encerraConexao(conexao);

    }


    public static ArrayList<Vendas> getAll(){
        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_vendas ;";
        ArrayList<Vendas> listaVenda = new ArrayList<>();
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                Vendas c = new Vendas();
                c.setId(result.getInt("id"));
                c.setIdFuncionario(result.getInt("idFuncionario"));
                c.setIdVeiculo(result.getInt("idVeiculo"));
                c.setPreco(result.getDouble("preco"));
                c.setData(MudaValores.dateToLocalDate(result.getDate("dataCompra")));
                c.setFilial(result.getString("filial"));
                c.setIdCliente(result.getInt("idCliente"));
                c.setPagamento(result.getString("pagamento"));
                c.setObservacoes(result.getString("observacoes"));
                c.setTipoVeiculo(result.getString("tipo_de_veiculo"));
                listaVenda.add(c);
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaVenda;
    }

    public static String relatorioGeral(){

        ArrayList<Vendas> lista = getAll();
        String txt = "";

        for (Vendas c : lista){
            txt += "\nCliente: " + ClienteController.achaNomePorId(c.getIdCliente())+ "\n"+
                    "Funcionario: " + FuncionarioController.achaNomePorId(c.getIdFuncionario())+ "\n"+
                    "Veiculo: " + Service.descobreVeiculo(c.getTipoVeiculo(),c.getIdVeiculo()) +"\n"+
                    "Data: " + MudaValores.localDateToString(c.getData()) + "\n"+
                    "Preço: " + c.getPreco() + "\n" +
                    "Pagamento: " +c.getPagamento()+ "\n" +
                    "Filial: " + c.getFilial() + "\n" +
                    "Observações: " +c.getObservacoes() +
                    "\n\n";
        }
        return txt;

    }



    public static String relatorioPorFilial(String filial){
        String txt = "";

        Connection conexao = ConnMySQL.conectar();

        String sql = "SELECT * FROM tab_vendas WHERE filial LIKE '%"+filial+"%';";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                txt += "\nCliente: " + ClienteController.achaNomePorId(result.getInt("idCliente"))+ "\n"+
                        "Funcionario: " + FuncionarioController.achaNomePorId(result.getInt("idFuncionario"))+ "\n"+
                        "Veiculo: " + Service.descobreVeiculo(result.getString("tipo_de_veiculo"),result.getInt("idVeiculo")) +"\n"+
                        "Data: " + MudaValores.localDateToString(MudaValores.dateToLocalDate(result.getDate("dataCompra"))) + "\n"+
                        "Preço: " + result.getDouble("preco") + "\n" +
                        "Pagamento: " +result.getString("pagamento")+ "\n" +
                        "Filial: " + result.getString("filial") + "\n" +
                        "Observações: " +result.getString("observacoes") +
                        "\n\n";
            }
            if (txt.equals("")){
                txt = "Nenhuma venda com essa filial foi encontrada!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return txt;
    }

    public static String relatorioPorData(String data){
        String txt = "";

        Date dat = MudaValores.localDateToDate(MudaValores.stringToLocalDate(data));

        Connection conexao = ConnMySQL.conectar();
        System.out.println(dat);

        String sql = "SELECT * FROM tab_vendas WHERE dataCompra ='"+dat+"';";
        try{
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                txt += "\nCliente: " + ClienteController.achaNomePorId(result.getInt("idCliente"))+ "\n"+
                        "Funcionario: " + FuncionarioController.achaNomePorId(result.getInt("idFuncionario"))+ "\n"+
                        "Veiculo: " + Service.descobreVeiculo(result.getString("tipo_de_veiculo"),result.getInt("idVeiculo")) +"\n"+
                        "Data: " + MudaValores.localDateToString(MudaValores.dateToLocalDate(result.getDate("dataCompra"))) + "\n"+
                        "Preço: " + result.getDouble("preco") + "\n" +
                        "Pagamento: " +result.getString("pagamento")+ "\n" +
                        "Filial: " + result.getString("filial") + "\n" +
                        "Observações: " +result.getString("observacoes") +
                        "\n\n";
            }
            if (txt.equals("")){
                txt = "Nenhuma venda nessa data foi encontrada!";
            }
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return txt;
    }



    private static void desativaVeiculo(String tipo,int id){

        switch (tipo){
            case "Carro":
                CarroController.desativa(id);
                break;
            case  "Moto":
                MotoController.desativa(id);
                break;
            case "Caminhão":
                CaminhaoController.desativa(id);
                break;
        }
    }



}
