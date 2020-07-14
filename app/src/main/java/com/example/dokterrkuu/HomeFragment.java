package com.example.dokterrkuu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.dokterrkuu.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    TextView uName;
    ImageView ProfPic;

    FirebaseUser firebaseUser;
    DatabaseReference reference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.activity_main, container, false);


        final ImageView c_mata = (ImageView) rootView.findViewById(R.id.mataklik);
        ImageView c_gigi = (ImageView) rootView.findViewById(R.id.gigiklik);
        ImageView c_pernafasan = (ImageView) rootView.findViewById(R.id.pernafasanklik);
        ImageView c_pencernaan = (ImageView) rootView.findViewById(R.id.pencernaanKlik);
        ImageView c_kepala = (ImageView) rootView.findViewById(R.id.kepalaklik);
        ImageView c_jantung = (ImageView) rootView.findViewById(R.id.jantungklik);
        ImageView c_kuping = (ImageView) rootView.findViewById(R.id.kupingklik);
        ImageView c_tulang = (ImageView) rootView.findViewById(R.id.tulangklik);


        uName = rootView.findViewById(R.id.namauser);
        ProfPic = rootView.findViewById(R.id.ProfilePic);

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
                    Glide.with(getContext()).load(user.getImageURL()).into(ProfPic);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        c_mata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MataKlik = new Intent(getActivity(), PengeheliatanActivity.class);
                startActivity(MataKlik);
            }
        });


        c_gigi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GigiKlik = new Intent(getActivity(), GigiActivity.class);
                startActivity(GigiKlik);
            }
        });


        c_pernafasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PernafasanKlik = new Intent(getActivity(), PernafasanActivity.class);
                startActivity(PernafasanKlik);
            }
        });


        c_pencernaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PencernaannKlik = new Intent(getActivity(), PencernaanAcivity.class);
                startActivity(PencernaannKlik);
            }
        });


        c_kepala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent KepalaKlik = new Intent(getActivity(), KepalaActivity.class);
                startActivity(KepalaKlik);
            }
        });


        c_jantung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent JantungKlik = new Intent(getActivity(), JantungActivity.class);
                startActivity(JantungKlik);
            }
        });

        c_kuping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent KupingKlik = new Intent(getActivity(), PendengaranActivity.class);
                startActivity(KupingKlik);
            }
        });


        c_tulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TulangKlik = new Intent(getActivity(), TulangActivity.class);
                startActivity(TulangKlik);
            }
        });

    return rootView;
    }
}
