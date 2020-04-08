package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

    class DataBaseHelper extends SQLiteOpenHelper {
        public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
        @Override
        public void onCreate(SQLiteDatabase _db) {
            try {
                _db.execSQL(LoginDatabaseAdapter.DATABASE_CREATE);
            } catch (Exception er) {
                Log.e("Error", "exceptioin");
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) {
            Log.w("TaskDBAdapter", "Upgrading from version " + _oldVersion + " to " + _newVersion + ", which will destroy all old data");
            _db.execSQL("DROP TABLE IF EXISTS " + "LOGIN");
            onCreate(_db);
        }
    }