package com.example.fifo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayContainers extends AppCompatActivity {

    DatabaseHelper2 sqLiteHelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    ListAdapter2 listAdapter ;
    ListView LISTVIEW;

    ArrayList<String> ID_Array;
    ArrayList<String> NAME_Array;
    ArrayList<String> CONTAINER_Array;

    ArrayList<String> ListViewClickItemArray = new ArrayList<String>();
    String TempHolder ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_containers);

        LISTVIEW = (ListView) findViewById(R.id.listView1);

        ID_Array = new ArrayList<String>();

        NAME_Array = new ArrayList<String>();

        CONTAINER_Array = new ArrayList<String>();

        sqLiteHelper = new DatabaseHelper2(this);

        LISTVIEW.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(),ShowSingleRecordActivity2.class);

                intent.putExtra("ListViewClickedItemValue", ListViewClickItemArray.get(position).toString());

                startActivity(intent);

            }
        });

    }

    @Override
    protected void onResume() {

        ShowSQLiteDBdata() ;

        super.onResume();
    }

    private void ShowSQLiteDBdata() {

        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+DatabaseHelper2.TABLE_NAME+"", null);

        ID_Array.clear();
        NAME_Array.clear();
        CONTAINER_Array.clear();

        if (cursor.moveToFirst()) {
            do {

                ID_Array.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper2.COL_1)));

                //Inserting Column ID into Array to Use at ListView Click Listener Method.
                ListViewClickItemArray.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper2.COL_1)));

                NAME_Array.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_3)));

                CONTAINER_Array.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper2.COL_4)));


            } while (cursor.moveToNext());
        }

        listAdapter = new ListAdapter2(DisplayContainers.this,ID_Array,NAME_Array,CONTAINER_Array);

        LISTVIEW.setAdapter(listAdapter);

        cursor.close();
    }


}
