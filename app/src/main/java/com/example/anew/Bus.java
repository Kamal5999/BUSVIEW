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

public class Bus extends AppCompatActivity implements View.OnClickListener {

    EditText fnameb,lnameb,phoneb,ageb;
    Button submitb,ignoreb;
    FirebaseAuth fh;
    DatabaseReference db;
    Button out;
    TextView tt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        submitb=(Button)findViewById(R.id.submit);
        ignoreb=(Button)findViewById(R.id.ignore);
        fnameb=(EditText)findViewById(R.id.fname);
        lnameb=(EditText)findViewById(R.id.lname);
        ageb=(EditText)findViewById(R.id.age);
        phoneb=(EditText)findViewById(R.id.phone);
        out=(Button)findViewById(R.id.signout);
        tt=(TextView)findViewById(R.id.print);
        fh=FirebaseAuth.getInstance();
        db= FirebaseDatabase.getInstance().getReference();
        if(fh.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(Bus.this,login.class));
        }
        out.setOnClickListener(this);
        ignoreb.setOnClickListener(this);
        submitb.setOnClickListener(this);

    }
    public void submit()
    {

        String phone =phoneb.getText().toString().trim();
        String age =ageb.getText().toString().trim();
        final String fname=fnameb.getText().toString().trim();
        String lname=lnameb.getText().toString().trim();
        if(TextUtils.isEmpty(phone)||TextUtils.isEmpty(age)||TextUtils.isEmpty(fname)||TextUtils.isEmpty(lname))
        {
            Toast.makeText(this,"please fill all the details",Toast.LENGTH_LONG).show();
        }
        else
        {
            FirebaseUser user=fh.getCurrentUser();
            String id=user.getUid();
            userinfo use=new userinfo(fname,age,phone,lname);
            Task task1=db.child("USERS").child(id).setValue(use);
            task1.addOnSuccessListener(new OnSuccessListener() {
                @Override
                public void onSuccess(Object o) {
                    Toast.makeText(getApplicationContext(),"SUCCESSFULLY SUBMITTED",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(getApplicationContext(),start.class);
                    i.putExtra("First",fname);
                    startActivity(i);

                }
            });
            task1.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    String error=e.getMessage();
                    Toast.makeText(getApplicationContext(), error,Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),error.class));
                }
            });
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signout:
                fh.signOut();
                finish();
                Intent in = new Intent(Bus.this, login.class);
                startActivity(in);
                break;
            case R.id.submit:
                submit();
                break;
            case R.id.ignore:
                startActivity(new Intent(this,start.class));
                break;
        }
    }
}