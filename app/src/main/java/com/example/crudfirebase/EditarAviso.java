package com.example.crudfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditarAviso extends AppCompatActivity {

    private EditText nombreProfesor,avisoProfesor;

    private String id_avisoB = "";
    private String nombreProfesorB = "";
    private String avisoProfesorB = "";

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_aviso);

        if (null!=this.getIntent()){
            if (null!=this.getIntent().getExtras()){
                Bundle parametrosEntrada = this.getIntent().getExtras();
                id_avisoB = parametrosEntrada.getString("id");
                nombreProfesorB = parametrosEntrada.getString("nombreProfesor");
                avisoProfesorB = parametrosEntrada.getString("avisoProfesor");

            }
        }
        nombreProfesor = findViewById(R.id.EditarProfesorId);
        nombreProfesor.setText(nombreProfesorB);
        avisoProfesor = findViewById(R.id.EditarAvisoId);
        avisoProfesor.setText(avisoProfesorB);

    }

    public void editarAviso(View v){
        try {
            FirebaseApp.initializeApp(this);
            database = FirebaseDatabase.getInstance();
            reference = database.getReference().child("AvisosDocente");

            Avisos editAviso = new Avisos();
            editAviso.setId_Aviso(id_avisoB);
            editAviso.setNombreProfesor(nombreProfesor.getText().toString());
            editAviso.setAvisoProfesor(avisoProfesor.getText().toString());

            reference.child(id_avisoB).setValue(editAviso);
            Toast.makeText(this, "Data actualizada", Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Toast.makeText(this, "Error al actualizar", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void volver(View v){
        Intent i = new Intent(this,ListaAvisos.class);
        startActivity(i);

    }
}