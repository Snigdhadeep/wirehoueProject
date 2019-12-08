package com.example.wirehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Cient_chooseActivity extends AppCompatActivity {

    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        Intent i = getIntent();
        userid = i.getStringExtra("userid");
        FloatingActionButton myFab1 = (FloatingActionButton)findViewById(R.id.fab1);
        myFab1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Cient_chooseActivity.this,Client_Home.class);

                intent.putExtra("userid",userid);
                startActivity(intent);
            }
        });

        FloatingActionButton myFab2 = (FloatingActionButton)findViewById(R.id.fab2);
        myFab2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Cient_chooseActivity.this,ProductsActivity.class);

                intent.putExtra("userid",userid);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);

    }
}
