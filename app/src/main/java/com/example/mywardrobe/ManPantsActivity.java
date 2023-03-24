package com.example.mywardrobe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mywardrobe.adapters.ItemAdapter;
import com.example.mywardrobe.database.Database;
import com.example.mywardrobe.models.Item;

import java.util.Vector;

public class ManPantsActivity extends AppCompatActivity {

    private RecyclerView rvItems;
    private ItemAdapter adapter;
    private Vector<Item> listItems;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_pants);
        init();
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        rvItems.setAdapter(adapter);
    }

    private void init(){
        rvItems = findViewById(R.id.recyclerViewManPants);
        db = Database.getInstance(this);
        listItems = db.getAllPants();
        adapter = new ItemAdapter(this,listItems);
    }
}