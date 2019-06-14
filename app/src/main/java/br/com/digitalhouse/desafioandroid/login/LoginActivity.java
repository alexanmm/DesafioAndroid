package br.com.digitalhouse.desafioandroid.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.gson.Gson;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.cadastro.CadastroActivity;
import br.com.digitalhouse.desafioandroid.model.Usuario;
import br.com.digitalhouse.desafioandroid.restaurante.RestauranteActivity;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textInputLoginEmail;
    private TextInputLayout textInputLoginPassword;
    private CheckBox checkBoxLoginRememberMe;
    private Button buttonLoginLogin;
    private Button buttonLoginFacebook;
    private Button buttonLoginRegister;

    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Inicialização das Views
        inicializaViews();

        //Atualiza o último login efetuado na tela
        getUltimoLoginEfetuado();

        //Botão Login
        buttonLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Validação do preenchimento dos dados de login
                if (efetuaLoginUsuario() == true) {

                    //Armazena o último acesso com o email
                    setUltimoLoginEfetuado(textInputLoginEmail.getEditText().getText().toString());

                    //Chama o Tela com a lista de Restaurantes
                    Intent intent = new Intent(
                            LoginActivity.this,
                            RestauranteActivity.class);

                    //Envia o e-mail do usuário logado para a proxima tela
                    if (usuario != null) {
                        intent.putExtra("EMAIL", usuario.getEmail());
                    }

                    startActivity(intent);
                }

            }
        });

        //Botão Register
        buttonLoginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Chama o Tela para Cadastro do usuário
                Intent intent = new Intent(
                        LoginActivity.this,
                        CadastroActivity.class);

                startActivity(intent);
            }
        });
    }

    public void inicializaViews() {

        //Inicialização das Views
        textInputLoginEmail = findViewById(R.id.textInputLoginEmail);
        textInputLoginPassword = findViewById(R.id.textInputLoginPassword);
        checkBoxLoginRememberMe = findViewById(R.id.checkBoxLoginRememberMe);
        buttonLoginLogin = findViewById(R.id.buttonLoginLogin);
        buttonLoginFacebook = findViewById(R.id.buttonLoginFacebook);
        buttonLoginRegister = findViewById(R.id.buttonLoginRegister);

    }

    public boolean validaDadosLogin() {

        String textEmail = textInputLoginEmail.getEditText().getText().toString();
        String textPassword = textInputLoginPassword.getEditText().getText().toString();

        //Validate Email field
        if (textEmail.isEmpty()) {
            textInputLoginEmail.setError("Email is mandatory");
            return false;
        }

        //Validate Password field
        if (textPassword.isEmpty()) {
            textInputLoginPassword.setError("Password is mandatory");
            return false;
        }

        return true;
    }

    public boolean efetuaLoginUsuario() {

        if (validaDadosLogin() == true) {

            String textEmail = textInputLoginEmail.getEditText().getText().toString();
            String textPassword = textInputLoginPassword.getEditText().getText().toString();

            //Recuperar os dados salvos
            usuario = Usuario.getDadosUsuario(getApplicationContext(), textEmail);

            //Ignora se as preferências forem nulas ou vazias
            if (usuario == null || usuario.equals("")) {
                Toast.makeText(
                        getApplicationContext(),
                        "User not registered!",
                        Toast.LENGTH_SHORT
                ).show();

                return false;

            } else {

                //Valida a senha digitada
                if (!textPassword.equals(usuario.getPassword())) {

                    Toast.makeText(
                            getApplicationContext(),
                            "User or password invalid!",
                            Toast.LENGTH_SHORT
                    ).show();

                    return false;
                }
            }

        } else {
            return false;
        }

        return true;

    }

    public void setUltimoLoginEfetuado(String email) {

        SharedPreferences sharedPreferences = getSharedPreferences("APP", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Grava o último login caso a opção Remember-me estiver marcada
        //Se a opção estiver desmarcada, o ultimo acesso do Login será limpo em preferências
        if (checkBoxLoginRememberMe.isChecked()) {
            //Atualiza o último login efetuado
            editor.putString("LASTLOGIN", email);
            editor.commit();
        }

        editor.putBoolean("REMEMBER", checkBoxLoginRememberMe.isChecked());
        editor.commit();
    }

    public void getUltimoLoginEfetuado() {

        SharedPreferences sharedPreferences = getSharedPreferences("APP", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Atualiza a opção na tela: Remember-me
        checkBoxLoginRememberMe.setChecked(sharedPreferences
                .getBoolean("REMEMBER", false));

        if (checkBoxLoginRememberMe.isChecked()) {
            //Atualiza a opção na tela: Remember-me
            textInputLoginEmail.getEditText().setText(sharedPreferences
                    .getString("LASTLOGIN", ""));
        }
    }
}
