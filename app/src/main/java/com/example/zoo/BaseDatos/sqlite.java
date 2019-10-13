package com.example.zoo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.util.Log;

import java.util.ArrayList;

public class sqlite {

    //trabajar con la informacion de la BD
    private sql sql;
    private SQLiteDatabase db;

    public sqlite (Context context){
        sql = new sql(context);
    }

    public void openDB(){
        Log.i("SQLite", "Se abre la conexion a la base de datos"+sql.getDatabaseName());
        db = sql.getReadableDatabase();
    }

    public void closeDB(){
        Log.i("SQLite", "Se abre la conexion a la base de datos"+sql.getDatabaseName());
        db = sql.getReadableDatabase();
        sql.close();
    }

    public boolean addReg(int id, String clas, String esp, String name, String sex, String dateOn, String habit, String food){
        ContentValues cv = new ContentValues();
        cv.put("ID_ANIMAL", id);
        cv.put("CLASIFICACION", clas);
        cv.put("ESPECIE", esp);
        cv.put("NAME", name);
        cv.put("SEX", sex);
        cv.put("DATE_ON", dateOn);
        cv.put("HABIT", habit);
        cv.put("FOOD", food);
        return (db.insert("ANIMALS", null, cv) !=1)? true: false;
    }

    public Cursor getRegister(){
        return db.rawQuery("SELECT * FROM ANIMAL", null);
    }

    public ArrayList<String> getAnimal(Cursor cursor){
        ArrayList<String> listData = new ArrayList<>();
        String item = "";
        if(cursor.moveToFirst()){
            do{
                item += "ID : ["+cursor.getInt(0)+"]\r\n";
                item += "CLASIFICACION : ["+cursor.getInt(1)+"]\r\n";
                item += "ESPECIE : ["+cursor.getInt(2)+"]\r\n";
                item += "NAME : ["+cursor.getInt(3)+"]\r\n";
                item += "SEX : ["+cursor.getInt(4)+"]\r\n";
                item += "DATE_ON : ["+cursor.getInt(5)+"]\r\n";
                item += "HABIT : ["+cursor.getInt(6)+"]\r\n";
                item += "FOOD : ["+cursor.getInt(7)+"]\r\n";
                listData.add(item);
                item = "";
            }while(cursor.moveToNext());
        }
        return listData;
    }

    public ArrayList<String> getID(Cursor cursor){
        ArrayList<String> listData = new ArrayList<>();
        String item = "";
        if(cursor.moveToFirst()){
            do{
                item += "ID : ["+cursor.getInt(0)+"]\r\n";
                listData.add(item);
                item = "";
            }while(cursor.moveToNext());
        }
        return listData;
    }

    public String upgradeReg(int id, String clas, String esp, String name, String sex, String dateOn, String habit, String food){
        ContentValues cv = new ContentValues();
        cv.put("ID_ANIMAL", id);
        cv.put("CLASIFICACION", clas);
        cv.put("ESPECIE", esp);
        cv.put("NAME", name);
        cv.put("SEX", sex);
        cv.put("DATE_ON", dateOn);
        cv.put("HABIT", habit);
        cv.put("FOOD", food);
        int cant = db.update("ANIMALS", cv, "ID_ANIMAL = " + id, null);

        if(cant == 1){
            return "registro modificado";
        } else {
            return "registro no modificado";
        }
    }

    public Cursor getCant(int id){
        return db.rawQuery("SELECT * FROM ANIMALS WHERE ID_ANIMAL = "+ id, null);
    }

    public int delete(Editable id){
        return db.delete("ANIMALES","ID_ANIMAL = " + id , null );
    }
}
