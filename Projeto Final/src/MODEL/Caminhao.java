package MODEL;

public class Caminhao extends Carro {

    private int capacidadeDeCarga;

    public Caminhao(String modelo, String marca, String placa, String renavam, String chassi, int ano, double preco, String tracao, String cambio, int hp, int capacidadeDeCarga) {
        super(modelo, marca, placa, renavam, chassi, ano, preco, tracao, cambio, hp);
        this.capacidadeDeCarga = capacidadeDeCarga;
    }

    public Caminhao() {

    }

    public int getCapacidadeDeCarga() {
        return capacidadeDeCarga;
    }

    public void setCapacidadeDeCarga(int capacidadeDeCarga) {
        this.capacidadeDeCarga = capacidadeDeCarga;
    }
}
