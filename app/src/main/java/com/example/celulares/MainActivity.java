package com.example.celulares;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView lstOpciones;
    private Intent i;
    private ArrayList<Celular> celulares;
    private LinearLayoutManager llm;
    private String db = "Celulares";
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lstOpciones = findViewById(R.id.lstCelulares);
        celulares = new ArrayList<>();
        final AdaptadorCelular adapter = new AdaptadorCelular(celulares);
        llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        lstOpciones.setLayoutManager(llm);
        lstOpciones.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(db).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                celulares.clear();
                if(dataSnapshot.exists()){
                    for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Celular p = snapshot.getValue(Celular.class);
                        celulares.add(p);
                    }
                }
                adapter.notifyDataSetChanged();
                Datos.setPersonas(celulares);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void agregarCelular(View v){
        i = new Intent(MainActivity.this,AgregarCelular.class);
        startActivity(i);
        finish();
    }
}
