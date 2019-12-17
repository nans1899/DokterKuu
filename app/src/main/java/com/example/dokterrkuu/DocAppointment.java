package com.example.dokterrkuu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.DownloadManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DocAppointment extends AppCompatActivity {

    //INITIATE VARIABLES
    EditText uName;
    Button Janji;
    DatePicker datePicker;
    Spinner dropdown;
    Spinner dropdown2;
    DatabaseHelper databaseHelper;
    Date date;
    String dValues1;
    String dValues2;
    //AppointmentData appointmentData = new AppointmentData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_appointment);

        //CALLING DATABASEHELPER
        databaseHelper = new DatabaseHelper(this);

        //GET UI ID'S
        uName = (EditText) findViewById(R.id.UsernameDocAppointment);
        Janji = (Button) findViewById(R.id.JanjiButton);

        //GET SPINNER ID'S
        dropdown = findViewById(R.id.spinner1);
        dropdown2 = findViewById(R.id.spinner2);

        //GET DATEPICKER ID
        datePicker = (DatePicker) findViewById(R.id.tglReservasi);

        //GET DATEPICKER VALUES
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(day, month, year);

        //CONVERTING TO SIMPLE DATE FORMAT STRING
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String formatDate = sdf.format(calendar.getTime());

        //CONVERTING BACK TO DATE
        try {
            date = (Date) sdf.parse(formatDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //THE DOCTORS
        final String[] items = new String[]{"Prof. Dr. dr. Harianto N", "Prof. Dr. DjokoSoemantri", "Prof. Dr. M. Hidayat", "Prof. Dr. Soetjipto", "Prof. Dr. Darwin Dalimunthe"};

        //THE HOSPITALS
        final String[] drHarianto = {"Rs Cipto Mangunkusumo","Rs Al Minthohardjo","Rs MMC"};
        final String[] drDjokoSoematri = {"Rs Pertamina","Rs MMC","Hospital Tanggerang"};
        final String[] drMHidayat = {"Rs Pelni","Rs Pertamina","Rs MMC"};
        final String[] drSoetjipto = {"Rs Pelni","Rs Pertamina","Hospital Tanggerang"};
        final String[] drDarwin = {"Rs Cipto Mangunkusumo","Rs MMC", "Rs Al Minthohardjo"};

        //POPULATING FROM ARRAY DOCTORS
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        //AUTO POPULATE FROM FIRST PICK
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelect = items[position];
                if(position == 0){
                    ArrayAdapter<String> adapter1=new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drHarianto);
                    dropdown2.setAdapter(adapter1);
                }
                if(position == 1){
                    ArrayAdapter<String> adapter2=new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDjokoSoematri);
                    dropdown2.setAdapter(adapter2);
                }
                if(position == 2){
                    ArrayAdapter<String> adapter3=new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drMHidayat);
                    dropdown2.setAdapter(adapter3);
                }
                if(position == 3){
                    ArrayAdapter<String> adapter4=new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drSoetjipto);
                    dropdown2.setAdapter(adapter4);
                }
                if(position == 4){
                    ArrayAdapter<String> adapter5=new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDarwin);
                    dropdown2.setAdapter(adapter5);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //GET DROPDOWN VALUES
        dValues1 = dropdown.getSelectedItem().toString();
        dValues2 = dropdown2.getSelectedItem().toString();

        //METHOD FOR APPOINTMENT BUTTON
        AddData();

    }



    public void AddData(){
        Janji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = databaseHelper.insertData(uName.getText().toString(), date, dValues1, dValues2 );

                if(isInserted =true){
                    Toast.makeText(DocAppointment.this, "Data Successfuly Inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(DocAppointment.this, "Failed Inserting The Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //INI YANG MANUAL MASUKINNYA DI ONCREATE HARUSNYA
        /*
        String[] items2 = new String[]{"Rs MMC", "Rs Pertamina", "Rs Cipto Mangunkusumo", "Rs AL Minthohardjo", "Rs Pelni"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);
        */

}
