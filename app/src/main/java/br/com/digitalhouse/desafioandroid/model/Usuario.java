package br.com.digitalhouse.desafioandroid.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;

import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;

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

    //Retorna os dados do usuário a partir da chave Email
    public static Usuario getDadosUsuario(Context context, String email) {

        Usuario usuario = new Usuario();

        //Recuperar os dados salvos
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                "APP",
                MODE_PRIVATE);

        Gson gson = new Gson();
        String json = sharedPreferences.getString(email, "");

        if (!(json == null) && !(json.isEmpty())) {
            //Transforma na Classe Usuário
            usuario = gson.fromJson(json, Usuario.class);
        }

        return usuario;
    }

    //Gravar dados do usuário
    public static void setDadosUsuario(Context context, Usuario usuario) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(
                "APP",
                MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Prepara dados do usuário
        if (usuario != null) {
            //Armazena os dados do usuario internamente
            Gson gson = new Gson();
            String json = gson.toJson(usuario);
            editor.putString(usuario.getEmail(), json); //Utiliza o Email como chave
            editor.commit();

            //Usuário & gravado com sucesso
            Toast.makeText(
                    context.getApplicationContext(),
                    "Usuário " + usuario.getNome() + " gravado com sucesso!",
                    Toast.LENGTH_SHORT
            ).show();

        }
    }
}
