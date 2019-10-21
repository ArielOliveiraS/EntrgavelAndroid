package com.example.entregavelandroid.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.entregavelandroid.R;
import com.example.entregavelandroid.adapter.BebidaAdapter;
import com.example.entregavelandroid.interfaces.RecyclerViewOnClickBebida;
import com.example.entregavelandroid.interfaces.RecyclerViewOnClickCervejaria;
import com.example.entregavelandroid.model.Bebida;
import com.example.entregavelandroid.model.Cervejaria;

import java.util.ArrayList;
import java.util.List;

import static com.example.entregavelandroid.views.Home.CERVEJARIA_KEY;

public class DetalheCervejaria extends AppCompatActivity  implements RecyclerViewOnClickBebida {

    public static final String BEBIDA_KEY = "bebida";
    private ImageView imagemBanner;
    private TextView nomeCervejaria;
    private TextView horarioFunc;
    private TextView endereço;
    private RecyclerView recyclerViewOnClickBebida;
    private BebidaAdapter adapter;
    private List<Bebida> bebidas = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cervejaria);
        initViews();

        if (getIntent() != null && getIntent().getExtras() != null) {

            Cervejaria cervejaria = getIntent().getExtras().getParcelable(CERVEJARIA_KEY);
            Drawable drawable = getResources().getDrawable(cervejaria.getImagem());
            imagemBanner.setImageDrawable(drawable);
            nomeCervejaria.setText(cervejaria.getNome());
        }
        recyclerViewOnClickBebida = findViewById(R.id.RecyclerBrbidas);

        adapter = new BebidaAdapter(listaDeBebidas(), this);
        recyclerViewOnClickBebida.setAdapter(adapter);
        recyclerViewOnClickBebida.setLayoutManager(new GridLayoutManager(this, 2));

    }


    private void initViews() {
        imagemBanner = findViewById(R.id.imgBannerCervejaria);
        nomeCervejaria = findViewById(R.id.txtNomeCervejariaLista);
        endereço = findViewById(R.id.txtItemEndereço);
        horarioFunc = findViewById(R.id.txtItemHorario);
        recyclerViewOnClickBebida = findViewById(R.id.RecyclerBrbidas);


    }

    private List<Bebida> listaDeBebidas(){

        bebidas.add(new Bebida("Lohn Bier Sour ", R.drawable.lohn, "Cerveja Lohn Bier Sour IPA 330ml"));
        bebidas.add(new Bebida("Leopoldina ", R.drawable.leopoldina, "Leopoldina APA 500ml"));
        bebidas.add(new Bebida("Leopoldina Russian", R.drawable.leopoldinarussian, "Leopoldina Russian Imperial Stout 750ml"));
        bebidas.add(new Bebida("klein Bier Weiss", R.drawable.klein, "klein Bier Weiss 500ml"));
        bebidas.add(new Bebida("Imigração Pilsen", R.drawable.imigacaopilsen, "Imigração Pilsen 355ml"));
        bebidas.add(new Bebida("bamberg Franconian Rhapsody", R.drawable.bamberg, "bamberg Franconian Rhapsody 600ml"));

        return  bebidas;
    }

    @Override
    public void onClick(Bebida bebida) {
        Intent intent = new Intent(DetalheCervejaria.this, DetalheBebida.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(BEBIDA_KEY, bebida);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
