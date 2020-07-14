package com.example.dokterrkuu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dokterrkuu.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    TextView uName;
    ImageView ProfPic;

    FirebaseUser firebaseUser;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView c_mata = findViewById(R.id.mataklik);
        ImageView c_gigi = findViewById(R.id.gigiklik);
        ImageView c_pernafasan = findViewById(R.id.pernafasanklik);
        ImageView c_pencernaan = findViewById(R.id.pencernaanKlik);
        ImageView c_kepala = findViewById(R.id.kepalaklik);
        ImageView c_jantung = findViewById(R.id.jantungklik);
        ImageView c_kuping = findViewById(R.id.kupingklik);
        ImageView c_tulang = findViewById(R.id.tulangklik);


        uName = findViewById(R.id.namauser);
        ProfPic = findViewById(R.id.ProfilePic);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                uName.setText(user.getUsername());
                if(user.getImageURL().equals("default")){
                    ProfPic.setImageResource(R.mipmap.ic_default_pic);
                }else{
                    Glide.with(getApplicationContext()).load(user.getImageURL()).into(ProfPic);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



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



        c_pencernaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PencernaannKlik = new Intent (MainActivity.this, PencernaanAcivity.class);
                startActivity(PencernaannKlik);
            }
        });


        c_kepala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent KepalaKlik = new Intent (MainActivity.this, KepalaActivity.class);
                startActivity(KepalaKlik);
            }
        });



        c_jantung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent JantungKlik = new Intent (MainActivity.this, JantungActivity.class);
                startActivity(JantungKlik);
            }
        });

        c_kuping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent KupingKlik = new Intent (MainActivity.this, PendengaranActivity.class);
                startActivity(KupingKlik);
            }
        });


        c_tulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TulangKlik = new Intent (MainActivity.this, TulangActivity.class);
                startActivity(TulangKlik);
            }
        });

    }
}
