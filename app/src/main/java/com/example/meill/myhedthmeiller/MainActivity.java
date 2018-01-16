package com.example.meill.myhedthmeiller;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.meill.myhedthmeiller.Dal.ConnectBDD;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ConnectBDD maCollecDb = new ConnectBDD(this);
        SQLiteDatabase db = maCollecDb.getWritableDatabase();
    }
}
