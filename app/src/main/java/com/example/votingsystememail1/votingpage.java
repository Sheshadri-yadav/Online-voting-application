package com.example.votingsystememail1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class votingpage extends AppCompatActivity {
String name,email,phone, identity;
Button save;
String vote;

// Get a reference to the "users" node in the database
  
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votingpage);
        RadioButton option1RadioButton = findViewById(R.id.option1RadioButton);
        RadioButton option2RadioButton = findViewById(R.id.option2RadioButton);
        RadioButton option3RadioButton = findViewById(R.id.option3RadioButton);
        RadioButton option4RadioButton = findViewById(R.id.option4RadioButton);
        name=getIntent().getStringExtra("name");
        phone=getIntent().getStringExtra("phone");
        email=getIntent().getStringExtra("email");
        identity=getIntent().getStringExtra("id");

        save=findViewById(R.id.voteButton);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mDatabase = firebaseDatabase.getReference("users");
        option1RadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (option1RadioButton.isChecked()) {

                    vote="Candidate 1";
                }
            }
        });

        option2RadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (option2RadioButton.isChecked()) {
                    vote="Candidate 2 ";
                }
            }
        });

        option3RadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (option3RadioButton.isChecked()) {

                    vote="Candidate 3";
                }
            }
        });

        option4RadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (option4RadioButton.isChecked()) {
                    vote="Candidate 4";
                }
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                insertuserdata(name,email,phone,vote,identity);
                Toast.makeText(votingpage.this, "You have voted for "+vote, Toast.LENGTH_SHORT).show();
                Intent next = new Intent(votingpage.this,thanks.class);
                startActivity(next);
                finish();
            }
        });
    }
    private void insertuserdata( String name, String email,String phone,String vote,String identity){
        users user= new users(name,email,phone,vote,identity);
        databaseReference.push().setValue(user);
    }
}