package com.example.dokterrkuu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    EditText user,pass;
    Button log;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText) findViewById(R.id.Username);
        pass = (EditText) findViewById(R.id.Password);
        log = (Button) findViewById(R.id.LogButt);
        firebaseAuth = FirebaseAuth.getInstance();


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final String username = user.getText().toString();
                String password = pass.getText().toString();

                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                    user.setError("Please Fill The Empty Field(s) !!");
                    return;
                }




                    //AUTHENTICATION FIREBASE AUTO

                    firebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent (LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(LoginActivity.this, "Username Not Exist OR Wrong Credentials", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



            }
        });

    }
}
