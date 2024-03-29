package br.com.digitalhouse.desafioandroid.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Restaurante implements Parcelable {

    //Atributos
    private String nomeRestaurante;
    private Endereco endereco;
    private String horarioAbertura;
    private String horarioFechamento;
    private int fotoRestaurante;
    private List<Prato> listaPratosPrincipais = new ArrayList<Prato>();

    //Construtor
    public Restaurante() {
    }

    public Restaurante(String nomeRestaurante, Endereco endereco, String horarioAbertura, String horarioFechamento, int fotoRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
        this.endereco = endereco;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
        this.fotoRestaurante = fotoRestaurante;
    }

    public Restaurante(String nomeRestaurante, Endereco endereco, String horarioAbertura, String horarioFechamento, int fotoRestaurante, List<Prato> listaPratosPrincipais) {
        this.nomeRestaurante = nomeRestaurante;
        this.endereco = endereco;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
        this.fotoRestaurante = fotoRestaurante;
        this.listaPratosPrincipais = listaPratosPrincipais;
    }

    protected Restaurante(Parcel in) {
        nomeRestaurante = in.readString();
        endereco = in.readParcelable(Endereco.class.getClassLoader());
        horarioAbertura = in.readString();
        horarioFechamento = in.readString();
        fotoRestaurante = in.readInt();
        listaPratosPrincipais = in.createTypedArrayList(Prato.CREATOR);
    }

    public static final Creator<Restaurante> CREATOR = new Creator<Restaurante>() {
        @Override
        public Restaurante createFromParcel(Parcel in) {
            return new Restaurante(in);
        }

        @Override
        public Restaurante[] newArray(int size) {
            return new Restaurante[size];
        }
    };

    //Getter and Setter
    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getHorarioAbertura() {
        return horarioAbertura;
    }

    public void setHorarioAbertura(String horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public String getHorarioFechamento() {
        return horarioFechamento;
    }

    public void setHorarioFechamento(String horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }

    public int getFotoRestaurante() {
        return fotoRestaurante;
    }

    public void setFotoRestaurante(int fotoRestaurante) {
        this.fotoRestaurante = fotoRestaurante;
    }

    public List<Prato> getListaPratosPrincipais() {
        return listaPratosPrincipais;
    }

    public void setListaPratosPrincipais(List<Prato> listaPratosPrincipais) {
        this.listaPratosPrincipais = listaPratosPrincipais;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomeRestaurante);
        dest.writeParcelable(endereco, flags);
        dest.writeString(horarioAbertura);
        dest.writeString(horarioFechamento);
        dest.writeInt(fotoRestaurante);
        dest.writeTypedList(listaPratosPrincipais);
    }
}


