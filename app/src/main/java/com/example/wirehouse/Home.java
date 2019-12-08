package com.example.wirehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    EditText et_barcode;
    ImageView btn_barcode;
    EditText et_client_info;
    Button btn_clientinfo;
    Button btn_search;

    String barcode_string;
    String client_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_info);
        et_barcode=(EditText)findViewById(R.id.et_barcode);
        btn_barcode=(ImageView) findViewById(R.id.btn_barcode);
        et_client_info=(EditText)findViewById(R.id.et_client_info);
        btn_clientinfo=(Button) findViewById(R.id.btn_clientinfo);

        btn_search=(Button)findViewById(R.id.btn_search);



        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                barcode_string=et_barcode.getText().toString();
                if (barcode_string.isEmpty()) {
                    Toast.makeText(Home.this, "please give a valid pallet number", Toast.LENGTH_SHORT).show();

                }else {

                    search();

                }
                }
        });


        btn_clientinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                client_name=et_client_info.getText().toString();
                if (client_name.isEmpty()) {
                    Toast.makeText(Home.this, "please give a valid client name", Toast.LENGTH_SHORT).show();

                }else {

                    search2();

                }
            }
        });



        btn_barcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passToScanner();
            }
        });


    }

    private void search2() {
        Intent i = new Intent (this,ClientInfo.class);

     //   i.putExtra("puzzle", et_barcode.getText().toString());
        i.putExtra("puzzle2", et_client_info.getText().toString());
        startActivity(i);
        Log.d("QRCodeScanner", et_client_info.getText().toString());
    }

    private void passToScanner() {

        Intent intent2=new Intent(this,Scanner.class);
        startActivity(intent2);
    }

    private void search() {
        Intent i = new Intent (this,MainActivity.class);

        i.putExtra("puzzle", et_barcode.getText().toString());
      //  i.putExtra("puzzle2", et_barcode.getText().toString());
        startActivity(i);
         Log.d("QRCodeScanner", et_barcode.getText().toString());
    }
}
