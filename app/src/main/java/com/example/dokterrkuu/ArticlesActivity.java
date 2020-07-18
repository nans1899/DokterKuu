package com.example.dokterrkuu;

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
import com.example.dokterrkuu.Model.Articles;
import com.example.dokterrkuu.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ArticlesActivity extends Fragment {

    TextView Judul_Artikel, Preview_Artikel, Judul_Artikel1, Preview_Artikel1, Judul_Artikel2, Preview_Artikel2, Judul_Artikel3, Preview_Artikel3, Judul_Artikel4, Preview_Artikel4;
    ImageView Foto_Artikel, Foto_Artikel1, Foto_Artikel2, Foto_Artikel3, Foto_Artikel4;
    FirebaseUser firebaseUser;
    DatabaseReference databaseReference;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_articles,container, false);

        Foto_Artikel = view.findViewById(R.id.articleimage);
        Judul_Artikel = view.findViewById(R.id.judulartikel);
        Preview_Artikel = view.findViewById(R.id.isiartikel);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Artikel").child("0");


        databaseReference.addValueEventListener(new ValueEventListener() {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Artikel").child("0");
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Articles article = dataSnapshot.getValue(Articles.class);
                String value = dataSnapshot.getValue().toString();
                Articles appData = dataSnapshot.getValue(Articles.class);
                    Glide.with(getContext()).load(article.getFoto_Artikel()).into(Foto_Artikel);
                    Judul_Artikel.setText(appData.getJudul_Artikel());
                    Preview_Artikel.setText(appData.getPreview_Artikel());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Foto_Artikel1 = view.findViewById(R.id.articleimage1);
        Judul_Artikel1 = view.findViewById(R.id.judulartikel1);
        Preview_Artikel1 = view.findViewById(R.id.isiartikel1);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Artikel").child("1");


        databaseReference.addValueEventListener(new ValueEventListener() {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Artikel").child("1");
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Articles article = dataSnapshot.getValue(Articles.class);
                String value = dataSnapshot.getValue().toString();
                Articles appData = dataSnapshot.getValue(Articles.class);
                Glide.with(getContext()).load(article.getFoto_Artikel()).into(Foto_Artikel1);
                Judul_Artikel1.setText(appData.getJudul_Artikel());
                Preview_Artikel1.setText(appData.getPreview_Artikel());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Foto_Artikel2 = view.findViewById(R.id.articleimage2);
        Judul_Artikel2 = view.findViewById(R.id.judulartikel2);
        Preview_Artikel2 = view.findViewById(R.id.isiartikel2);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Artikel").child("2");


        databaseReference.addValueEventListener(new ValueEventListener() {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Artikel").child("2");
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Articles article = dataSnapshot.getValue(Articles.class);
                String value = dataSnapshot.getValue().toString();
                Articles appData = dataSnapshot.getValue(Articles.class);
                Glide.with(getContext()).load(article.getFoto_Artikel()).into(Foto_Artikel2);
                Judul_Artikel2.setText(appData.getJudul_Artikel());
                Preview_Artikel2.setText(appData.getPreview_Artikel());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Foto_Artikel3 = view.findViewById(R.id.articleimage3);
        Judul_Artikel3 = view.findViewById(R.id.judulartikel3);
        Preview_Artikel3 = view.findViewById(R.id.isiartikel3);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Artikel").child("3");


        databaseReference.addValueEventListener(new ValueEventListener() {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Artikel").child("3");
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Articles article = dataSnapshot.getValue(Articles.class);
                String value = dataSnapshot.getValue().toString();
                Articles appData = dataSnapshot.getValue(Articles.class);
                Glide.with(getContext()).load(article.getFoto_Artikel()).into(Foto_Artikel3);
                Judul_Artikel3.setText(appData.getJudul_Artikel());
                Preview_Artikel3.setText(appData.getPreview_Artikel());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Foto_Artikel4 = view.findViewById(R.id.articleimage4);
        Judul_Artikel4 = view.findViewById(R.id.judulartikel4);
        Preview_Artikel4 = view.findViewById(R.id.isiartikel4);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Artikel").child("4");


        databaseReference.addValueEventListener(new ValueEventListener() {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Artikel").child("4");
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Articles article = dataSnapshot.getValue(Articles.class);
                String value = dataSnapshot.getValue().toString();
                Articles appData = dataSnapshot.getValue(Articles.class);
                Glide.with(getContext()).load(article.getFoto_Artikel()).into(Foto_Artikel4);
                Judul_Artikel4.setText(appData.getJudul_Artikel());
                Preview_Artikel4.setText(appData.getPreview_Artikel());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }


}