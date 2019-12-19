package com.example.dokterrkuu.RecyclerViewPackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dokterrkuu.DatabaseHelper;
import com.example.dokterrkuu.DocAppointment;
import com.example.dokterrkuu.R;


public class singleRow extends AppCompatActivity {

    Button update, delete;
    TextView nama;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_row);
        databaseHelper = new DatabaseHelper(this);
        delete = (Button) findViewById(R.id.buttonDelete);
        update = (Button) findViewById(R.id.buttonUpdate);
        relocate();
        delete();
    }




    public void relocate(){
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(singleRow.this, DocAppointment.class);
                startActivity(intent);
            }
        });
    }


    public void delete(){
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = (TextView) findViewById(R.id.viewName);
                Integer deleteRows = databaseHelper.Delete(nama.getText().toString());
                if(deleteRows>0){
                    Toast.makeText(singleRow.this, "Data Successfuly Deleted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(singleRow.this, "Failed to Delete The Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
