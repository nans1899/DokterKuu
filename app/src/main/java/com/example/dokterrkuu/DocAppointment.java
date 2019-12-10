package com.example.dokterrkuu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DocAppointment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_appointment);


        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Prof. Dr. dr. Harianto N", "Prof. Dr. DjokoSoemantri", "Prof. Dr. M. Hidayat", "Prof. Dr. Soetjipto", "Prof. Dr. Darwin Dalimunthe"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


        Spinner dropdown2 = findViewById(R.id.spinner2);
        String[] items2 = new String[]{"Rs MMC", "Rs Pertamina", "Rs Cipto Mangunkusumo", "Rs AL Minthohardjo", "Rs Pelni"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);



    }




}
