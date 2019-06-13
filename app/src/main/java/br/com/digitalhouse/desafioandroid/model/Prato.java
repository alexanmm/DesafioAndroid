package br.com.digitalhouse.desafioandroid.model;

public class Prato{

    //Atributos
    private String nome;
    private String descricao;
    private int fotoPrato;

    //Construtor
    public Prato() {
    }

    public Prato(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Prato(String nome, String descricao, int fotoPrato) {
        this.nome = nome;
        this.descricao = descricao;
        this.fotoPrato = fotoPrato;
    }

    //Getter and Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getFotoPrato() {
        return fotoPrato;
    }

    public void setFotoPrato(int fotoPrato) {
        this.fotoPrato = fotoPrato;
    }
}
