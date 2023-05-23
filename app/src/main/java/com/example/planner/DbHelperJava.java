package com.example.planner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelperJava extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE = "db";

    public DbHelperJava(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + DbSchemaJava.CommitmentTable.commitmentName + " (" +
                        "_id integer PRIMARY KEY autoincrement," +
                        DbSchemaJava.CommitmentTable.Cols.uuid + "," +
                        DbSchemaJava.CommitmentTable.Cols.description + "," +
                        DbSchemaJava.CommitmentTable.Cols.date + "," +
                        DbSchemaJava.CommitmentTable.Cols.hour + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DbSchemaJava.CommitmentTable.commitmentName);
        onCreate(db);
    }
}
