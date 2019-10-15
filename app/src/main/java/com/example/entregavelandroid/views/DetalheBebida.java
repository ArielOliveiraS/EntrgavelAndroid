package com.example.entregavelandroid.views;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.entregavelandroid.R;
import com.example.entregavelandroid.interfaces.RecyclerViewOnClickBebida;
import com.example.entregavelandroid.model.Bebida;

import static com.example.entregavelandroid.views.DetalheCervejaria.BEBIDA_KEY;

public class DetalheBebida extends AppCompatActivity {

    private TextView nomeBebida;
    private TextView descricaoBebida;
    private ImageView imagemBebida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_bebida);
        initViews();

        if (getIntent() != null && getIntent().getExtras() != null) {
            Bebida bebida = getIntent().getExtras().getParcelable(BEBIDA_KEY);
            Drawable drawable = getResources().getDrawable(bebida.getImgBebida());
            imagemBebida.setImageDrawable(drawable);
            nomeBebida.setText(bebida.getNomeBebida());
            descricaoBebida.setText(bebida.getDescrBebida());
        }

    }

    private void initViews() {
        nomeBebida = findViewById(R.id.txtItemNomeCervejaria);
        descricaoBebida = findViewById(R.id.txtDescrBebida);
        imagemBebida = findViewById(R.id.imgBebidaDetalhe);
    }
}
