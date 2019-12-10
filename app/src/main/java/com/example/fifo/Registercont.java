package com.example.fifo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registercont extends AppCompatActivity {

    EditText s1,s2,s3,s4,s5,s6,s7,s8;
    Button b1;
    DatabaseHelper2 d1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registercont);

        d1=new DatabaseHelper2(this);
        s1=(EditText)findViewById(R.id.e1);
        s2=(EditText)findViewById(R.id.e2);
        s3=(EditText)findViewById(R.id.e3);
        s4=(EditText)findViewById(R.id.e4);
        s5=(EditText)findViewById(R.id.e5);
        s6=(EditText)findViewById(R.id.e6);
        s8=(EditText)findViewById(R.id.e8);

        b1=(Button)findViewById(R.id.r);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=s1.getText().toString();
                String b=s2.getText().toString();
                String c=s3.getText().toString();
                String d=s4.getText().toString();
                String e=s5.getText().toString();
                String f=s6.getText().toString();
                String h=s8.getText().toString();

                long v=d1.addUser(a,b,c,d,e,f,h);
                if(v > 0) {
                    Toast.makeText(Registercont.this, "You have registered", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Registercont.this, "You have not registered", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
