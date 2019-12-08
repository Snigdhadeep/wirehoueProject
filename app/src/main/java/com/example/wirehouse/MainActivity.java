package com.example.wirehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase wirehouse_database;
    DatabaseReference wirehouse_reference;
    RecyclerView recyclerView;
   /* TextView pallet_number,client_type,date_of_entry,product_name,date_of_delivery,date,location_type, customer_name,
            location_name,product_type,pallet_type,pallet_name,company_name;*/

     TextView pallet_no, client_id, client_name,client_type,company_name,current_timeval,datetime,delivery_date,entry_date,
            id,load_number,location_name,location_type,pallet_name,pallet_type,product_name,product_type,storage_charge,user_data,
            weekly_charge,weekly_count;

   String ref_key;
   String easyPuzzle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        Intent i = getIntent();
        easyPuzzle = i.getStringExtra("puzzle");
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);




        pallet_no = (TextView)findViewById(R.id.pallet_no);
        client_id = (TextView)findViewById(R.id.client_id);
        client_name = (TextView)findViewById(R.id.client_name);
        client_type = (TextView)findViewById(R.id.client_type);
        current_timeval = (TextView)findViewById(R.id.current_timeval);
        datetime = (TextView)findViewById(R.id.datetime);
        delivery_date = (TextView)findViewById(R.id.delivery_date);
        entry_date = (TextView)findViewById(R.id.entry_date);
        id = (TextView)findViewById(R.id.id);
        load_number = (TextView)findViewById(R.id.load_number);
        location_name = (TextView)findViewById(R.id.location_name);
        location_type = (TextView)findViewById(R.id.location_type);
        pallet_name = (TextView)findViewById(R.id.pallet_name);

        pallet_type = (TextView)findViewById(R.id.pallet_type);
        product_name = (TextView)findViewById(R.id.product_name);
        product_type = (TextView)findViewById(R.id.product_type);
        storage_charge = (TextView)findViewById(R.id.storage_charge);
        user_data = (TextView)findViewById(R.id.user_data);
        weekly_charge = (TextView)findViewById(R.id.weekly_charge);
        weekly_count = (TextView)findViewById(R.id.weekly_count);


        wirehouse_database=FirebaseDatabase.getInstance();
        wirehouse_reference=wirehouse_database.getReference("Products");
        Log.i("ref",wirehouse_reference.toString());
    wirehouse_reference.orderByChild("pallet_no").equalTo(easyPuzzle).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               for (final DataSnapshot child : dataSnapshot.getChildren()) {

                    Log.i("User key", child.getKey());
                    Log.i("User ref", child.getRef().toString());
                    Log.i("User val", child.getValue().toString());
                    String key=child.getKey();




                        Model2 model2 = child.getValue(Model2.class);
                        Log.i("palletno",model2.pallet_name);
                    pallet_no.setText(model2.pallet_no);
                    client_id.setText(model2.client_id);
                    client_name.setText(model2.client_name);
                    client_type.setText(model2.client_type);
                    current_timeval.setText(model2.current_timeval);
                    datetime.setText(model2.datetime);
                    delivery_date.setText(model2.delivery_date);
                    entry_date.setText(model2.entry_date);
                    id.setText(model2.id);
                    load_number.setText(model2.load_number);
                    location_name.setText(model2.location_name);
                    location_type.setText(model2.location_type);
                    pallet_name.setText(model2.pallet_name);

                    pallet_type.setText(model2.pallet_type);
                    product_name.setText(model2.product_name);
                    product_type.setText(model2.product_type);
                    storage_charge.setText(model2.storage_charge);

                    user_data.setText(model2.user_data);
                    weekly_charge.setText(model2.weekly_charge);
                    weekly_count.setText(model2.weekly_count);

                        Log.i("value", model2.getCompany_name());


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "please check the pallet number you have enterd", Toast.LENGTH_SHORT).show();
            }
        });

       // Log.i("datas",wirehouse_reference.toString());
    }




    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
        Intent setIntent = new Intent(this,Home.class);
        startActivity(setIntent);
    }


}
