package com.example.anew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.UserInfo;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Templates;

public class busmates extends AppCompatActivity {


    TextView t1;
    ListView users;
    //List<userinfo> list;
    DatabaseReference ref;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busmates);
        users=(ListView)findViewById(R.id.userlist);
        t1=(TextView)findViewById(R.id.ch);
        final ArrayList<userinfo> list=new ArrayList<>();
//
//        ref=FirebaseDatabase.getInstance().getReference().child("USERS");
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//            if (dataSnapshot.exists()) {
//                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                       userinfo use = snapshot.getValue(userinfo.class);
//                       list.add(use);
//                    }
////                    String name1=dataSnapshot.getValue(String.class);
////                    t1.setText(name1);
////                        Toast.makeText(getApplicationContext(),name1,Toast.LENGTH_LONG).show();
//                    }
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                String err=databaseError.getMessage();
//                Toast.makeText(getApplicationContext(),err,Toast.LENGTH_LONG).show();
//            }
//        });
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        users.setAdapter(adapter);
    }

////
////        Query query = FirebaseDatabase.getInstance().getReference("USERS");
////        query.addListenerForSingleValueEvent(new ValueEventListener() {
////            @Override
////            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                if (dataSnapshot.exists()) {
////                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
////                        userinfo use = snapshot.getValue(userinfo.class);
////                        list.add(use);
////                    }
////                    adapter.notifyDataSetChanged();
////                }
////            }
////
////            @Override
////            public void onCancelled(@NonNull DatabaseError databaseError) {
////                String error =databaseError.getMessage();
////                Toast.makeText(getApplicationContext(),error,Toast.LENGTH_LONG).show();
////            }
////        });
//        users.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                String s=list.get(i);
//                Toast.makeText(getApplicationContext(),"hello"+s,Toast.LENGTH_LONG).show();
////
////                String name=user1.getFname();
////                Intent in=new Intent(getApplicationContext(),chat.class);
////                in.putExtra("name",name);
////                startActivity(in);
//            }
//        });
//
//    }
//

}