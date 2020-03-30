package com.example.dokterrkuu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

//    EditText user,pass;
//    Button log;
//    FirebaseAuth firebaseAuth;
    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText)findViewById(R.id.Username);
        Password = (EditText)findViewById(R.id.Password);
        Login = (Button)findViewById(R.id.LogButt);
        Signup = (TextView)findViewById(R.id.Signuptext);



        Login.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Validate(Name.getText().toString(), Password.getText().toString());
            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Pindah = new Intent (LoginActivity.this, activity_signinup.class);
                startActivity(Pindah);
            }
        });


    }

    private void Validate(String userName, String userPassword)
    {
        if( (userName.equals("Ananda Bakti")) && (userPassword.equals("1234")))
        {
            Intent intent = new Intent(LoginActivity.this, ActivityUtama.class);
            startActivity(intent);
        }
        else if(userName.equals("") || userPassword.equals("")){
            Toast.makeText(this, "Username or Password Cannot Be Empty !", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast.makeText(this, "Username or Password is wrong", Toast.LENGTH_SHORT).show();
        }
   }
}
