package com.example.wirehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    String email;
    Button btn_signin;
    FirebaseDatabase wirehouse_database;
    DatabaseReference wirehouse_reference;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);









//        Log.i("ref",wirehouse_reference.toString());
        
        et_username=(EditText)findViewById(R.id.et_username);
        et_password=(EditText)findViewById(R.id.et_password);
         btn_signin=(Button)findViewById(R.id.btn_signin);



         btn_signin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

email=et_username.getText().toString();
Log.i("email",email);




                 signin();
             }
         });





    }

    private void signin() {

        wirehouse_database=FirebaseDatabase.getInstance();
        wirehouse_reference=wirehouse_database.getReference("User_Logins");

        wirehouse_reference.orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (final DataSnapshot child : dataSnapshot.getChildren()) {

                    Log.i("User key", child.getKey());
                    Log.i("User ref", child.getRef().toString());
                    Log.i("User val", child.getValue().toString());
                    Log.i("data", dataSnapshot.getValue().toString());

                    Model_user model_user = child.getValue(Model_user.class);

                    if (email.equals(model_user.email) &&
                            et_password.getText().toString().equals(model_user.password)) {
                        Toast.makeText(LoginActivity.this, "User and Password is correct",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,Cient_chooseActivity.class);

                        intent.putExtra("userid",model_user.id);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "User and Password is not correct",
                                Toast.LENGTH_SHORT).show();


                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

/*
        if (et_username.getText().toString().equals("admin") && et_password.getText().toString().equals("admin321")){


            Intent intent=new Intent(this,Home.class);
            startActivity(intent);
        } else {

            Toast.makeText(this, "username or password incorrect,please try again", Toast.LENGTH_SHORT).show();
        }*/
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
