package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class option extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth fh;
    Button b1,b2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        b1=(Button)findViewById(R.id.bmate);
        b2= (Button)findViewById(R.id.friends);
        fh=FirebaseAuth.getInstance();
        if(fh.getCurrentUser()==null)
            startActivity(new Intent(this,login.class));
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.bmate:
                startActivity(new Intent(this,next.class));
                break;
            case R.id.friends:
                startActivity(new Intent(this,next.class));
                break;
        }
    }
}
