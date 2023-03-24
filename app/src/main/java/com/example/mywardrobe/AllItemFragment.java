package com.example.mywardrobe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywardrobe.adapters.ItemAdapter;
import com.example.mywardrobe.database.Database;
import com.example.mywardrobe.models.Item;

import java.util.Vector;

public class AllItemFragment extends Fragment {

    private RecyclerView rvItems;
    private ItemAdapter adapter;
    private Vector<Item> listItems;
    private Database db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public void init(){
        db = Database.getInstance(getActivity());
        listItems = db.getAllItems();
        adapter = new ItemAdapter(getActivity(), listItems);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_item, container, false);
        rvItems = view.findViewById(R.id.recyclerViewManAllItems);
        rvItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvItems.setAdapter(adapter);
        return view;
    }
}
