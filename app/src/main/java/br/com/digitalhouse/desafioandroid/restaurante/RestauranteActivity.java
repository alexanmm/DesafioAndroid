package br.com.digitalhouse.desafioandroid.restaurante;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.adapter.RecyclerViewRestauranteAdapter;
import br.com.digitalhouse.desafioandroid.interfaces.RecyclerViewRestauranteClickListener;
import br.com.digitalhouse.desafioandroid.model.Endereco;
import br.com.digitalhouse.desafioandroid.model.Prato;
import br.com.digitalhouse.desafioandroid.model.Restaurante;
import br.com.digitalhouse.desafioandroid.model.Usuario;
import br.com.digitalhouse.desafioandroid.profile.ProfileActivity;

public class RestauranteActivity extends AppCompatActivity implements RecyclerViewRestauranteClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewRestauranteAdapter adapter;

    private String textChaveEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);

        //Inicialização das views
        recyclerView = findViewById(R.id.recyclerViewRestaurante);

        //Valida se há conteudo da tela anterior
        if (getIntent() != null && getIntent().getExtras() != null) {
            textChaveEmail = getIntent().getStringExtra("EMAIL");
        }

        //Adiciona o layout manager ao recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Adiciona o adapter ao recyclerview
        adapter = new RecyclerViewRestauranteAdapter(getRestaurantes(), this);

        if (adapter != null) {
            recyclerView.setAdapter(adapter);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menuProfile) {

            Intent intent = new Intent(RestauranteActivity.this,
                    ProfileActivity.class);

            //Envia dados do usuário para a próxima tela
            if (textChaveEmail != null) {
                intent.putExtra("EMAIL", textChaveEmail);
            }

            startActivity(intent);
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = new MenuInflater(getApplicationContext());
        inflater.inflate(R.menu.toolbar_menu, menu);

        return true;
    }

    // Retorna lista de restaurantes para recyclerview
    private List<Restaurante> getRestaurantes() {

        List<Restaurante> restaurantes = new ArrayList<>();

        //Restaurante 1
        List<Prato> pratosRestaurante1 = new ArrayList<>();
        pratosRestaurante1.add(new Prato("NACHOS", "Tortilla chips da casa, coberta com frijoles refritos, queijos mistos gratinados e recheio à sua esolha. Acompanha guacamole, pico de gallo e sour cream.", converteImagem("id_restaurante_001_prato_001")));
        pratosRestaurante1.add(new Prato("TACOS", "Tortilla de milho crocante ou macia, recheada com alface em tiras, pico de gallo, queijos mistos e sabor a sua escolha. Acompanha guacamole, pico de gallo e sour cream.", converteImagem("id_restaurante_001_prato_002")));
        pratosRestaurante1.add(new Prato("FLAUTAS", "Tortilla de trigo crocantes em forma de canudo, recheadas com queijos mistos e sabor à sua escolha. Acompanha guacamole, pico de gallo e sour cream.", converteImagem("id_restaurante_001_prato_003")));
        pratosRestaurante1.add(new Prato("QUESADILLAS", "Duas tortillas de trigo tostadas na chapa, recheadas com queijos mistos e sabor à sua escolha. Acompanha guacamole, pico de gallo e sour cream.", converteImagem("id_restaurante_001_prato_004")));
        pratosRestaurante1.add(new Prato("COMBO GUACAMOLE", "Uma combinação perfeita para provar os pratos favoritos do México. NACHO DE CHILLI, 2 TACOS AL PASTOR, 1 BURRITO DE MIGNON e 1 MINI QUESADILLA DE FRANGO.", converteImagem("id_restaurante_001_prato_005")));
        pratosRestaurante1.add(new Prato("CHILAQUILLES", "Tiras de tortillas de trigo crocantes, misturadas com creme picante e recheio à sua escolha.", converteImagem("id_restaurante_001_prato_006")));
        pratosRestaurante1.add(new Prato("BURRITOS", "Queijos mistos, frijoles, alface em tiras e recheio à sua escolha, embrulhados em uma tortilla de trigo e assado. Acompanha guacamole, pico de gallo, sour cream e arroz mexicano. *Caso prefira o arroz dentro da tortilha, peça ao atendente.", converteImagem("id_restaurante_001_prato_007")));
        pratosRestaurante1.add(new Prato("ALAMBRES", "Pimentão verde, cebola roxa, queijos mistos e recheio à sua escolha misturados na chapa. Acompanha Tortillas de Milho Branco, guacamole, pico de gallo, sour cream.", converteImagem("id_restaurante_001_prato_008")));
        pratosRestaurante1.add(new Prato("FAJITAS", "Mix de pimentões, cebolas e sabor à sua escolha servidos no rechaud. Acompanha cesta de tortillas de trigo, arroz mexicano, frijoles refritos, guacamole, pico de gallo e sour cream. Individual ou para 2 pessoas.", converteImagem("id_restaurante_001_prato_009")));
        pratosRestaurante1.add(new Prato("ENCHILADAS", "Duas tortillas de trigo macias recheadas com queijos mistos e sabor à sua escolha, cobertas com salsa picante e queijo gratinado. Acompanha arroz mexicano, frijoles refritos, pico de gallo, guacamole e sour cream.", converteImagem("id_restaurante_001_prato_010")));
        pratosRestaurante1.add(new Prato("Churros del Chavo", "CHURROS MEXICANOS RECHEADOS COM DOCE DE LEITE E SORVETE DE CREME COM CALDA DE CHOCOLATE.", converteImagem("id_restaurante_001_prato_011")));

        restaurantes.add(new Restaurante("Guacamole Cocina Mexicana", new Endereco("R. Girassol", 354, "", "Vila Madalena", "São Paulo", "SP"), "11:00", "23:30", converteImagem("id_restaurante_001"), pratosRestaurante1));

        //Restaurante 2
        List<Prato> pratosRestaurante2 = new ArrayList<>();
        pratosRestaurante2.add(new Prato("CARBONARA - Pancetta temperada e preparada no vinho branco", "Prato simples e popular típico dos trabalhadores nas minas de carvão, tonou-se famoso em todo o mundo. Individual e bem servido, este é um dos pratos mais elogiados da Trattoria. Hamonização com vinho branco a qualquer hora é sempre solicitado.", converteImagem("id_restaurante_002_prato_001")));
        pratosRestaurante2.add(new Prato("BRUSCHETTA CAPRESE", "Queijo mozzarella fresco, molho pesto caseiro, tomate com toque de azeite extravirgem, servidos com ciabattas crocantes ao forno.", converteImagem("id_restaurante_002_prato_002")));
        pratosRestaurante2.add(new Prato("INSALATA TOSCANA", "Frango grelhado (ou camarões) servido sobre folhas verdes, morangos frescos, cebola roxa, nozes, tomate e um toque de queijo gorgonzola. Servido com exclusivo vinagrete de morangos.", converteImagem("id_restaurante_002_prato_003")));
        pratosRestaurante2.add(new Prato("LASAGNA BIANCA", "Lasagna recheada com creme de espinafre, brócolis e delicioso mix de queijos especiais: fontina, grana padano, ricota cremosa e mozzarella.", converteImagem("id_restaurante_002_prato_004")));
        pratosRestaurante2.add(new Prato("PAPPARDELLE AL RAGÙ DI OSSOBUCO", "Pappardelle envolto em Molho Alfredo e finalizado com Ragu de Ossobuco braseado em ervas e vegetais.", converteImagem("id_restaurante_002_prato_005")));
        pratosRestaurante2.add(new Prato("FETTUCCINE ABBRACCIO", "Fettuccine ao molho Alfredo com tiras de frango grelhado ou camarões salteados, cogumelos, ervilhas e parmesão.", converteImagem("id_restaurante_002_prato_006")));
        pratosRestaurante2.add(new Prato("CARBONARA DI ROMA", "Spaghetti ao molho cremoso de parmesão e pancetta (disponível também na versão com ovos).", converteImagem("id_restaurante_002_prato_007")));
        pratosRestaurante2.add(new Prato("GNOCCHI AL RAGÚ DI MAIALE", "Nhoque com paleta suína preparada lentamente ao forno, servido no molho do próprio cozimento, coberto com queijo parmesão e salsa.", converteImagem("id_restaurante_002_prato_008")));
        pratosRestaurante2.add(new Prato("POLLO BRIANNI", "Tenro peito de frango grelhado, coberto com queijo de cabra e tomates secos e nosso molho Specialitá 'Burro al Limone' com manjericão.", converteImagem("id_restaurante_002_prato_009")));
        pratosRestaurante2.add(new Prato("FILETTO MARSALA", "Filé-mignon grelhado com prosciutto e cogumelos, ao nosso molho à base de vinho Marsala.", converteImagem("id_restaurante_002_prato_010")));

        restaurantes.add(new Restaurante("Casa da Guimirella", new Endereco("Av. Sapopemba", 933, "", "Água Rasa", "São Paulo", "SP"), "10:00", "22:00", converteImagem("id_restaurante_002"), pratosRestaurante2));

        //Restaurante 3
        List<Prato> pratosRestaurante3 = new ArrayList<>();

        pratosRestaurante3.add(new Prato("Office de Frango Xadrez", "Serve uma pessoa", converteImagem("id_restaurante_003_prato_001")));
        pratosRestaurante3.add(new Prato("Office Frango com Legumes", "Frango, brócolis, couve-flor e cenoura.", converteImagem("id_restaurante_003_prato_002")));
        pratosRestaurante3.add(new Prato("Yakissoba Tradicional", "Carne, frango, macarrão, legumes e champignon.", converteImagem("id_restaurante_003_prato_003")));
        pratosRestaurante3.add(new Prato("Office Filé da China", "1 Porção office de filé da china. Serve 1 Pessoa.", converteImagem("id_restaurante_003_prato_004")));
        pratosRestaurante3.add(new Prato("Office Filé com Legumes", "1 Porção office filé com legumes. Serve 1 Pessoa.", converteImagem("id_restaurante_003_prato_005")));
        pratosRestaurante3.add(new Prato("Rolinho Romeu e Julieta", "Massa crocante, goiabada e muzzarella.", converteImagem("id_restaurante_003_prato_006")));
        pratosRestaurante3.add(new Prato("Yakissoba só de Camarão", "Camarões fresquinhos, macarrão, legumes do yakissoba tradicional.", converteImagem("id_restaurante_003_prato_007")));
        pratosRestaurante3.add(new Prato("Yakissoba de Legumes", "Macarrão, champignon, brócolis, acelga, couve-flor e cenoura.", converteImagem("id_restaurante_003_prato_008")));
        pratosRestaurante3.add(new Prato("Peixe Empanado", "Filé de peixe, envolto em massa leve, acompanha molho agridoce.", converteImagem("id_restaurante_003_prato_009")));
        pratosRestaurante3.add(new Prato("Arroz ao Shoyu com Carne e Frango", "Frango, carne, arroz, cenoura, cebolinha e ovo temperados com molho shoyu.", converteImagem("id_restaurante_003_prato_010")));

        restaurantes.add(new Restaurante("Yakissoba Mundial", new Endereco("R. Mituto Mizumoto", 313, "", "Liberdade", "São Paulo", "SP"), "11:50", "21:00", converteImagem("id_restaurante_003"), pratosRestaurante3));

        //Restaurante 4
        List<Prato> pratosRestaurante4 = new ArrayList<>();

        pratosRestaurante4.add(new Prato("Lasanha à bolonhesa e aos 4 queijos", "Experimente esta receita divina de Lasanha à bolonhesa e aos 4 queijos, feita com mussarela, provolone, Catupiry® e parmesão! Só de olhar já dá água na boca, e o sabor não deve em nada à apresentação!", converteImagem("id_restaurante_004_prato_001")));
        pratosRestaurante4.add(new Prato("Calzone recheado de presunto e queijo", "A comida italiana não deixa a desejar! Um dos pratos mais pedidos é o Calzone recheado de presunto e queijo! Fácil e rápido, essa receita vai te dar água na boca. ", converteImagem("id_restaurante_004_prato_002")));
        pratosRestaurante4.add(new Prato("Risoto de camarão com salmão", "Que tal fazer uma refeição especial em casa? Para te ajudar nesta tarefa, temos um risoto de camarão com salmão, uma receita muito especial que vai deixar todo mundo babando!", converteImagem("id_restaurante_004_prato_003")));
        pratosRestaurante4.add(new Prato("Al Mare", "Insalata di gamberoni con spaghetti di pupunha e pesto al basilico Salada de camarão com espaguete de pupunha ao pesto de manjericão", converteImagem("id_restaurante_004_prato_004")));
        pratosRestaurante4.add(new Prato("Ravioli di mozzarella al pomodoro", "Massa fresca com mussarela de búfala ao molho de tomate e manjericão", converteImagem("id_restaurante_004_prato_005")));
        pratosRestaurante4.add(new Prato("Penne rigate (senza glutine) al pomodoro e basilico", "Massa seca Italiana sem glúten ao molho de tomate e manjericão", converteImagem("id_restaurante_004_prato_006")));
        pratosRestaurante4.add(new Prato("Ravioli ripieni di taleggio in salsa di tartufo", "Massa fresca recheada com queijo taleggio e manteiga de trufas", converteImagem("id_restaurante_004_prato_007")));
        pratosRestaurante4.add(new Prato("Gnocchi di 'mandioquinha' con gamberi e asparagi", "Massa fresca de mandioquinha com camarão e aspargos", converteImagem("id_restaurante_004_prato_008")));
        pratosRestaurante4.add(new Prato("Linguine in salsa di limone siciliano e gamberi", "Massa seca com molho de limão siciliano e camarão", converteImagem("id_restaurante_004_prato_009")));
        pratosRestaurante4.add(new Prato("Spaghetti ai frutti di mare", "Massa seca com frutos do mar", converteImagem("id_restaurante_004_prato_010")));

        restaurantes.add(new Restaurante("Trattoria Macarrao da Mama", new Endereco("R. Pascoal Vita", 413, "", "Vila Madalena", "São Paulo", "SP"), "11:00", "02:00", converteImagem("id_restaurante_004"), pratosRestaurante4));

        //Restaurante 5
        List<Prato> pratosRestaurante5 = new ArrayList<>();

        pratosRestaurante5.add(new Prato("Tutu à Mineira com Costelinha", "Tutu de Feijão acompanhado de Costelinha, Arroz, Couve Refogada ao Alho, Banana Empanada e Torresmo.", converteImagem("id_restaurante_005_prato_001")));
        pratosRestaurante5.add(new Prato("Feijão Tropeiro com Costelinha", "Feijão inteiro cozido com Lingüiça Calabresa picada, Bacon, Farinha de Mandioca, acompanhado de Costelinha, Arroz, Couve Refogada ao Alho, Banana Empanada e Torresmo.", converteImagem("id_restaurante_005_prato_002")));
        pratosRestaurante5.add(new Prato("Mexido ( 1 porção ) grátis 1/2 porção de mandioca", "Carne de sol desfiada, arroz,ovo,couve,feijão, Torresmo, banana à milanesa e tutu", converteImagem("id_restaurante_005_prato_003")));
        pratosRestaurante5.add(new Prato("Espetinho", "Arroz, tutu, salada e polenta.", converteImagem("id_restaurante_005_prato_004")));
        pratosRestaurante5.add(new Prato("Escondidinho de frango", "Frango desfiado, Catupiry, purê de batata, parmesão gratinado, arroz e feijão.", converteImagem("id_restaurante_005_prato_005")));
        pratosRestaurante5.add(new Prato("Feijoada (normal e light)", "Feijoada, couve, banana, farofa, torresmo, arroz e molho apimentado.", converteImagem("id_restaurante_005_prato_006")));
        pratosRestaurante5.add(new Prato("Carne sol desfiada", "Arroz, tutu, couve e farofa.", converteImagem("id_restaurante_005_prato_007")));
        pratosRestaurante5.add(new Prato("Escondidinho de carne sol", "Carne de sol com catupiry, purê de batata, parmesão gratinado, arroz, tutu.", converteImagem("id_restaurante_005_prato_008")));
        pratosRestaurante5.add(new Prato("Lombo de porco assado", "Arroz, feijão tropeiro, salada e mandioca.", converteImagem("id_restaurante_005_prato_009")));
        pratosRestaurante5.add(new Prato("Bolinho de carne de sol", "Experimento nosso aperitivo.", converteImagem("id_restaurante_005_prato_010")));

        restaurantes.add(new Restaurante("Restaurante Segredos de Minas", new Endereco("Rua Haddock Lobo", 187, "", "Cerqueira César", "São Paulo", "SP"), "12:00", "23:00", converteImagem("id_restaurante_005"), pratosRestaurante5));

        return restaurantes;
    }


    @Override
    public void onClick(Restaurante restaurante) {

        try {

            //Chama a tela de Pratos Principais
            Intent intent = new Intent(this, RestauranteDetalheActivity.class);
            intent.putExtra("RESTAURANTE", restaurante);
            startActivity(intent);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int converteImagem(String nomeImagem) {

        return getResources().getIdentifier(
                getPackageName() + ":drawable/" + nomeImagem, null, null);

    }

}
