package com.test.kesmile.codigos.basedatos.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 16/01/15.
 */
public class UsuariosSQLiteHelper extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE usuarios (usuario TEXT, password TEXT)";
    public UsuariosSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL(sqlCreate);
    }
}
