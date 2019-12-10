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

public class LoginActivity extends AppCompatActivity {

    EditText user,pass;
    Button log;
    FirebaseAuth firebaseAuth;
    Intent intent = new Intent(this, MainActivity.class);
    public static final String EXTRA_TEXT ="com.example.dokterrkuu.EXTRA_TEXT";


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

                //AUTHENTICATION

                firebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            intent.putExtra(EXTRA_TEXT, username);
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
