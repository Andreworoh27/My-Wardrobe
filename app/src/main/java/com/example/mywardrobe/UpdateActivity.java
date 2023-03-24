package com.example.mywardrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.mywardrobe.adapters.ItemAdapter;
import com.example.mywardrobe.database.Database;
import com.example.mywardrobe.models.Item;

public class UpdateActivity extends AppCompatActivity {

    private Database db;
    private EditText edtName,edtType,edtImage;
    private Button button;
    private Item item;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        init();
        button.setOnClickListener(view -> {
            item.setName(edtName.getText().toString());
            item.setType(new Integer(edtType.getText().toString()));
            String image = edtImage.getText().toString();
            int imageInt = -1;

            if(edtImage.getText().toString().equals("shirt")){
                imageInt = R.drawable.man_shirt;
            }
            else if(edtImage.getText().toString().equals("pants")){
                imageInt = R.drawable.man_pants;
            }
            else{
                imageInt = R.drawable.man_accesories;
            }
            item.setImage(imageInt);
            db.updateItem(item);
            Intent intent = new Intent(this,HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        });
    }

    public void init(){
        db = Database.getInstance(this);
        edtName = findViewById(R.id.edtUpdatetName);
        edtType = findViewById(R.id.edtUpdateType);
        edtImage = findViewById(R.id.edtUpdateImage);
        button = findViewById(R.id.btnUpdate);
        id = getIntent().getIntExtra("item_id",-1);
        if (id == -1){
            Intent intent = new Intent(this,HomeActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        item = db.getItemById(id);
        edtName.setText(item.getName());
        edtType.setText(item.getType()+"");
        if(item.getImage() == R.drawable.man_shirt) edtImage.setText("shirt");
        else if (item.getImage() == R.drawable.man_pants) edtImage.setText("pants");
        else edtImage.setText("accesories");
    }
}