package com.example.fifo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditSingleRecordActivity2 extends AppCompatActivity {

    EditText name, container_number;
    Button update;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper2 sqLiteHelper;
    Cursor cursor;
    String IDholder;
    String SQLiteDataBaseQueryHolder ;
    SQLiteDatabase sqLiteDatabaseObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_single_record2);


        name = (EditText) findViewById(R.id.EditTextName);
        container_number = (EditText) findViewById(R.id.editText3);

        update = (Button) findViewById(R.id.buttonUpdate);

        sqLiteHelper = new DatabaseHelper2(this);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String GetName = name.getText().toString();
                String GetContainer =container_number.getText().toString();

                OpenSQLiteDataBase();

                SQLiteDataBaseQueryHolder = "UPDATE " + DatabaseHelper2.TABLE_NAME + " SET "+DatabaseHelper2.COL_2+" = '"+GetName+"' , "+DatabaseHelper2.COL_3+" = '"+GetContainer+"' WHERE id = " + IDholder + "";

                sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);

                sqLiteDatabase.close();

                Toast.makeText(EditSingleRecordActivity2.this,"Data Edit Successfully", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onResume() {

        ShowSRecordInEditText();

        super.onResume();
    }

    public void ShowSRecordInEditText() {

        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        IDholder = getIntent().getStringExtra("EditID");

        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + DatabaseHelper2.TABLE_NAME + " WHERE id = " + IDholder + "", null);

        if (cursor.moveToFirst()) {

            do {
                name.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper2.COL_2)));

                container_number.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper2.COL_3)));
            }
            while (cursor.moveToNext());

            cursor.close();

        }
    }

    public void OpenSQLiteDataBase(){

        sqLiteDatabaseObj = openOrCreateDatabase(DatabaseHelper2.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }


}
