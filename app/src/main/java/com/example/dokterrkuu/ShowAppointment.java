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

    Spinner spinner1,spinner2;

    TextView diseasetype;

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



                    View singlerow = getLayoutInflater().inflate(R.layout.single_row, null);

                    diseasetype = (TextView) singlerow.findViewById(R.id.viewDisease);
                    spinner1 = (Spinner) singlerow.findViewById(R.id.spinnerDocName);
                    spinner2 = (Spinner) singlerow.findViewById(R.id.spinnerHospital);


                    //THE DOCTORS
                    final String[] Penglihatan = {"Prof. Dr. Darwin Dalimunthe","Prof. Dr. Enrique Immanuel","Prof. Dr. Enrico Herlambang"};
                    final String[] Kesehatangigi = {"Prof. Dr. DjokoSoemantri","Prof. Dr. M. Hidayat","Prof. Dr. Enrico Herlambang"};
                    final String[] Pernafasan = {"Prof. Dr. dr. Harianto N","Prof. Dr. M. Hidayat","Prof. Dr. Dhea Deminto"};
                    final String[] Lambung = {"Prof. Dr. Soetjipto","Prof. Dr. Austin Deminto","Prof. Dr. dr. Harianto N","Prof. Dr. DjokoSoematri"};
                    final String[] SakitKepala = {"Prof. Dr. Darwin Dalimunthe","Prof. Dr. Enrico Herlambang","","Prof. Dr. Dhea Deminto"};
                    final String[] KesehatanJantung = {"Prof. Dr. Ezra Adiwena","Prof. Dr. Austin Deminto","Prof. Dr. Enrico Herlambang"};
                    final String[] Pendengaran = {"Prof. Dr. dr. Harianto N","Prof. Dr. Dhea Deminto","Prof. Dr. dr. Daniel Colunga"};
                    final String[] Tulang = {"Prof. Dr. Ezra Adiwena","Prof. Dr. Enrique Immanuel","Prof. Dr. dr. Harianto N","Prof. Dr. M. Hidayat"};

                    //THE HOSPITALS
                    final String[] drHarianto = {"Rs Cipto Mangunkusumo","Rs Al Minthohardjo","Rs MMC"};
                    final String[] drDjokoSoematri = {"Rs Pertamina","Rs MMC","Hospital Tanggerang"};
                    final String[] drMHidayat = {"Rs Pelni","Rs Pertamina","Rs MMC"};
                    final String[] drSoetjipto = {"Rs Pelni","Rs Pertamina","Hospital Tanggerang"};
                    final String[] drDarwin = {"Rs Cipto Mangunkusumo","Rs MMC", "Rs Al Minthohardjo"};
                    final String[] drEzra = {"Rs Hermina Tanjung Priok","Rs Mitra Keluarga", "Rs Hermina Kartini Bekasi"};
                    final String[] drDhea = {"Rs Hermina Kartini Bekasi","Rs Cipto Mangunkusumo","Hospital Tanggerang"};
                    final String[] drAustin={"Rs Pelni","Rs Hermina Tanjung Priok","Rs Cipto Mangunkusumo"};
                    final String[] drEnrico={"Rs Hermina Kartini Bekasi","Rs Cipto Mangunkusumo","Rs Pertamina"};
                    final String[] drEnrique={"Rs Al Minthohardjo","Rs Pertamina","Rs Hermina Tanjung Priok"};
                    final String[] drDaniel={"Hospital Tanggerang","Rs Pelni","Rs MMC"};

                    if(diseasetype.getText()=="Penglihatan"){
                        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Penglihatan);
                        spinner1.setAdapter(adapter);
                        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                String docSelect = Penglihatan[position];
                                if(position == 0){
                                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDarwin);
                                    spinner2.setAdapter(adapter2);
                                }
                                if(position == 1){
                                    ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drEnrique);
                                    spinner2.setAdapter(adapter22);
                                }
                                if(position == 2){
                                    ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drEnrico);
                                    spinner2.setAdapter(adapter23);
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }

                    if(diseasetype.getText()=="Kesehatan Gigi"){
                        ArrayAdapter<String> adapterfromSC2 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, Kesehatangigi );
                        spinner1.setAdapter(adapterfromSC2);

                        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                String docSelect = Kesehatangigi[position];
                                if(position == 0){
                                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDjokoSoematri);
                                    spinner2.setAdapter(adapter2);
                                }
                                if(position == 1){
                                    ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drMHidayat);
                                    spinner2.setAdapter(adapter22);
                                }
                                if(position == 2){
                                    ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drEnrico);
                                    spinner2.setAdapter(adapter23);
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }
                    if(diseasetype.getText()=="Pernafasan"){
                        ArrayAdapter<String> adapterfromSC3 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, Pernafasan );
                        spinner1.setAdapter(adapterfromSC3);

                        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                String docSelect = Pernafasan[position];
                                if(position == 0){
                                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drHarianto);
                                    spinner2.setAdapter(adapter2);
                                }
                                if(position == 1){
                                    ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drMHidayat);
                                    spinner2.setAdapter(adapter22);
                                }
                                if(position == 2){
                                    ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDhea);
                                    spinner2.setAdapter(adapter23);
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }
                    if(diseasetype.getText()=="Lambung"){
                        ArrayAdapter<String> adapterfromSC4 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, Lambung );
                        spinner1.setAdapter(adapterfromSC4);

                        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                String docSelect = Lambung[position];
                                if(position == 0){
                                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drSoetjipto);
                                    spinner2.setAdapter(adapter2);
                                }
                                if(position == 1){
                                    ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drAustin);
                                    spinner2.setAdapter(adapter22);
                                }
                                if(position == 2){
                                    ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drHarianto);
                                    spinner2.setAdapter(adapter23);
                                }
                                if(position == 3){
                                    ArrayAdapter<String> adapter24 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDjokoSoematri);
                                    spinner2.setAdapter(adapter24);
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                    }
                    if(diseasetype.getText()=="Sakit Kepala"){
                        ArrayAdapter<String> adapterfromSC5 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, SakitKepala );
                        spinner1.setAdapter(adapterfromSC5);

                        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                String docSelect = SakitKepala[position];
                                if(position == 0){
                                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDarwin);
                                    spinner2.setAdapter(adapter2);
                                }
                                if(position == 1){
                                    ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drEnrico);
                                    spinner2.setAdapter(adapter22);
                                }
                                if(position == 2){
                                    ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDhea);
                                    spinner2.setAdapter(adapter23);
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                    }
                    if(diseasetype.getText()=="Kesehatan Jantung"){
                        ArrayAdapter<String> adapterfromSC6 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, KesehatanJantung );
                        spinner1.setAdapter(adapterfromSC6);

                        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                String docSelect = KesehatanJantung[position];
                                if(position == 0){
                                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drEzra);
                                    spinner2.setAdapter(adapter2);
                                }
                                if(position == 1){
                                    ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drAustin);
                                    spinner2.setAdapter(adapter22);
                                }
                                if(position == 2){
                                    ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drEnrico);
                                    spinner2.setAdapter(adapter23);
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }
                    if(diseasetype.getText()=="Pendengaran"){
                        ArrayAdapter<String> adapterfromSC7 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, Pendengaran);
                        spinner1.setAdapter(adapterfromSC7);

                        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                String docSelect = Pendengaran[position];
                                if(position == 0){
                                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drHarianto);
                                    spinner2.setAdapter(adapter2);
                                }
                                if(position == 1){
                                    ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDhea);
                                    spinner2.setAdapter(adapter22);
                                }
                                if(position == 2){
                                    ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDaniel);
                                    spinner2.setAdapter(adapter23);
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }
                    if(diseasetype.getText()=="Tulang"){
                        ArrayAdapter<String> adapterfromSC8 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, Tulang);
                        spinner1.setAdapter(adapterfromSC8);

                        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                String docSelect = Tulang[position];
                                if(position == 0){
                                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drEzra);
                                    spinner2.setAdapter(adapter2);
                                }
                                if(position == 1){
                                    ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drEnrique);
                                    spinner2.setAdapter(adapter22);
                                }
                                if(position == 2){
                                    ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drHarianto);
                                    spinner2.setAdapter(adapter23);
                                }
                                if(position == 3){
                                    ArrayAdapter<String> adapter24 = new ArrayAdapter<String>(ShowAppointment.this, android.R.layout.simple_spinner_dropdown_item, drMHidayat);
                                    spinner2.setAdapter(adapter24);
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }




                }
            }else{
                Toast.makeText(this, "Database Not Found or Null", Toast.LENGTH_SHORT).show();
            }

        }catch(Exception e){
            Toast.makeText(this, "Failed to Show Value Error : "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void updateButton(View view){
        databaseHelper = new DatabaseHelper(this);
                Date date;
                View singlerow = getLayoutInflater().inflate(R.layout.single_row, null);

                spinner1 = (Spinner) singlerow.findViewById(R.id.spinnerDocName);
                spinner2 = (Spinner) singlerow.findViewById(R.id.spinnerHospital);
                diseasetype = (TextView) singlerow.findViewById(R.id.viewDisease);
                TextView uName = (TextView) singlerow.findViewById(R.id.viewName);
                TextView uKeluh = (TextView) singlerow.findViewById(R.id.viewNotes);

                String dValues1 = spinner1.getSelectedItem().toString();
                String dValues2 = spinner2.getSelectedItem().toString();

                //GET DATEPICKER ID
                DatePicker datePicker = (DatePicker) findViewById(R.id.tglReservasi);
                date = new Date(datePicker.getYear() - 1900, datePicker.getMonth(), datePicker.getDayOfMonth());
                String valuedate = date.toString();
                boolean isUpdated = databaseHelper.updateData(uName.getText().toString(),
                        valuedate, diseasetype.getText().toString(),
                        dValues1, dValues2,
                        uKeluh.getText().toString());
                if(isUpdated == true){
                    Toast.makeText(ShowAppointment.this, "Data Updated", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ShowAppointment.this, "Data Not Updated", Toast.LENGTH_SHORT).show();
                }

    }

}
