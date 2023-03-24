package com.example.mywardrobe.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywardrobe.R;
import com.example.mywardrobe.UpdateActivity;
import com.example.mywardrobe.database.Database;
import com.example.mywardrobe.models.Item;

import java.util.Vector;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private Context context;
    private Vector<Item> listItems = new Vector<>();
    private Database db;

    public ItemAdapter(Context context,Vector<Item> listItems){
        this.context = context;
        this.listItems = listItems;
        this.db = Database.getInstance(this.context);
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        Item item = listItems.get(position);

        if(item.getType() == 1) holder.ivCover.setImageResource(R.drawable.man_shirt);
        else if (item.getType() == 2) holder.ivCover.setImageResource(R.drawable.man_pants);
        else holder.ivCover.setImageResource(R.drawable.man_accesories);
//        holder.ivCover.getResources().getIdentifier(item.getImage()+"", null, context.getPackageName());
//        holder.ivCover.setImageResource(Integer.parseInt(item.getImage()+""));
        Log.i("type show", item.getType()+"");
        holder.tvName.setText(item.getName());
        holder.btnDelete.setOnClickListener(view -> {
            db.removeItem(item.getId());
            listItems.remove(item);
            notifyDataSetChanged();
        });
        holder.btnUpdate.setOnClickListener(view -> {
            Intent intent = new Intent(context, UpdateActivity.class);
            intent.putExtra("item_id", item.getId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivCover;
        private TextView tvName;
        private Button btnDelete,btnUpdate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCover = itemView.findViewById(R.id.itemIvCover);
            tvName = itemView.findViewById(R.id.itemTvName);
            btnDelete = itemView.findViewById(R.id.itemBtnDelete);
            btnUpdate = itemView.findViewById(R.id.itemBtnUpdate);
        }
    }
}
