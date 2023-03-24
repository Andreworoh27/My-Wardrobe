package com.example.mywardrobe.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.mywardrobe.models.Item;

import java.util.Vector;

public class ItemHelper {
    final String TABLE_NAME = "items";
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;


    public ItemHelper(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public Vector<Item> getAllShirts(){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM items WHERE type = 1",null);
        Vector<Item> listItems = new Vector<>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Item item = new Item();
            item.setId(cursor.getInt(0));
            item.setName(cursor.getString(1));
            item.setType(cursor.getInt(2));
            item.setImage(cursor.getInt(3));
            listItems.add(item);
            cursor.moveToNext();
        }
        db.close();
        return listItems;
    }

    public Vector<Item> getAllPants(){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM items WHERE type = 2",null);
        Vector<Item> listItems = new Vector<>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Item item = new Item();
            item.setId(cursor.getInt(0));
            item.setName(cursor.getString(1));
            item.setType(cursor.getInt(2));
            item.setImage(cursor.getInt(3));
            listItems.add(item);
            cursor.moveToNext();
        }
        db.close();
        return listItems;
    }

    public Vector<Item> getAllAccesories(){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM items WHERE type = 3",null);
        Vector<Item> listItems = new Vector<>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Item item = new Item();
            item.setId(cursor.getInt(0));
            item.setName(cursor.getString(1));
            item.setType(cursor.getInt(2));
            item.setImage(cursor.getInt(3));
            listItems.add(item);
            cursor.moveToNext();
        }
        db.close();
        return listItems;
    }

    public Vector<Item> getAllItems(){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM items",null);
        Vector<Item> listItems = new Vector<>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Item item = new Item();
            item.setId(cursor.getInt(0));
            item.setName(cursor.getString(1));
            item.setType(cursor.getInt(2));
            item.setImage(cursor.getInt(3));
            listItems.add(item);
            cursor.moveToNext();
        }
        db.close();
        return listItems;
    }

    public Item getItemById(int id){
            db = dbHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM items WHERE id=?", new String[] {String.valueOf(id)});
            Item item = null;

            if (cursor.moveToFirst()) {
                item = new Item();
                item.setId(cursor.getInt(0));
                item.setName(cursor.getString(1));
                item.setType(cursor.getInt(2));
                item.setImage(cursor.getInt(3));
            }

            cursor.close();
            db.close();
            return item;
    }

    public void insert(Item item){
        db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",item.getName());
        contentValues.put("type",item.getType());
        contentValues.put("image",item.getImage());
        Log.i("insert type to db", contentValues.get("type").toString());
        db.insert(TABLE_NAME,null,contentValues);
        db.close();
    }

    public void update(Item item) {
        db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", item.getName());
        contentValues.put("type", item.getType());
        contentValues.put("image", item.getImage());
        db.update(TABLE_NAME, contentValues, "id=?", new String[] {String.valueOf(item.getId())});
        db.close();
    }


    public void delete(int deleteId){
        db = dbHelper.getWritableDatabase();
//        db.delete(TABLE_NAME,"type = ?",new String[]{"1"});
        db.delete(TABLE_NAME,"id = ?",new String[]{deleteId + ""});
        db.close();
    }
}
