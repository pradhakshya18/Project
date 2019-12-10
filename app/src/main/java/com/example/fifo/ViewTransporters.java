package com.example.fifo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class ViewTransporters extends AppCompatActivity {

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_transporters);

        db=new DatabaseHelper(this);
        Cursor cursor=db.alldata();
        if(cursor.getCount()==0)
        {
            Toast.makeText(getApplicationContext(),"TABLE IS EMPTY",Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                Toast.makeText(getApplicationContext(),"id : "+cursor.getString(0),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"username : "+cursor.getString(1),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"password : "+cursor.getString(2),Toast.LENGTH_SHORT).show();

            }
        }
    }
}
