package br.com.digitalhouse.desafioandroid.restaurante;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.adapter.RecyclerViewRestauranteAdapter;
import br.com.digitalhouse.desafioandroid.interfaces.RecyclerViewRestauranteClickListener;
import br.com.digitalhouse.desafioandroid.model.Endereco;
import br.com.digitalhouse.desafioandroid.model.Prato;
import br.com.digitalhouse.desafioandroid.model.Restaurante;

public class RestauranteActivity extends AppCompatActivity implements RecyclerViewRestauranteClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewRestauranteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);

        //Toolbar toolbar = findViewById(R.layout.toolbar);
        //setSupportActionBar(toolbar);

        //Inicialização das views
        recyclerView = findViewById(R.id.recyclerViewRestaurante);

        //Adiciona o layout manager ao recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Adiciona o adapter ao recyclerview
        adapter = new RecyclerViewRestauranteAdapter(getRestaurantes(), this);

        if (adapter != null){
            recyclerView.setAdapter(adapter);
        }

    }

    // Retorna lista de restaurantes para recyclerview
    private List<Restaurante> getRestaurantes() {

        Time horarioAbertura = new Time(1);
        Time horarioFechamento = new Time(1);

        List<Restaurante> restaurantes = new ArrayList<>();

        restaurantes.add(new Restaurante("Guacamole Cocina Mexicana",
                new Endereco("R. Girassol", 354, "",
                        "Vila Madalena", "São Paulo", "SP"),
                horarioAbertura, horarioFechamento,
                getResources().getIdentifier(getPackageName() + ":drawable/id_restaurante_001", null, null)));

        //Restaurante 1
        //***
        List<Prato> pratosRestaurante1 = new ArrayList<>();
        pratosRestaurante1.add(new Prato("NACHOS", "Tortilla chips da casa, coberta com frijoles refritos, queijos mistos gratinados e recheio à sua esolha. Acompanha guacamole, pico de gallo e sour cream.", getResources().getIdentifier(getPackageName() + ":drawable/id_restaurante_001_prato_001", null, null)));
        pratosRestaurante1.add(new Prato("TACOS", "Tortilla de milho crocante ou macia, recheada com alface em tiras, pico de gallo, queijos mistos e sabor a sua escolha. Acompanha guacamole, pico de gallo e sour cream.", getResources().getIdentifier(getPackageName() + ":drawable/id_restaurante_001_prato_002", null, null)));
        pratosRestaurante1.add(new Prato("FLAUTAS", "Tortilla de trigo crocantes em forma de canudo, recheadas com queijos mistos e sabor à sua escolha. Acompanha guacamole, pico de gallo e sour cream.", getResources().getIdentifier(getPackageName() + ":drawable/id_restaurante_001_prato_003", null, null)));
        pratosRestaurante1.add(new Prato("QUESADILLAS", "Duas tortillas de trigo tostadas na chapa, recheadas com queijos mistos e sabor à sua escolha. Acompanha guacamole, pico de gallo e sour cream.", getResources().getIdentifier(getPackageName() + ":drawable/id_restaurante_001_prato_004", null, null)));
        pratosRestaurante1.add(new Prato("COMBO GUACAMOLE", "Uma combinação perfeita para provar os pratos favoritos do México. NACHO DE CHILLI, 2 TACOS AL PASTOR, 1 BURRITO DE MIGNON e 1 MINI QUESADILLA DE FRANGO.", getResources().getIdentifier(getPackageName() + ":drawable/id_restaurante_001_prato_005", null, null)));
        pratosRestaurante1.add(new Prato("CHILAQUILLES", "Tiras de tortillas de trigo crocantes, misturadas com creme picante e recheio à sua escolha.", getResources().getIdentifier(getPackageName() + ":drawable/id_restaurante_001_prato_006", null, null)));
        pratosRestaurante1.add(new Prato("BURRITOS", "Queijos mistos, frijoles, alface em tiras e recheio à sua escolha, embrulhados em uma tortilla de trigo e assado. Acompanha guacamole, pico de gallo, sour cream e arroz mexicano. *Caso prefira o arroz dentro da tortilha, peça ao atendente.", getResources().getIdentifier(getPackageName() + ":drawable/id_restaurante_001_prato_007", null, null)));
        pratosRestaurante1.add(new Prato("ALAMBRES", "Pimentão verde, cebola roxa, queijos mistos e recheio à sua escolha misturados na chapa. Acompanha Tortillas de Milho Branco, guacamole, pico de gallo, sour cream.", getResources().getIdentifier(getPackageName() + ":drawable/id_restaurante_001_prato_008", null, null)));
        pratosRestaurante1.add(new Prato("FAJITAS", "Mix de pimentões, cebolas e sabor à sua escolha servidos no rechaud. Acompanha cesta de tortillas de trigo, arroz mexicano, frijoles refritos, guacamole, pico de gallo e sour cream. Individual ou para 2 pessoas.", getResources().getIdentifier(getPackageName() + ":drawable/id_restaurante_001_prato_009", null, null)));
        pratosRestaurante1.add(new Prato("ENCHILADAS", "Duas tortillas de trigo macias recheadas com queijos mistos e sabor à sua escolha, cobertas com salsa picante e queijo gratinado. Acompanha arroz mexicano, frijoles refritos, pico de gallo, guacamole e sour cream.", getResources().getIdentifier(getPackageName() + ":drawable/id_restaurante_001_prato_010", null, null)));
        pratosRestaurante1.add(new Prato("Churros del Chavo", "CHURROS MEXICANOS RECHEADOS COM DOCE DE LEITE E SORVETE DE CREME COM CALDA DE CHOCOLATE.", getResources().getIdentifier(getPackageName() + ":drawable/id_restaurante_001_prato_011", null, null)));

        restaurantes.add(new Restaurante("Casa da Guimirella",new Endereco("Av. Sapopemba", 933, "","Água Rasa", "São Paulo", "SP"),horarioAbertura, horarioFechamento, getResources().getIdentifier(getPackageName() + ":drawable/id_restaurante_002", null, null), pratosRestaurante1));

        restaurantes.add(new Restaurante("Yakissoba Mundial",
                new Endereco("R. Mituto Mizumoto", 313, "",
                        "Liberdade", "São Paulo", "SP"),
                horarioAbertura, horarioFechamento,
                getResources().getIdentifier(getPackageName() + ":drawable/id_restaurante_003", null, null)));

        restaurantes.add(new Restaurante("Trattoria Macarrao da Mama",
                new Endereco("R. Pascoal Vita", 413, "",
                        "Vila Madalena", "São Paulo", "SP"),
                horarioAbertura, horarioFechamento,
                getResources().getIdentifier(getPackageName() + ":drawable/id_restaurante_004", null, null)));

        restaurantes.add(new Restaurante("Restaurante Segredos de Minas",
                new Endereco("Rua Haddock Lobo", 187, "",
                        "Cerqueira César", "São Paulo", "SP"),
                horarioAbertura, horarioFechamento,
                getResources().getIdentifier(getPackageName() + ":drawable/id_restaurante_005", null, null)));

        return restaurantes;
    }


    @Override
    public void onClick(Restaurante restaurante) {

        try{

            //Chama a tela de Pratos Principais
            Intent intent = new Intent(this, RestauranteDetalheActivity.class);
            intent.putExtra("RESTAURANTE", restaurante);
            startActivity(intent);

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
