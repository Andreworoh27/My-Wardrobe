package com.example.mywardrobe;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ManItemListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ManItemListFragment extends Fragment {

    private Button manShirtBtn,manPantsBtn,manAccBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_man_itemlist, container, false);
        manShirtBtn = view.findViewById(R.id.buttonViewMoreManShirt);
        manPantsBtn = view.findViewById(R.id.buttonViewMoreManPants);
        manAccBtn = view.findViewById(R.id.buttonViewMoreManAccesories);

        manShirtBtn.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(),ManShirtActivity.class);
            startActivity(intent);
        });

        manPantsBtn.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(),ManPantsActivity.class);
            startActivity(intent);
        });

        manAccBtn.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(),ManAccesoriesActivity.class);
            startActivity(intent);
        });

        return view;
    }
}