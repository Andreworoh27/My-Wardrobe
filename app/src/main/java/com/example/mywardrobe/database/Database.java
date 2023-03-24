package com.example.mywardrobe.database;

import android.content.Context;

import com.example.mywardrobe.models.Item;

import java.util.Vector;

public class Database {
    private static Database _instance = null;
    private ItemHelper itemHelper;

    private Database(Context context){
        itemHelper = new ItemHelper(context);
    }

    public static Database getInstance(Context context){
        if(_instance == null){
            synchronized (Database.class){
                if(_instance == null){
                    _instance = new Database(context);
                }
            }
        }
        return _instance;
    }

    public Vector<Item> getAllItems(){
        return itemHelper.getAllItems();
    }

    public Vector<Item> getAllShirt(){
        return itemHelper.getAllShirts();
    }

    public Vector<Item> getAllPants(){
        return itemHelper.getAllPants();
    }

    public Vector<Item> getAllAccesories(){
        return itemHelper.getAllAccesories();
    }

    public Item getItemById(int id){return itemHelper.getItemById(id);}

    public void insertItem(Item item){
        itemHelper.insert(item);
    }

    public void updateItem(Item item) {itemHelper.update(item);}

    public void removeItem(int deleteId){
        itemHelper.delete(deleteId);
    }

}
