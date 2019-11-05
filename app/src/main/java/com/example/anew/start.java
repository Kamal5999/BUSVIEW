package com.example.anew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class start extends AppCompatActivity implements View.OnClickListener{

    FirebaseAuth fh;
    DatabaseReference fb;

    EditText busno;
    Button enter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        fh=FirebaseAuth.getInstance();
        fb=FirebaseDatabase.getInstance().getReference();
        enter=(Button)findViewById(R.id.enter);
        busno=(EditText)findViewById(R.id.busno);
        if(fh.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this,login.class));
        }
        enter.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String no=busno.getText().toString();
        FirebaseUser fu=fh.getCurrentUser();
        String id=fu.getUid();
        Task t1=fb.child("USERS").child(id).child("bus_no").setValue(no);
        t1.addOnSuccessListener(new OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
                Toast.makeText(getApplicationContext(),"welcome buddy",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),option.class));
            }
        });
        t1.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                String error =e.getMessage();
                Toast.makeText(getApplicationContext(),"error: "+error,Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),error.class));
            }
        });
    }
}
