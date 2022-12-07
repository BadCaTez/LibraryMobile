package com.example.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReaderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readers);
        TextView text = (TextView)findViewById(R.id.textView);
        MainActivity ma = new MainActivity();
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app1.db", MODE_PRIVATE, null);
        Cursor query = db.rawQuery("SELECT * FROM 'Reader'", null);

        text.setText("");
        while(query.moveToNext()){
            text.append(query.getString(0) + " "+ query.getString(1) +" "+ query.getString(2)
                    + " " + query.getString(3) + " " + query.getString(4) + " "+ query.getString(5) +"\n");
            if(query.getInt(0) == 1){break;}
        }
        query.close();
    }
}
