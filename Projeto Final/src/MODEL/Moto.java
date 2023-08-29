package MODEL;

public class Moto extends Veiculo {

    private int cilindrada;

    public Moto(String modelo, String marca, String placa, String renavam, String chassi, int ano, double preco, int cilindrada) {
        super(modelo, marca, placa, renavam, chassi, ano, preco);
        this.cilindrada = cilindrada;
    }

    public Moto() {

    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}


