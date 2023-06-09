package com.example.mywardrobe.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mywardrobe.AllItemFragment;
import com.example.mywardrobe.ManItemListFragment;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new ManItemListFragment();
            case 1: return new AllItemFragment();
        }
        return new ManItemListFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
