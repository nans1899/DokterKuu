package com.example.dokterrkuu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.dokterrkuu.Model.AppointmentData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CurrentAppointment extends Fragment {


    TextView nama,penyakit,rumahsakit,dokter,tanggal;
    FirebaseUser firebaseUser;
    DatabaseReference databaseReference;

    Button ubahbutton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_current_appointment,container, false);


        nama = view.findViewById(R.id.username);
        penyakit = view.findViewById(R.id.userdisease);
        rumahsakit = view.findViewById(R.id.selectedhospital);
        dokter = view.findViewById(R.id.selecteddoc);
        tanggal = view.findViewById(R.id.selecteddate);
        ubahbutton = view.findViewById(R.id.UbahJanji);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Appointments").child(firebaseUser.getUid());

        final String userid = firebaseUser.getUid();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                AppointmentData appData = dataSnapshot.getValue(AppointmentData.class);
                if(userid == null){
                    nama.setText("Belum Membuat Janji");
                    penyakit.setText("Belum Membuat Janji");
                    rumahsakit.setText("Belum Membuat Janji");
                    dokter.setText("Belum Membuat Janji");
                    tanggal.setText("Belum Membuat Janji");
                }else{
                    nama.setText(appData.getUsername());
                    penyakit.setText(appData.getDisease());
                    rumahsakit.setText(appData.getHospital());
                    dokter.setText(appData.getDoctor());
                    tanggal.setText(appData.getDate());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ubahbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DocAppointment.class);
                startActivity(intent);
            }
        });


        return view;
    }




}