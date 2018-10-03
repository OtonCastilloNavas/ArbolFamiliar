package com.cam.arbolfamiliar;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Persona> personaList = new ArrayList<>();
    private ListView lvPersona;
    private DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1. Invocar la creacion de la base de datos
        personaList.addAll(db.personaDao().obtenerTodo());
        lvPersona=(ListView) findViewById(R.id.lvPersonas);
        //2. Crear adaptador personalizado para Persona, utilizando el layout item_persona.
        lvPersona.setAdapter(adapter);
        //3. Registrar el ListView para que reaccione al contextMenu
        lvPersona.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,ParentescoActivity.class);
                intent.putExtra("persona",personaList.get(i));
                //6. Iniciar la actividad creada en el intent
            }
        });
    }

    public void onClick(View view)
    {
        EditText etNombre=(EditText) findViewById(R.id.etNombre);
        Random random=new Random();
        Persona persona= new Persona(random.nextInt(999999)+1,etNombre.getText().toString());
        personaList.add(persona);
        db.personaDao().insertar(persona);
        ((PersonaAdapter)lvPersona.getAdapter()).notifyDataSetChanged();
        etNombre.setText("");
    }
//3. Tambien debe escribir el metodo que crea el menu contextual

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId())
        {
             case R.id.mnBorrar:
                Toast.makeText(this, "Borrar " + personaList.get(info.position).getNombre(), Toast.LENGTH_SHORT).show();
                //4. Invocar el borrado de la base de datos
                personaList.remove(info.position);
                 ((PersonaAdapter)lvPersona.getAdapter()).notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }

  }