package com.namy86.dtu_saforum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    ArrayList<String> list=new ArrayList<>();
    ArrayAdapter<String> adapter;
    DatabaseReference dref;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        final ArrayList<Word> words = new ArrayList<Word>();

//        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list);
//        listView.setAdapter(adapter);
        dref= FirebaseDatabase.getInstance().getReference();

        final WordAdapter1 adapter = new WordAdapter1(this, words, R.color.background_light);
        dref.addChildEventListener(new ChildEventListener() {
            String[] value = new String[100];
            @Override

            public void onChildAdded(com.google.firebase.database.DataSnapshot dataSnapshot, String s) {
                value[i] = dataSnapshot.getValue(String.class);

                i++;
                if (i == 2) {

                    words.add(new Word(value[0], value[1], R.drawable.l3));
                    listView.setAdapter(adapter);
                    i=0;
                }
            }
            @Override
            public void onChildChanged(com.google.firebase.database.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(com.google.firebase.database.DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(com.google.firebase.database.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
