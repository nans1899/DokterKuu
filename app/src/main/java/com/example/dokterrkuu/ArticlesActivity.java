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

    TextView Judul_Artikel, Preview_Artikel;
    ImageView Foto_Artikel;
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
        return view;
    }


}