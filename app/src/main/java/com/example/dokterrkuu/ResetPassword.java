package com.example.dokterrkuu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    EditText textEmail;
    Button resetButton;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        textEmail = findViewById(R.id.ResetEmail);
        resetButton = findViewById(R.id.buttonReset);

        firebaseAuth = FirebaseAuth.getInstance();

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = textEmail.getText().toString();

                if(email.equals("")){
                    Toast.makeText(ResetPassword.this, "Silahkan Masukan Email yang Bersangkutan", Toast.LENGTH_SHORT).show();
                }else{
                    firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ResetPassword.this, "An Email Has Been Sent to You Please Check The Corresponding Email", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(ResetPassword.this, LoginActivity.class));
                            }else{
                                String error = task.getException().getMessage();
                                Toast.makeText(ResetPassword.this, error, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


            }
        });



    }
}