package br.com.digitalhouse.desafioandroid.cadastro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.login.LoginActivity;
import br.com.digitalhouse.desafioandroid.model.Restaurante;
import br.com.digitalhouse.desafioandroid.model.Usuario;
import br.com.digitalhouse.desafioandroid.restaurante.RestauranteActivity;

public class CadastroActivity extends AppCompatActivity {

    private TextInputLayout textInputCadastroName;
    private TextInputLayout textInputCadastroEmail;
    private TextInputLayout textInputCadastroPassword;
    private TextInputLayout textInputCadastroRepeatPassword;
    private Button buttonCadastroRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Inicialização das Views
        inicializaViews();

        //Botão para efetivar o cadastro do usuário
        buttonCadastroRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validaDadosCadastro() == true) {
                    //Prepara dados do usuario
                    String textName = textInputCadastroName.getEditText().getText().toString();
                    String textEmail = textInputCadastroEmail.getEditText().getText().toString();
                    String textPassword = textInputCadastroPassword.getEditText().getText().toString();

                    Usuario usuario = new Usuario(textEmail, textName, textPassword);

                    //Efetua o cadastro do Usuário
                    Usuario.setDadosUsuario(getApplicationContext(), usuario);

                    //Chama a Tela Home (lista de restaurantes)
                    Intent intent = new Intent(
                            CadastroActivity.this,
                            RestauranteActivity.class);

                    startActivity(intent);

                    finish(); //Encerra a própria tela
                }

            }
        });
    }

    public void inicializaViews() {

        //Inicialização das Views
        textInputCadastroName = findViewById(R.id.textInputCadastroName);
        textInputCadastroEmail = findViewById(R.id.textInputCadastroEmail);
        textInputCadastroPassword = findViewById(R.id.textInputCadastroPassword);
        textInputCadastroRepeatPassword = findViewById(R.id.textInputCadastroRepeatPassword);
        buttonCadastroRegister = findViewById(R.id.buttonCadastroRegister);

    }

    public boolean validaDadosCadastro() {

        String textName = textInputCadastroName.getEditText().getText().toString();
        String textEmail = textInputCadastroEmail.getEditText().getText().toString();
        String textPassword = textInputCadastroPassword.getEditText().getText().toString();
        String textRepeatPassword = textInputCadastroRepeatPassword.getEditText().getText().toString();
        int minimalPassLen = 6;

        //Validate Name field
        if (textName.isEmpty()) {
            textInputCadastroName.setError("Name is mandatory");
            return false;
        }

        //Validate Email field
        if (textEmail.isEmpty()) {
            textInputCadastroEmail.setError("Email is mandatory");
            return false;
        }

        //Validate Password field
        if (textPassword.isEmpty()) {
            textInputCadastroPassword.setError("Password is mandatory");
            return false;
        }

        if (textPassword.length() < minimalPassLen) {
            textInputCadastroPassword.setError("Enter password with 6 or more characters");
            return false;
        }

        //Validate Repeat Email field
        if (textRepeatPassword.isEmpty()) {
            textInputCadastroRepeatPassword.setError("Repeat Password is mandatory");
            return false;
        }

        //Password and Repeat Password fields can not be different
        if (!textPassword.equals(textRepeatPassword)) {
            textInputCadastroRepeatPassword.setError("The Password can not be different");
            return false;
        }

        return true;
    }
}
