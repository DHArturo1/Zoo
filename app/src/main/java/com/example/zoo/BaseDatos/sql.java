package com.example.zoo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sql extends SQLiteOpenHelper {
    private static final String database = "zoo";
    private static final int VERSION = 1;

    //fields
    private final String tanimal =
        "CREATE TABLE ANIMALS " + "("+
            "ID_ANIMAL INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
            "CLASIFICACION TEXT NOT NULL, "+
            "ESPECIE TEXT NOT NULL, "+
            "NAME TEXT NOT NULL, "+
            "SEX TEXT NOT NULL, "+
            "DATE_ON TEXT NOT NULL, "+
            "HABIT TEXT NOT NULL, "+
            "FOOD TEXT NOT NULL " +
        ")";

    public sql(Context context){
        super(context, database, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tanimal);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion){
            db.execSQL(("DROP TABLE IF EXISTS ANIMALS"));
            db.execSQL(tanimal);
        }

    }
}