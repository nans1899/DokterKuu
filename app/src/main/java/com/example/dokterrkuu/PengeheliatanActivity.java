package com.example.dokterrkuu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PengeheliatanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengeheliatan);

        Button but1 = findViewById(R.id.janjibutt);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pengheliatan = new Intent(PengeheliatanActivity.this, DocAppointment.class);
                startActivity(pengheliatan);
            }
        });
    }
}
