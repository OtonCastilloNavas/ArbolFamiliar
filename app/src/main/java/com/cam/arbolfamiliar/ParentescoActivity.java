package com.cam.arbolfamiliar;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ParentescoActivity extends AppCompatActivity {

    private Persona persona=new Persona();
    private Persona pariente= new Persona();
    private List<Persona> parientesList=new ArrayList<>();
    private DB db;
    private ListView lvParientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parentesco);
        //1. Invocar la creacion de la base de datos
        persona= (Persona) getIntent().getExtras().get("persona");
        parientesList.addAll(db.personaDao().obtenerPariente(persona.getId()));
        //2. Crear adaptador personalizado para Parentesco, utilizando el layout item_parentesco

        lvParientes=(ListView) findViewById(R.id.lvParientes);
        lvParientes.setAdapter(adapter);
        TextView tvNombre=(TextView) findViewById(R.id.tvNombre);
        tvNombre.setText("Persona: " + persona.getNombre());
    }

    public void onClick(View view)
    {
        if(view.getId()==R.id.btPariente) {
            Intent intent = new Intent(ParentescoActivity.this, EscogerActivity.class);
           //7. Iniciar actividad creada en el intent, esperando tener resultado.
        }
        else if(view.getId()==R.id.btInsertar)
        {
            pariente.setIdpariente(persona.getId());
            //5. Invocar la actualizacion de la base de datos
            parientesList.add(pariente);
            ((ParentescoAdapter)lvParientes.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK)
        {
            pariente= (Persona) data.getExtras().get("persona");
            TextView tvParentesco = (TextView) findViewById(R.id.tvPariente);
            tvParentesco.setText(pariente.getNombre());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}