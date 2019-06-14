package br.com.digitalhouse.desafioandroid.restaurante;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.model.Prato;

public class PratoDetalheActivity extends AppCompatActivity {

    private Prato prato;

    private ImageView imageViewPratoDetalhePratoFoto;
    private TextView textViewPratoDetalheNome;
    private TextView textViewPratoDetalheDescricaoPrato;
    private ImageView imageViewPratoDetalheVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prato_detalhe);

        //Inicialização das Views
        inicializaViews();

        //Valida se há conteudo da tela anterior
        if (getIntent() != null && getIntent().getExtras() != null) {
            prato = getIntent().getParcelableExtra("PRATO");

            if (prato != null) {
                //Atualiza a Foto, nome a descrição do Prato na tela
                imageViewPratoDetalhePratoFoto.setImageResource(prato.getFotoPrato());
                textViewPratoDetalheNome.setText(prato.getNome());
                textViewPratoDetalheDescricaoPrato.setText(prato.getDescricao());
            }
        }

        //Ao clicar na seta para voltar
        imageViewPratoDetalheVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Encerra o processamento da tela atual, a tela anterior será exibida novamente
                finish();

            }
        });

    }

    //Inicialização das Views
    public void inicializaViews() {

        imageViewPratoDetalhePratoFoto = findViewById(R.id.imageViewPratoDetalhePratoFoto);
        textViewPratoDetalheNome = findViewById(R.id.textViewPratoDetalheNome);
        textViewPratoDetalheDescricaoPrato = findViewById(R.id.textViewPratoDetalheDescricaoPrato);
        imageViewPratoDetalheVoltar = findViewById(R.id.imageViewPratoDetalheVoltar);

    }

}
