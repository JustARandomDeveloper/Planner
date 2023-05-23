package com.example.planner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CommitmentDbJava {
    private SQLiteDatabase db;

    public CommitmentDbJava(Context context) {
        db = new DbHelperJava(context).getWritableDatabase();
    }

    private ContentValues getValues(CommitmentJava value) {
        ContentValues values = new ContentValues();

        values.put(DbSchemaJava.CommitmentTable.Cols.date, value.getDate());
        values.put(DbSchemaJava.CommitmentTable.Cols.hour, value.getHour());
        values.put(DbSchemaJava.CommitmentTable.Cols.description, value.getDescription());

        return values;
    }

    public void addCommitment(CommitmentJava value) {
        ContentValues values = getValues(value);
        db.insert(DbSchemaJava.CommitmentTable.commitmentName, null, values);
    }

    public void deleteCommitment() {
        db.delete(
                DbSchemaJava.CommitmentTable.commitmentName, null, null
        );
    }

    public Cursor queryCommitments(String clausulaWhere, String[] argsWhere) {
        return db.query(
                DbSchemaJava.CommitmentTable.commitmentName,
                null,
                clausulaWhere,
                argsWhere,
                null,
                null,
                null
        );
    }
}
