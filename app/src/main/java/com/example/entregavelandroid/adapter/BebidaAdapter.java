package com.example.entregavelandroid.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.entregavelandroid.R;
import com.example.entregavelandroid.interfaces.RecyclerViewOnClickBebida;
import com.example.entregavelandroid.model.Bebida;

import java.util.List;

public class BebidaAdapter extends RecyclerView.Adapter<BebidaAdapter.ViewHolder> {
    private List<Bebida> bebidas;
    private RecyclerViewOnClickBebida listener;


    public BebidaAdapter(List<Bebida> bebidas, RecyclerViewOnClickBebida listener){
        this.bebidas =bebidas;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_cerveja, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Bebida bebida = bebidas.get(position);
        holder.onBind(bebida);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(bebida);
            }
        });

    }

    @Override
    public int getItemCount() {
        return bebidas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomeBebida;
        ImageView imagemBebida;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeBebida = itemView.findViewById(R.id.txtItemNomeCerveja);
            imagemBebida = itemView.findViewById(R.id.imgItemBebida);

        }

        public void onBind(Bebida bebida) {
            nomeBebida.setText(bebida.getNomeBebida());
            Drawable drawable = itemView.getResources().getDrawable(bebida.getImgBebida());
            imagemBebida.setImageDrawable(drawable);

        }
    }
}
