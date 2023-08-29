package MODEL;

public abstract class Veiculo {
    private String modelo,marca,placa,renavam,chassi;
    private int ano,id;
    private double preco;
    private boolean disponivel;

    public Veiculo(String modelo, String marca, String placa, String renavam, String chassi, int ano, double preco ) {
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.renavam = renavam;
        this.chassi = chassi;
        this.ano = ano;
        this.preco = preco;
        this.disponivel = true;
    }

    public Veiculo() {
        this.disponivel = true;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getModelo();
    }
}
