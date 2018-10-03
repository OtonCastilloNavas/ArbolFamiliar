package com.cam.arbolfamiliar;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface PersonaDao {
    //8. Crear la funcion insertar, para insertar una persona en la base de datos
    @Update
    void actualizar(Persona persona);
    @Delete
    void borrar(Persona persona);

    @Query("Select * from persona")
    List<Persona> obtenerTodo();

    //9.Crear un metodo llamado obtenerPariente, que recibe un entero id,
    //Este metodo ejecutara una consulta select,
    // que busca a las personas que tengan el entero id en el campo idpariente

}
