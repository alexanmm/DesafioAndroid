package br.com.digitalhouse.desafioandroid.model;

public class Usuario {

    //Atributos
    private String email;
    private String nome;
    private String password;

    //Construtor
    public Usuario() {
    }

    public Usuario(String email, String nome, String password) {
        this.email = email;
        this.nome = nome;
        this.password = password;
    }

    //Getter and Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
