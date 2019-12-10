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

        Intent intent = getIntent();
        String userwelcome= intent.getStringExtra(LoginActivity.EXTRA_TEXT);
        TextView viewuser = (TextView) findViewById(R.id.txtdashboard);
        viewuser.setText(userwelcome);


        c_mata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MataKlik = new Intent (MainActivity.this, SecondActivity.class);
                startActivity(MataKlik);
            }
        });

    }
}
