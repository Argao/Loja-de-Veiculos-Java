package MODEL;

public class Carro extends Veiculo {

    private String tracao,cambio;
    private int hp;


    public Carro(String modelo, String marca, String placa, String renavam, String chassi, int ano, double preco, String tracao, String cambio, int hp) {
        super(modelo, marca, placa, renavam, chassi, ano, preco);
        this.tracao = tracao;
        this.cambio = cambio;
        this.hp = hp;
    }

    public Carro() {
    }

    public String getTracao() {
        return tracao;
    }

    public void setTracao(String tracao) {
        this.tracao = tracao;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


}
