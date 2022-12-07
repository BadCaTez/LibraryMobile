package com.example.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;

public class BooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        TextView text = (TextView)findViewById(R.id.textView2);
        MainActivity ma = new MainActivity();
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app1.db", MODE_PRIVATE, null);
        Cursor query = db.rawQuery("SELECT * FROM 'Book'", null);

        text.setText("");
        while(query.moveToNext()){
            text.append(query.getString(0) + " "+ query.getString(1) +" "+ query.getString(2)
                    + " " + query.getString(3) + " " + query.getString(4) + "\n");
            if(query.getInt(0) == 2){break;}
        }
        query.close();
    }
}
