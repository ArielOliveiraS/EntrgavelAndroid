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
import com.example.entregavelandroid.interfaces.RecyclerViewOnClickCervejaria;
import com.example.entregavelandroid.model.Cervejaria;

import java.util.List;

public class CervejariaAdapter extends RecyclerView.Adapter<CervejariaAdapter.ViewHolder> {
    private List<Cervejaria> listaDeCervejarias;
    private RecyclerViewOnClickCervejaria listener;

    public CervejariaAdapter(List<Cervejaria> cervejarias, RecyclerViewOnClickCervejaria listener) {
        this.listaDeCervejarias = cervejarias;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_cervejaria, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Cervejaria cervejaria = listaDeCervejarias.get(position);
        holder.onBind(cervejaria);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(cervejaria);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaDeCervejarias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNomeCervejaria;
        TextView txtEndereçoCervejaria;
        TextView txtHorarioFuncionamento;
        ImageView imagemCervejaria;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNomeCervejaria = itemView.findViewById(R.id.txtNomeCervejaria);
            txtEndereçoCervejaria = itemView.findViewById(R.id.txtItemEndereço);
            txtHorarioFuncionamento = itemView.findViewById(R.id.txtItemHorario);
            imagemCervejaria = itemView.findViewById(R.id.imgBannerCervejaria);
        }

            public void onBind( Cervejaria cervejaria){
            Drawable drawable = itemView.getResources().getDrawable(cervejaria.getImagem());
            txtNomeCervejaria.setText(cervejaria.getNome());
            txtHorarioFuncionamento.setText(cervejaria.getHorarioFuncionamento());
            txtEndereçoCervejaria.setText(cervejaria.getEndereco());
            imagemCervejaria.setImageDrawable(drawable);

        }
    }
}
