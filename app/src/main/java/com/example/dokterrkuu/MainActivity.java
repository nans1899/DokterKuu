package com.example.dokterrkuu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView c_mata = findViewById(R.id.mataklik);
        ImageView c_gigi = findViewById(R.id.gigiklik);
        ImageView c_pernafasan = findViewById(R.id.pernafasanklik);




        c_mata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MataKlik = new Intent (MainActivity.this, PengeheliatanActivity.class);
                startActivity(MataKlik);
            }
        });



        c_gigi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GigiKlik = new Intent (MainActivity.this, GigiActivity.class);
                startActivity(GigiKlik);
            }
        });


        c_pernafasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PernafasanKlik = new Intent (MainActivity.this, PernafasanActivity.class);
                startActivity(PernafasanKlik);
            }
        });

    }
}
