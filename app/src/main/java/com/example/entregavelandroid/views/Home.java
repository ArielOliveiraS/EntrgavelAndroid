package com.example.entregavelandroid.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.entregavelandroid.R;
import com.example.entregavelandroid.adapter.CervejariaAdapter;
import com.example.entregavelandroid.interfaces.RecyclerViewOnClickCervejaria;
import com.example.entregavelandroid.model.Cervejaria;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements RecyclerViewOnClickCervejaria{
    public static final String CERVEJARIA_KEY = "cervejaria";

    private RecyclerView recyclerCervejaria;
    private CervejariaAdapter adapter;
    private List<Cervejaria> listaCervejaria = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        recyclerCervejaria = findViewById(R.id.RecyclerBrbidas);
        adapter= new CervejariaAdapter(listarCervejaria(), this );
        recyclerCervejaria.setAdapter(adapter);
        recyclerCervejaria.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Cervejaria> listarCervejaria(){

        listaCervejaria.add(new Cervejaria( "Perro Libre", "Endereço: Rua Cunha Gago, 83  – Pinheiros, São Paulo – SP",
                " Horários: 15h - 00h", R.drawable.perrolibre));
        listaCervejaria.add(new Cervejaria( "Bec Bar ", "Endereço: Rua Padre Garcia Velho, 72 – Pinheiros São Paulo/SP",
                " Horários: 12h - 00h", R.drawable.becbar));
        listaCervejaria.add(new Cervejaria( "Soul Botequim", "Endereço: Av. Padre Antonio Jose dos Santos 812, São Paulo",
                " Horários: 16h - 01h", R.drawable.soulbotequim));
        listaCervejaria.add(new Cervejaria( "Cervejaria Dogma", "Endereço: R. Fortunato, 236 - Vila Buarque, São Paulo - SP,",
                " Horários: 15h - 00h", R.drawable.cervejariadogma));
        listaCervejaria.add(new Cervejaria( "Goose Island", "Endereço: R. Baltazar Carrasco, 187 - Pinheiros, São Paulo - SP",
                " Horários: 14h - 00h", R.drawable.gooseisland));
        listaCervejaria.add(new Cervejaria( "Camara Fria Bar", "Endereço: R. Graúna, 137 - Moema, São Paulo - SP",
                " Horários: 12h - 01h", R.drawable.camarafria));


        return listaCervejaria;
    }


    @Override
    public void onClick(Cervejaria cervejaria) {
        Intent intent = new Intent(Home.this, DetalheCervejaria.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(CERVEJARIA_KEY, cervejaria);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
