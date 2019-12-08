package com.example.wirehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ClientInfo extends AppCompatActivity {

    FirebaseDatabase wirehouse_database;
    DatabaseReference wirehouse_reference;
    RecyclerView recyclerView;
    TextView pallet_number,client_type,date_of_entry,product_name,date_of_delivery,date,location_type, customer_name,
            location_name,product_type,pallet_type,pallet_name,company_name;

    String ref_key;
    String easyPuzzle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_client_info);


        Intent i = getIntent();
        easyPuzzle = i.getStringExtra("puzzle2");
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);




/*        pallet_number = (TextView)findViewById(R.id.pallet_number);
        client_type = (TextView)findViewById(R.id.client_type);
        date_of_entry = (TextView)findViewById(R.id.date_of_entry);
        product_name = (TextView)findViewById(R.id.product_name);
        date_of_delivery = (TextView)findViewById(R.id.date_of_delivery);
        date = (TextView)findViewById(R.id.date);
        location_type = (TextView)findViewById(R.id.location_type);
        customer_name = (TextView)findViewById(R.id.customer_name);
        location_name = (TextView)findViewById(R.id.location_name);
        product_type = (TextView)findViewById(R.id.product_type);
        pallet_type = (TextView)findViewById(R.id.pallet_type);
        pallet_name = (TextView)findViewById(R.id.pallet_name);
        company_name = (TextView)findViewById(R.id.company_name);*/


        wirehouse_database=FirebaseDatabase.getInstance();
        wirehouse_reference=wirehouse_database.getReference("Products");
        Log.i("ref",wirehouse_reference.toString());
        wirehouse_reference.orderByChild("client_name").equalTo(easyPuzzle).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (final DataSnapshot child : dataSnapshot.getChildren()) {

                    Log.i("User key", child.getKey());
                    Log.i("User ref", child.getRef().toString());
                    Log.i("User val", child.getValue().toString());
                    String key=child.getKey();




                    Model2 model2 = child.getValue(Model2.class);


                    client_type.setText(model2.client_type);
                    date_of_entry.setText(model2.entry_date);
                    product_name.setText(model2.product_name);
                    date_of_delivery.setText(model2.delivery_date);
                    pallet_number.setText(model2.pallet_no);
                    date.setText(model2.datetime);
                    location_type.setText(model2.location_type);
                    customer_name.setText(model2.client_name);
                    location_name.setText(model2.location_name);
                    product_type.setText(model2.product_type);
                    pallet_type.setText(model2.pallet_type);
                    pallet_name.setText(model2.pallet_name);
                    company_name.setText(model2.company_name);


                    Log.i("value", model2.getCompany_name());


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ClientInfo.this, "please check the pallet number you have enterd", Toast.LENGTH_SHORT).show();
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
