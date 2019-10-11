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

public class BebidaAdapter extends RecyclerView.Adapter<BebidaAdapter.ViewHolderBebida> {
    private List<Bebida> bebidas;
    private RecyclerViewOnClickBebida listener;

    public BebidaAdapter(List<Bebida> bebida, RecyclerViewOnClickBebida listener){
        this.bebidas = bebida;
        this.listener = listener;
    }


    @NonNull
    @Override
    public BebidaAdapter.ViewHolderBebida onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_cerveja, parent, false);
        return new ViewHolderBebida(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BebidaAdapter.ViewHolderBebida holder, int position) {
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

    public class ViewHolderBebida extends RecyclerView.ViewHolder {
        TextView txtBebida;
        ImageView imagemBebida;

        public ViewHolderBebida(@NonNull View itemView) {
            super(itemView);
            txtBebida = itemView.findViewById(R.id.txtItemNomeCerveja);
            imagemBebida = itemView.findViewById(R.id.imgItemBebida);
        }

        public void onBind(Bebida bebida) {
            txtBebida.setText(bebida.getNomeBebida());
            Drawable drawable = itemView.getResources().getDrawable(bebida.getImgBebida());
            imagemBebida.setImageDrawable(drawable);

        }
    }
}
