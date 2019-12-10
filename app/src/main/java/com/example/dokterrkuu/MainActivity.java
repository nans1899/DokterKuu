package com.example.dokterrkuu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    TextView userdash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Intent intent = getIntent();

    String getUser = intent.getStringExtra(LoginActivity.EXTRA_TEXT);

    userdash = (TextView)findViewById(R.id.txtdashboard);

    userdash.setText(getUser);


        ImageView c_mata = findViewById(R.id.mataklik);

        c_mata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MataKlik = new Intent (MainActivity.this, SecondActivity.class);
                startActivity(MataKlik);
            }
        });

    }
}
