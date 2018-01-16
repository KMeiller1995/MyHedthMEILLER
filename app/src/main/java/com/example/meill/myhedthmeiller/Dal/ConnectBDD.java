package com.example.meill.myhedthmeiller.Dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.meill.myhedthmeiller.Models.Personne;

/**
 * Created by meill on 17/11/2017.
 */

public class ConnectBDD extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String  DATABASE_NAME ="MaDb.db";


    public Context context;
    public ConnectBDD(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Table
        db.execSQL("CREATE TABLE Personne " +
                "(idPersonne INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nomPersonne VARCHAR NOT NULL , " +
                "prenomPersonne VARCHAR NOT NULL , " +
                "agePersonne INTEGER NOT NULL , " +
                "poidsPersonne INTEGER NOT NULL , " +
                "dateMajPersonne DATETIME NULL," +
                "loginPersonne VARCHAR NOT NULL" +
                ");");

        ContentValues values = new ContentValues();
        values.put("nomPersonne", "Meiller");
        values.put("prenomPersonne", "kevin");
        values.put("agePersonne", 22);
        values.put("poidsPersonne", 80);
        values.put("dateMajPersonne", "2017-11-17");
        values.put("loginPersonne", "LogMeiller");
        db.insert("Personne", null, values);

        values.put("nomPersonne", "Lafont");
        values.put("prenomPersonne", "Antoine");
        values.put("agePersonne", 24);
        values.put("poidsPersonne", 80);
        values.put("dateMajPersonne", "2017-11-17");
        values.put("loginPersonne", "LogLafont");
        db.insert("Personne", null, values);

        values.put("nomPersonne", "Martin");
        values.put("prenomPersonne", "Pierre");
        values.put("agePersonne", 24);
        values.put("poidsPersonne", 80);
        values.put("dateMajPersonne", "2017-11-17");
        values.put("loginPersonne", "LogMartin");
        db.insert("Personne", null, values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
      /*  while(oldVersion<newVersion)
        {
            if(oldVersion==2){Versionn2(db); break;}
            if(oldVersion==3){ break;}
            if(oldVersion==4){ break;}
            if(oldVersion==5){ break;}
            if(oldVersion==6){ break;}
            if(oldVersion==7){ break;}
            oldVersion+=1;
        }*/
    }

    public void Versionn2(SQLiteDatabase db)
    {
        //db.execSQL("New script");
    }
}
