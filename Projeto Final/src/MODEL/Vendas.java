package MODEL;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vendas {
    private int id, idCliente,idFuncionario,idVeiculo;
    private double preco;
    private LocalDate data;
    private String filial, observacoes,pagamento,tipoVeiculo;


    public Vendas( int idCliente, int idFuncionario, int idVeiculo, double preco, String filial, String observacoes, String pagamento,String tipoVeiculo) {
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.idVeiculo = idVeiculo;
        this.preco = preco;
        this.data = LocalDate.now();
        this.filial = filial;
        this.observacoes = observacoes;
        this.pagamento = pagamento;
        this.tipoVeiculo = tipoVeiculo;
    }

    public Vendas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
}
