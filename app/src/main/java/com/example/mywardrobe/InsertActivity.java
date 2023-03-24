package com.example.mywardrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mywardrobe.database.Database;
import com.example.mywardrobe.models.Item;

public class InsertActivity extends AppCompatActivity {

    private Database db;
    private EditText edtName,edtType,edtImage;
    private Button button;
    private SmsManager smsManager;
    private int sendSmsPermission;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        setContentView(R.layout.activity_insert);
        init();
        button.setOnClickListener(view -> {
            if(edtName.getText().toString().isEmpty() || edtType.getText().toString().isEmpty() || edtImage.getText().toString().isEmpty()){
                Toast.makeText(this, "All field must be filles", Toast.LENGTH_SHORT).show();
                return;
            }

            String name = edtName.getText().toString();
            int type =new Integer(edtType.getText().toString());
            String image = edtImage.getText().toString();
            int imageInt = -1;

            if(image.equals("shirt")){
                imageInt = R.drawable.man_shirt;
            }
            else if(image.equals("pants")){
                imageInt = R.drawable.man_pants;
            }
            else{
                imageInt = R.drawable.man_accesories;
            }
            Item item = new Item();
            item.setName(name);
            item.setType(type);
            item.setImage(imageInt);
            Log.i("insert image", imageInt+"");
            db.insertItem(item);
            Intent intent = new Intent(this,HomeActivity.class);
            startActivity(intent);
        });
    }

    public void init(){
        db = Database.getInstance(this);
        edtName = findViewById(R.id.edtInsertName);
        edtType = findViewById(R.id.edtInsertType);
        edtImage = findViewById(R.id.edtInsertImage);
        button = findViewById(R.id.btnInsert);
    }
}