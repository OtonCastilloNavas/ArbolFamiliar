package com.cam.arbolfamiliar;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
@Database(entities = {Persona.class},version = 1)
public abstract class DB extends RoomDatabase {
    public abstract PersonaDao personaDao();
}
