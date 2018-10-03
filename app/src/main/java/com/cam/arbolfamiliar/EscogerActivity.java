package com.cam.arbolfamiliar;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class EscogerActivity extends AppCompatActivity {

    List<Persona> personaList= new ArrayList<>();
    DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escoger);
        //1. Invocar la creacion de la base de datos
        personaList.addAll(db.personaDao().obtenerTodo());
        ListView lvPersona = (ListView) findViewById(R.id.lvPersonas);
        //2. Crear el adaptador personalizado para mostrar Personas, utilizando el layout item_persona
        lvPersona.setAdapter(adapter);
        //3. Registrar el ListView para que reaccione al contextMenu
    }
//3. Tambien debe escribir el metodo que crea el menu contextual


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        Persona persona=personaList.get(info.position);
        Intent intent = new Intent();
 //10.
        intent.putExtra("persona",persona);
        setResult(RESULT_OK,intent);
        finish();
        return super.onContextItemSelected(item);
    }
}