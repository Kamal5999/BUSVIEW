package com.example.anew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class next extends AppCompatActivity implements View.OnClickListener {


    Button out;
    TextView info,sec;
    FirebaseAuth fh;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        out=(Button)findViewById(R.id.signout);
        info=(TextView)findViewById(R.id.info);
        sec=(TextView)findViewById(R.id.sec);
        fh=FirebaseAuth.getInstance();
        db= FirebaseDatabase.getInstance().getReference();
        out.setOnClickListener(this);
        FirebaseUser fu = fh.getCurrentUser();
        String id=fu.getUid();
        db.child("USERS").child("id").child("fname");
    }

    @Override
    public void onClick(View view) {
        FirebaseUser user=fh.getCurrentUser();
        info.setText(user.getEmail().toString());
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String st=dataSnapshot.getValue(String.class);
                sec.setText(st);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        fh.signOut();
        startActivity(new Intent(this,login.class));
        finish();


    }
}
