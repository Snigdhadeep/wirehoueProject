package com.example.wirehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Client_Home extends AppCompatActivity {

    ListView listView;

    FirebaseDatabase wirehouse_database;
    DatabaseReference wirehouse_reference;
    String userid;
    ArrayList<String> array;
    TextView txt;
    ListView lv_products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_info);
        listView=(ListView)findViewById(R.id.lv_clienthome);
        Intent i = getIntent();
        userid = i.getStringExtra("userid");


        wirehouse_database= FirebaseDatabase.getInstance();
        wirehouse_reference=wirehouse_database.getReference("Customers");



        wirehouse_reference.orderByChild("id").equalTo(userid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showdata(dataSnapshot);




            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Customer_info_Model model=new Customer_info_Model();


    }

    private void showdata(DataSnapshot dataSnapshot) {


        for(DataSnapshot ds: dataSnapshot.getChildren()){

            Customer_info_Model model=ds.getValue(Customer_info_Model.class);


            array=new ArrayList<>();
            Log.i("name",model.getName());
            array.add(model.getAddress());
            array.add(model.getCity());
            array.add(model.getPhone());
            array.add(model.getEmail());
            array.add(model.getState());
            array.add(model.getCompany());
            array.add(model.age);
            array.add(model.position);
            array.add(model.client_type);
            array.add(model.datetime);
            array.add(model.name);
            array.add(model.sex);
            ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
            listView.setAdapter(adapter);




        }

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,Cient_chooseActivity.class);
        intent.putExtra("userid",userid);
        startActivity(intent);

    }
}
