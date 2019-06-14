package br.com.digitalhouse.desafioandroid.profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.model.Usuario;
import br.com.digitalhouse.desafioandroid.restaurante.RestauranteActivity;

public class ProfileActivity extends AppCompatActivity {

    private Usuario usuario;
    private String textChaveEmail;

    private TextInputLayout textInputProfileName;
    private TextInputLayout textInputProfileEmail;
    private TextInputLayout textInputProfilePassword;
    private TextInputLayout textInputProfileRepeatPassword;
    private Button buttonProfileRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Inicialização das Views
        inicializaViews();

        //Valida se há conteudo da tela anterior
        if (getIntent() != null && getIntent().getExtras() != null) {
            textChaveEmail = getIntent().getStringExtra("EMAIL");

            if (textChaveEmail != null) {
                //Busca os dados atualizados do usuário
                usuario = Usuario.getDadosUsuario(getApplicationContext(), textChaveEmail);

                //Atualiza os dados do usuario na tela
                textInputProfileName.getEditText().setText(usuario.getNome());
                textInputProfileEmail.getEditText().setText(usuario.getEmail());
                textInputProfilePassword.getEditText().setText(usuario.getPassword());
                textInputProfileRepeatPassword.getEditText().setText(usuario.getPassword());
            }
        }

      //Botão para atualizar os dados do usuario
        buttonProfileRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Somente atualiza os dados do usuario se o nome estiver preenchido
                if (validaDadosUsuario() == true){

                    //Atualiza o nome do usuario
                    usuario.setNome(textInputProfileName.getEditText().getText().toString());

                    //Atualiza os dados do usuario
                    Usuario.setDadosUsuario(getApplicationContext(), usuario);

                    finish(); //Encerra a própria tela para retornar a tela anterior
                }

            }
        });

    }

    //Inicialização das Views
    public void inicializaViews() {

        textInputProfileName = findViewById(R.id.textInputProfileName);
        textInputProfileEmail = findViewById(R.id.textInputProfileEmail);
        textInputProfilePassword = findViewById(R.id.textInputProfilePassword);
        textInputProfileRepeatPassword = findViewById(R.id.textInputProfileRepeatPassword);
        buttonProfileRegister = findViewById(R.id.buttonProfileRegister);

    }

    public boolean validaDadosUsuario() {

        String textName = textInputProfileName.getEditText().getText().toString();

        //Validate Name field
        if (textName.isEmpty()) {
            textInputProfileName.setError("Name is mandatory");
            return false;
        }

        return true;
    }
}
