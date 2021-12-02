package com.example.crudfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private TextView nombreProfesor,AvisoProfesor;

    FirebaseDatabase miBaseDatos;
    DatabaseReference referencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreProfesor = findViewById(R.id.nombreDocenteId);
        AvisoProfesor = findViewById(R.id.avisoDocenteId);

        FirebaseApp.initializeApp(this);
        miBaseDatos = FirebaseDatabase.getInstance();
        referencia = miBaseDatos.getReference().child("AvisosDocente");
    }


    public void insertar(View v){
        try {

            Avisos nuevoAviso = new Avisos();

            String id_Aviso_Nuevo = UUID.randomUUID().toString();

            nuevoAviso.setId_Aviso(id_Aviso_Nuevo);
            nuevoAviso.setNombreProfesor(nombreProfesor.getText().toString());
            nuevoAviso.setAvisoProfesor(AvisoProfesor.getText().toString());

            referencia.child(id_Aviso_Nuevo).setValue(nuevoAviso);

            Toast.makeText(this, "Inserta dato", Toast.LENGTH_SHORT).show();
        }catch (Exception e){

        }
    }

    public void verLista(View v){
        Intent i  = new Intent(this,ListaAvisos.class);
        startActivity(i);
    }
}