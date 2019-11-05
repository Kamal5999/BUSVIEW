package com.example.anew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class register extends AppCompatActivity  implements View.OnClickListener{

    //DatabaseReference db;
    Button registerb,back;
    EditText passwordb,emailb;
    private ProgressDialog progressd;
    private FirebaseAuth fh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fh= FirebaseAuth.getInstance();

        progressd = new ProgressDialog(this);
        back =(Button) findViewById(R.id.back);
        registerb =(Button) findViewById(R.id.sign_up);
        passwordb =(EditText) findViewById(R.id.password);
        emailb = (EditText) findViewById(R.id.email);
        registerb.setOnClickListener(this);
        //db= FirebaseDatabase.getInstance().getReference();
        progressd =new ProgressDialog(this);
        registeru();
    }

    public void registeru()
    {

        String email=emailb.getText().toString();
        String password=passwordb.getText().toString();
        //saveinfo(fname,lname,email,phone);
        if(TextUtils.isEmpty(email)||TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"please fill all the details",Toast.LENGTH_LONG).show();
        }
        else
        {
            progressd.setMessage("Registering the User");
            progressd.show();
            fh.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressd.dismiss();
                    if (task.isSuccessful()) {
                        Toast.makeText(register.this, "registered", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(),Bus.class));
                    } else
                    {
                        Toast.makeText(register.this, "not registered", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
    public void saveinfo(String fname,String lname,String email,String phone)
    {
        //userinfo use=new userinfo(fname,email,phone,lname);
        //String id=db.push().getKey();
        //db.child(id).setValue(use);
    }
    private void checking()
    {

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                startActivity(new Intent(this, login.class));
                break;
            case R.id.sign_up:
                registeru();
                break;
        }

    }
}