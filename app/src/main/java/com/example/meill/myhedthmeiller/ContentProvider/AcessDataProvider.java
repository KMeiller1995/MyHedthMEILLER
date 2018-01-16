package com.example.meill.myhedthmeiller.ContentProvider;


import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.example.meill.myhedthmeiller.Dal.ConnectBDD;
import com.example.meill.myhedthmeiller.Models.Personne;

/**
 * Created by meill on 17/11/2017.
 */

public class AcessDataProvider extends ContentProvider {


    SQLiteDatabase db;
    private static final int PERSONNE_ALL = 1;
    private static final int PERSONNE_ID = 2;
    private static final int PERSONNE_ID_NAME = 3;
    private static final int PERSONNE_LOGIN = 4;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sUriMatcher.addURI("Com.example.myhedthmeiller", "personne", PERSONNE_ALL);
        sUriMatcher.addURI("Com.example.myhedthmeiller", "personne/#", PERSONNE_ID); //#=id
        sUriMatcher.addURI("Com.example.myhedthmeiller", "personne/#/*", PERSONNE_ID_NAME);//#=id, *=Name
        sUriMatcher.addURI("Com.example.myhedthmeiller", "personne/find/*", PERSONNE_LOGIN);//*=login
    }


    @Override
    public boolean onCreate() {
        ConnectBDD maCollecDb= new ConnectBDD(this.getContext());
        db = maCollecDb.getWritableDatabase();

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        Cursor cursor = null;
        switch (sUriMatcher.match(uri))
        {
            case PERSONNE_ALL:
                cursor= db.query("Personne",null,null,null,null,null,null);
                break;
            case PERSONNE_ID:
                cursor= db.query("Personne",projection,selection,selectionArgs,null,null,null);
                break;
            case PERSONNE_ID_NAME:
                cursor= db.query("Personne",projection,selection,selectionArgs,null,null,null);
                break;
            case PERSONNE_LOGIN:
                cursor= db.query("Personne",projection,selection,selectionArgs,null,null,null);
                break;
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        Personne p = new Personne();
        switch (sUriMatcher.match(uri)) {

            case PERSONNE_ALL:
                return  "android.cursor.dir/vnd.myhedthmeiller.Personne";

            case PERSONNE_ID:
                return "android.cursor.item/vnd.myhedthmeiller.Personne";


            case PERSONNE_ID_NAME:
                return "android.cursor.item/vnd.myhedthmeiller.Personne";

            case PERSONNE_LOGIN:
                return "android.cursor.item/vnd.com.myhedthmeiller.Personne";

            default:
                return null;
        }

    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
