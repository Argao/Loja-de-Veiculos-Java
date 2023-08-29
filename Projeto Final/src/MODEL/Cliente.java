package MODEL;

import java.time.LocalDate;
import java.util.Calendar;

public class Cliente extends Pessoa{
    private String cnh,cep;

    public Cliente(String nome, String sexo, String cpf, LocalDate nascimento, String email, String tel, String cnh, String cep) {
        super(nome, sexo, cpf, nascimento, email, tel);
        this.cnh = cnh;
        this.cep = cep;
    }

    public Cliente() {

    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
