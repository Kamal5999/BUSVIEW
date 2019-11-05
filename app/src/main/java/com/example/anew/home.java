package com.example.anew;

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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class home extends AppCompatActivity   {


    EditText bus;
    Button b;
    DatabaseReference db;
    FirebaseAuth fh;

    //    String fname;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

////
////        Bundle val=getIntent().getExtras();
////        fname=val.getString("first");
//      bus=(EditText)findViewById(R.id.bus_no);
//        b=(Button)findViewById(R.id.sub);
//        fh=FirebaseAuth.getInstance();
//        if(fh.getCurrentUser()==null)
//            startActivity(new Intent(this,login.class));
//        b.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View view) {
//        String no;
//        no = bus.getText().toString();
//        Toast.makeText(this,no,Toast.LENGTH_LONG).show();
////
////        FirebaseUser fu = fh.getCurrentUser();
////
////        String id = fu.getUid();
////        db = FirebaseDatabase.getInstance().getReference();
////        if(TextUtils.isEmpty(no))
////        {
////            Toast.makeText(this,"Please Enter the correct value",Toast.LENGTH_LONG).show();
////        }
////        else
////        {
//////        Task t1 = db.child("USERS").child(id).child("bus_no").setValue(no);
//////        t1.addOnSuccessListener(new OnSuccessListener() {
//////            @Override
//////            public void onSuccess(Object o) {
//////                Toast.makeText(getApplicationContext(), "Successfully Submitted", Toast.LENGTH_LONG).show();
//////                startActivity(new Intent(getApplicationContext(), option.class));
//////                finish();
//////            }
//////        });
//////        t1.addOnFailureListener(new OnFailureListener() {
//////            public void onFailure(@NonNull Exception e) {
//////                String errorMessage = e.getMessage();
//////                Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
//////                startActivity(new Intent(getApplicationContext(), error.class));
//////                finish();
//////            }
//////        });
////            Toast.makeText(this,"ALRIGHT",Toast.LENGTH_LONG).show();
////    }
//
//    }
    }
}
