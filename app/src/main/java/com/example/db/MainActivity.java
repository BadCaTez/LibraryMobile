package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but = (Button)findViewById(R.id.buttoBooks);

        db = getBaseContext().openOrCreateDatabase("app1.db", MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS 'Reader' (\n" +
                "  'idReader' INT NOT NULL,\n" +
                "  'FIO' VARCHAR(75),\n" +
                "  'DataBirthday' DATE,\n" +
                "  'Rating' INT,\n" +
                "  'PlaceResident' VARCHAR(75),\n" +
                "  'MobileNumber' VARCHAR(12));");

        db.execSQL("CREATE TABLE IF NOT EXISTS 'Book' (\n" +
                "  'idBook' INT NOT NULL,\n" +
                "  'RealseDate' DATE,\n" +
                "  'Name' VARCHAR(100),\n" +
                "  'Author' VARCHAR(75),\n" +
                "  'Pages' INT);");

        db.execSQL("CREATE TABLE IF NOT EXISTS 'UserBook' (\n" +
                "  'idUserBook' INT NOT NULL,\n" +
                "  'idBook' INT NOT NULL,\n" +
                "  'idUser' INT NOT NULL);");

        db.execSQL("INSERT OR IGNORE INTO 'Book'('idBook', 'RealseDate', 'Name'," +
                "'Author', 'Pages') VALUES (1, '2002-12-08', 'Гарри', 'Гарри Шпротер', 300);");

        db.execSQL("INSERT OR IGNORE INTO 'Book'('idBook', 'RealseDate', 'Name', " +
                "'Author', 'Pages' ) VALUES (2, '2007-06-27', 'Лазо', 'Печка в поезде', 300);");

        db.execSQL("INSERT OR IGNORE INTO 'Reader'('idReader' , 'FIO', 'DataBirthday'," +
                " 'Rating', 'PlaceResident', 'MobileNumber') VALUES (1, 'Кудряшов Иван Андреевич'," +
                "'2008-12-8', 5, 'ул.Горького 166-2','+79005623095');");

        db.close();
    }

    public void selectBooks(View view) {
        startActivity(new Intent(this, BooksActivity.class));
    }

    public void selectReaders(View view) {startActivity(new Intent(this, ReaderActivity.class));}
}