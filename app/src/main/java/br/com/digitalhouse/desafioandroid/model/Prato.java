package br.com.digitalhouse.desafioandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Prato implements Parcelable {

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

    protected Prato(Parcel in) {
        nome = in.readString();
        descricao = in.readString();
        fotoPrato = in.readInt();
    }

    public static final Creator<Prato> CREATOR = new Creator<Prato>() {
        @Override
        public Prato createFromParcel(Parcel in) {
            return new Prato(in);
        }

        @Override
        public Prato[] newArray(int size) {
            return new Prato[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(descricao);
        dest.writeInt(fotoPrato);
    }
}
