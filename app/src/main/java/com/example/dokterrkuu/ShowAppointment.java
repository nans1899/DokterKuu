package com.example.dokterrkuu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dokterrkuu.RecyclerViewPackage.DatabaseRecyclerAdapter;
import com.example.dokterrkuu.RecyclerViewPackage.ModelClass;

import java.util.ArrayList;

public class ShowAppointment extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelClass> objModelClassArrayList;

    DatabaseRecyclerAdapter objDatabaseRecyclerAdapter;

    DatabaseHelper databaseHelper;

    Button updateB, deleteB;

    TextView name;
    EditText date, disease, docname, hospital,notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_appointment);

        View inflatedView = getLayoutInflater().inflate(R.layout.single_row, null);

        databaseHelper = new DatabaseHelper(this);
        recyclerView = (RecyclerView) findViewById(R.id.ListAppointmnet);
        objModelClassArrayList = new ArrayList<>();
        updateB = (Button) inflatedView.findViewById(R.id.buttonUpdate);
        deleteB = (Button) inflatedView.findViewById(R.id.buttonDelete);


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
    public void updateDataShowAppointment(){
      updateB.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(ShowAppointment.this, DocAppointment.class);

              DatabaseHelper databaseHelper = new DatabaseHelper(ShowAppointment.this);
              SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
              Cursor cursor = sqLiteDatabase.rawQuery("select * from UsersAppointment", new String[]{" Username "});
              String thename = cursor.getString(0);

              View docapp = getLayoutInflater().inflate(R.layout.activity_doc_appointment, null);

              EditText updatedname = (EditText) docapp.findViewById(R.id.UsernameDocAppointment);

              updatedname.setText(thename);

              Button updated = (Button) docapp.findViewById(R.id.JanjiButton);

              updated.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      DocAppointment docAppointment = new DocAppointment();
                      docAppointment.updateButton();
                  }
              });
              startActivity(intent);
          }
      });
    }


}
