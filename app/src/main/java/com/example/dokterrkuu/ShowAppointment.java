package com.example.dokterrkuu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dokterrkuu.RecyclerViewPackage.DatabaseRecyclerAdapter;
import com.example.dokterrkuu.RecyclerViewPackage.ModelClass;

import org.w3c.dom.Text;

import java.sql.Date;
import java.util.ArrayList;

public class ShowAppointment extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelClass> objModelClassArrayList;

    DatabaseRecyclerAdapter objDatabaseRecyclerAdapter;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_appointment);


        databaseHelper = new DatabaseHelper(this);
        recyclerView = (RecyclerView) findViewById(R.id.ListAppointmnet);
        objModelClassArrayList = new ArrayList<>();



    }

    public void showValueFromDatabase(View view){
        try{
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
            if(sqLiteDatabase != null){
                Cursor cursor = sqLiteDatabase.rawQuery("select * from UsersAppointment", null);
                if(cursor.getCount()==0){
                    Toast.makeText(this, "No Data To Show", Toast.LENGTH_SHORT).show();
                }else{

                    while(cursor.moveToNext()){
                        objModelClassArrayList.add(new ModelClass(cursor.getString(0),
                                        cursor.getString(1),
                                        cursor.getString(2),
                                        cursor.getString(3),
                                        cursor.getString(4),
                                        cursor.getString(5)
                        ));
                    }
                    objDatabaseRecyclerAdapter = new DatabaseRecyclerAdapter(objModelClassArrayList);

                    recyclerView.hasFixedSize();

                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    recyclerView.setAdapter(objDatabaseRecyclerAdapter);

                }
            }else{
                Toast.makeText(this, "Database Not Found or Null", Toast.LENGTH_SHORT).show();
            }

        }catch(Exception e){
            Toast.makeText(this, "Failed to Show Value Error : "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
