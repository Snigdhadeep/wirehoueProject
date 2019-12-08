package com.example.wirehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ProductsActivity extends AppCompatActivity {

    FirebaseDatabase wirehouse_database;
    DatabaseReference wirehouse_reference;
    String userid;
    ListView lv_products;
    RecyclerView recyclerview;
    FirebaseRecyclerAdapter<Model, MyListAdapter.ViewHolder3> adapter;
    List<Model2> modelclasslist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        //lv_products=(ListView)findViewById(R.id.lv_products);
      //recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        wirehouse_database = FirebaseDatabase.getInstance();
        wirehouse_reference = wirehouse_database.getReference("Products");
        Intent i = getIntent();
        userid = i.getStringExtra("userid");
        modelclasslist=new ArrayList<>();


        wirehouse_reference.orderByChild("id").equalTo(userid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showdata(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void showdata(DataSnapshot dataSnapshot) {

        ArrayList<String> names= new ArrayList<>();
        ArrayList<String> pallet_nos= new ArrayList<>();
        ArrayList<String> client_types= new ArrayList<>();
        ArrayList<String> current_timevals= new ArrayList<>();
        ArrayList<String> datetimes= new ArrayList<>();
        ArrayList<String> delivery_dates= new ArrayList<>();
        ArrayList<String> entry_dates= new ArrayList<>();
        ArrayList<String> load_numbers= new ArrayList<>();
        ArrayList<String> location_names= new ArrayList<>();

        for(DataSnapshot ds: dataSnapshot.getChildren()) {

            Log.i("data1", dataSnapshot.getValue().toString());


            ArrayList<String> array = new ArrayList<>();

         /*   Log.i("palletno", model2.pallet_name);
            array.add(model2.pallet_no);
            array.add(model2.client_id);
            array.add(model2.client_name);
            array.add(model2.client_type);
            array.add(model2.current_timeval);
            array.add(model2.datetime);
            array.add(model2.delivery_date);
            array.add(model2.);
            array.add(model2.id);entry_date
            array.add(model2.load_number);
            array.add(model2.location_name);
            array.add(model2.location_type);
            array.add(model2.pallet_name);

            array.add(model2.pallet_type);
            array.add(model2.product_name);
            array.add(model2.product_type);
            array.add(model2.storage_charge);

            array.add(model2.user_data);
            array.add(model2.weekly_charge);
            array.add(model2.weekly_count);*/
           /* ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, array);
            lv_products.setAdapter(adapter);*/
/*            public String pallet_no, client_id, client_name,client_type,company_name,current_timeval,datetime,delivery_date,entry_date,
                    id,load_number,location_name,location_type,pallet_name,pallet_type,product_name,product_type,storage_charge,user_data,
                    weekly_charge,weekly_count;*/


            String name = ds.child("pallet_name").getValue(String.class);
            String pallet_no2 = ds.child("pallet_no").getValue(String.class);
            String client_type2 = ds.child("client_type").getValue(String.class);
            String current_timeval2 = ds.child("current_timeval").getValue(String.class);
            String datetime2 = ds.child("datetime").getValue(String.class);
            String delivery_date2 = ds.child("delivery_date").getValue(String.class);
            String entry_date2 = ds.child("entry_date").getValue(String.class);
            String load_number2 = ds.child("load_number").getValue(String.class);
            String location_name2 = ds.child("location_name").getValue(String.class);
           /* String name = ds.child("pallet_name").getValue(String.class);
            String name = ds.child("pallet_name").getValue(String.class);
            String name = ds.child("pallet_name").getValue(String.class);
            String name = ds.child("pallet_name").getValue(String.class);
            String name = ds.child("pallet_name").getValue(String.class);
            String name = ds.child("pallet_name").getValue(String.class);
            String name = ds.child("pallet_name").getValue(String.class);
            String name = ds.child("pallet_name").getValue(String.class);
            String name = ds.child("pallet_name").getValue(String.class);
            String name = ds.child("pallet_name").getValue(String.class);
            String name = ds.child("pallet_name").getValue(String.class);
            String name = ds.child("pallet_name").getValue(String.class);*/

            names.add(name);
            client_types.add(client_type2);
            current_timevals.add(current_timeval2);
            datetimes.add(datetime2);
            delivery_dates.add(delivery_date2);







//         Log.i("model1",modelclasslist.get(1).pallet_name);

        /*    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerview.setLayoutManager(linearLayoutManager);

            MyListAdapter adapter=new MyListAdapter(modelclasslist);
            Model2 model2 = ds.getValue(Model2.class);
            recyclerview.setAdapter(adapter);
            modelclasslist.add(new Model2(model2.pallet_name,model2.pallet_name,
                    model2.pallet_name,model2.pallet_name,model2.pallet_name,
                    model2.pallet_name,
                    model2.datetime,model2.datetime,
                    model2.datetime,model2.datetime,model2.datetime,
                    model2.datetime,model2.datetime,model2.datetime,model2.datetime,model2.client_name,
                    model2.client_name,model2.client_name,model2.client_name,model2.client_name,model2.client_name


            ));

            Log.i("now",model2.pallet_name);
            Log.i("now","ok");

            adapter.notifyDataSetChanged();*/
        }
        for(String name : names) {

            TextView stringTextView = (TextView) findViewById(R.id.string_text_view);
            View view=(View)findViewById(R.id.view1);
            stringTextView.setText(stringTextView.getText().toString() + name+"\n" );
            stringTextView.setPaintFlags(stringTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        }
        for(String client_type2 : client_types) {
            TextView stringTextView2 = (TextView) findViewById(R.id.string_text_view2);
            stringTextView2.setText(stringTextView2.getText().toString() + client_type2+"\n");
            stringTextView2.setPaintFlags(stringTextView2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        }

        for(String current_timeval2 : current_timevals) {
            TextView stringTextView3 = (TextView) findViewById(R.id.string_text_view3);
            stringTextView3.setText(stringTextView3.getText().toString() + current_timeval2+"\n");
            stringTextView3.setPaintFlags(stringTextView3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        }
        for(String datetime2 : datetimes) {
            TextView stringTextView4 = (TextView) findViewById(R.id.string_text_view4);
            stringTextView4.setText(stringTextView4.getText().toString() + datetime2+"\n");
            stringTextView4.setPaintFlags(stringTextView4.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        }

        for(String delivery_date2 : delivery_dates) {
            TextView stringTextView5 = (TextView) findViewById(R.id.string_text_view5);
            stringTextView5.setText(stringTextView5.getText().toString() + delivery_date2+"\n");
            stringTextView5.setPaintFlags(stringTextView5.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,Cient_chooseActivity.class);
        intent.putExtra("userid",userid);
        startActivity(intent);

    }
}
