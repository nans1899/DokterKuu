package com.example.dokterrkuu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class single_row1 extends AppCompatActivity {

    Button update, delete;
    TextView nama;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_row1);

        databaseHelper = new DatabaseHelper(this);
        delete = (Button) findViewById(R.id.buttonDelete);
        update = (Button) findViewById(R.id.buttonUpdate);
    }


    public void relocate(){
                Intent intent = new Intent(single_row1.this, DocAppointment.class);
                startActivity(intent);
    }


    public void delete(){
                nama = (TextView) findViewById(R.id.viewName);
                Integer deleteRows = databaseHelper.Delete(nama.getText().toString());
                if(deleteRows>0){
                    Toast.makeText(single_row1.this, "Data Successfuly Deleted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(single_row1.this, "Failed to Delete The Data", Toast.LENGTH_SHORT).show();
                }
    }
}
