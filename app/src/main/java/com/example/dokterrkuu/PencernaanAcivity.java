package com.example.dokterrkuu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PencernaanAcivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencernaan_acivity);
        Button btn1 = findViewById(R.id.janjipencernaan);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PencernaanAcivity.this, DocAppointment.class);
                startActivity(intent);
            }
        });
    }
}
