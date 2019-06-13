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
import br.com.digitalhouse.desafioandroid.interfaces.RecyclerViewRestauranteDetalheClickListener;
import br.com.digitalhouse.desafioandroid.model.Prato;
import br.com.digitalhouse.desafioandroid.model.Restaurante;

public class RecyclerViewRestauranteDetalheAdapter extends
        RecyclerView.Adapter<RecyclerViewRestauranteDetalheAdapter.ViewHolder> {

    //Atributos
    private List<Prato> listaPratos = new ArrayList<>();
    private RecyclerViewRestauranteDetalheClickListener listener;

    //Construtor
    public RecyclerViewRestauranteDetalheAdapter(List<Prato> listaPratos,
                                                 RecyclerViewRestauranteDetalheClickListener listener) {
        this.listaPratos = listaPratos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.restaurante_detalhe_recyclerview_item, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        final Prato prato = listaPratos.get(position);
        viewHolder.setConteudoNaTela(prato);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(prato);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaPratos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Atributos
        private ImageView imageViewRestauranteDetalheFotoPrato;
        private TextView textViewRestauranteDetalheNomePrato;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Incialização das Views
            imageViewRestauranteDetalheFotoPrato = itemView.findViewById(
                    R.id.imageViewRestauranteDetalheFotoPrato);

            textViewRestauranteDetalheNomePrato = itemView.findViewById(
                    R.id.textViewRestauranteDetalheNomePrato);
        }

        //Atribui os valores das views
        public void setConteudoNaTela(Prato prato) {

            //Foto Prato
            try {
                imageViewRestauranteDetalheFotoPrato.setImageResource(prato.getFotoPrato());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Nome do Prato
            textViewRestauranteDetalheNomePrato.setText(prato.getNome());

        }
    }
}
