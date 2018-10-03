package com.cam.arbolfamiliar;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;
@Entity
public class Persona implements Serializable {
    @PrimaryKey
    @NonNull
    private int id;
    @NonNull
    private String nombre;
    private int idpariente;
    private String parentesco;

    public Persona() {
    }

    public Persona(int id, String nombre, int idpariente, String parentesco) {
        this.id = id;
        this.nombre = nombre;
        this.idpariente = idpariente;
        this.parentesco = parentesco;
    }
    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdpariente() {
        return idpariente;
    }

    public void setIdpariente(int idpariente) {
        this.idpariente = idpariente;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
}
