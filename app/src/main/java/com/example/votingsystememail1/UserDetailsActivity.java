package com.example.votingsystememail1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDetailsActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private EditText identify;

    private DatabaseReference mDatabase;
  String email;
   String name;
   String phone;
   String id;
    DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference().child("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);
        // Add this line before mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
// Get the Firebase instance
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

// Get a reference to the "users" node in the database
        mDatabase = firebaseDatabase.getReference("users");

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        identify=findViewById(R.id.identify);
        Button buttonSave = findViewById(R.id.buttonSave);


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserDetails();
            }
        });
    }

    private void saveUserDetails() {
         name = editTextName.getText().toString().trim();
         email = editTextEmail.getText().toString().trim();
       phone=editTextPhone.getText().toString().trim();
       id=identify.getText().toString().trim();
        Pattern pattern = Pattern.compile( "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
        Matcher matcher=pattern.matcher(email);
        Pattern pat1=Pattern.compile("B\\d{2}/20");
        Matcher mat1= pat1.matcher(id);
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
        } else if (phone.length()!=10) {
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();

        } else if (!matcher.matches()) {
            Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show();

        }
        else if (!mat1.matches()) {
            Toast.makeText(this, "Please enter a valid id card number", Toast.LENGTH_SHORT).show();

        }
        else {
            Intent intent= new Intent(UserDetailsActivity.this,votingpage.class);
            intent.putExtra("name",name);
            intent.putExtra("phone",phone);
            intent.putExtra("email",email);
            intent.putExtra("id",id);

            startActivity(intent);
        }
    }


    }

