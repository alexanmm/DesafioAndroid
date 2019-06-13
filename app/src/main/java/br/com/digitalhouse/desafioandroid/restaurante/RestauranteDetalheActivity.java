package br.com.digitalhouse.desafioandroid.restaurante;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.adapter.RecyclerViewRestauranteDetalheAdapter;
import br.com.digitalhouse.desafioandroid.interfaces.RecyclerViewRestauranteDetalheClickListener;
import br.com.digitalhouse.desafioandroid.model.Prato;
import br.com.digitalhouse.desafioandroid.model.Restaurante;

public class RestauranteDetalheActivity extends AppCompatActivity
        implements RecyclerViewRestauranteDetalheClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewRestauranteDetalheAdapter adapter;

    private Restaurante restaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_detalhe);

        //Inicialização das views
        recyclerView = findViewById(R.id.recyclerViewRestauranteDetalhe);

        //Valida se há conteudo da tela anterior
        if (getIntent() != null && getIntent().getExtras() != null) {
            restaurante = getIntent().getParcelableExtra("RESTAURANTE");

            if (restaurante != null) {
            }
        }

        //Adiciona o layout manager ao recyclerview
        try {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Adiciona o adapter ao recyclerview
        adapter = new RecyclerViewRestauranteDetalheAdapter(getPratos(), this);

        if( adapter != null){
            recyclerView.setAdapter(adapter);
        }
    }

    // Retorna lista dos principais pratos para recyclerview
    private List<Prato> getPratos() {

        List<Prato> pratos = new ArrayList<>();

        for (Prato linhaPrato: restaurante.getListaPratosPrincipais()){
            pratos.add(linhaPrato);
        }

        return pratos;
    }

    @Override
    public void onClick(Prato prato) {

        //Chama a tela de Detalhe do Prato
        Intent intent = new Intent(this, PratoDetalheActivity.class);
        //intent.putExtra("PRATO", prato);
        startActivity(intent);

    }
}
