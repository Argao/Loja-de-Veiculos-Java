package MODEL;

import java.time.LocalDate;
import java.util.Calendar;

public class Funcionario extends Pessoa{

    private String cargo,tituloDeEleitor,login,senha,certificadoDeReservista;


    public Funcionario(String nome, String sexo, String cpf, LocalDate nascimento, String email, String tel, String cargo, String tituloDeEleitor, String login, String senha, String certificadoDeReservista) {
        super(nome, sexo, cpf, nascimento, email, tel);
        this.cargo = cargo;
        this.tituloDeEleitor = tituloDeEleitor;
        this.login = login;
        this.senha = senha;
        this.certificadoDeReservista = certificadoDeReservista;
    }

    public Funcionario() {

    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public String getTituloDeEleitor() {
        return tituloDeEleitor;
    }

    public void setTituloDeEleitor(String tituloDeEleitor) {
        this.tituloDeEleitor = tituloDeEleitor;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCertificadoDeReservista() {
        return certificadoDeReservista;
    }

    public void setCertificadoDeReservista(String certificadoDeReservista) {
        this.certificadoDeReservista = certificadoDeReservista;
    }
}
