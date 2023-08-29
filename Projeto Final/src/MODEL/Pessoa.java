package MODEL;

import java.time.LocalDate;

public abstract class Pessoa {
    private String nome,cpf,email,tel,sexo;
    private LocalDate nascimento;
    private boolean ativo;
    private int id;


    public Pessoa(String nome, String sexo, String cpf, LocalDate nascimento, String email, String tel) {
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.ativo = true;
        this.tel = tel;
        this.email = email;
    }

    public Pessoa() {
        this.ativo = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    @Override
    public String toString() {
        return getNome();
    }
}
