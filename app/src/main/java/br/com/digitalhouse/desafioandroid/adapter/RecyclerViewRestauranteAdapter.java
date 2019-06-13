package br.com.digitalhouse.desafioandroid.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.interfaces.RecyclerViewRestauranteClickListener;
import br.com.digitalhouse.desafioandroid.model.Restaurante;

public class RecyclerViewRestauranteAdapter extends
        RecyclerView.Adapter<RecyclerViewRestauranteAdapter.ViewHolder>{

    //Atributos
    private List<Restaurante> listaRestaurantes = new ArrayList<>();
    private RecyclerViewRestauranteClickListener listener;

    //Construtor
    public RecyclerViewRestauranteAdapter(List<Restaurante> listaRestaurantes, RecyclerViewRestauranteClickListener listener) {
        this.listaRestaurantes = listaRestaurantes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.restaurante_recyclerview_item, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        final Restaurante restaurante = listaRestaurantes.get(position);
        viewHolder.setConteudoNaTela(restaurante);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(restaurante);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaRestaurantes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Atributos
        private ImageView imageViewRestauranteFoto;
        private TextView textViewRestauranteNome;
        private TextView textViewRestauranteEndereco;
        private TextView textViewRestauranteHorarioFechamento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Incialização das Views
            imageViewRestauranteFoto = itemView.findViewById(R.id.imageViewRestauranteFoto);
            textViewRestauranteNome = itemView.findViewById(R.id.textViewRestauranteNome);
            textViewRestauranteEndereco = itemView.findViewById(R.id.textViewRestauranteEndereco);
            textViewRestauranteHorarioFechamento = itemView.findViewById(
                    R.id.textViewRestauranteHorarioFechamento);

        }

        //Atribui os valores das views
        public void setConteudoNaTela(Restaurante restaurante) {

            String textEnderecoCompleto = "";
            String textHorarioFechamento = "";

            //Endereço
            textEnderecoCompleto = restaurante.getEndereco().getEndereco() + ", " +
                    restaurante.getEndereco().getNumero() + " - " +
                    restaurante.getEndereco().getBairro() + ", " +
                    restaurante.getEndereco().getCidade();

            //Horário Fechamento
            textHorarioFechamento = "Fecha às " +
                    restaurante.getHorarioFechamento();

            try{
                imageViewRestauranteFoto.setImageResource(restaurante.getFotoRestaurante());
            } catch (Exception ex){
                ex.printStackTrace();
            }

            textViewRestauranteNome.setText(restaurante.getNomeRestaurante());
            textViewRestauranteEndereco.setText(textEnderecoCompleto);
            textViewRestauranteHorarioFechamento.setText(textHorarioFechamento);

        }
    }
}
