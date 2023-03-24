package com.example.mywardrobe.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private String CREATE_TABLE_ITEM = "CREATE TABLE items (id integer PRIMARY KEY AUTOINCREMENT, " +
                                                        "name text NOT NULL, " +
                                                        "type integer NOT NULL, " +
                                                        "image long NOT NULL)";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "wardrobe", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ITEM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS items");
    }
}
