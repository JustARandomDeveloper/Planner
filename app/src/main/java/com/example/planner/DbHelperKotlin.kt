package com.example.planner;

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelperKotlin(context: Context?) : SQLiteOpenHelper(context, DATABASE, null, VERSION) {

    companion object {
        private const val VERSION = 1
        private const val DATABASE = "db"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE ${DbSchemaKotlin.CommitmentTable.commitmentName} (" +
                    "_id integer PRIMARY KEY autoincrement," +
                    "${DbSchemaKotlin.CommitmentTable.Cols.uuid}," +
                    "${DbSchemaKotlin.CommitmentTable.Cols.description}," +
                    "${DbSchemaKotlin.CommitmentTable.Cols.date}," +
                    "${DbSchemaKotlin.CommitmentTable.Cols.hour})"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${DbSchemaKotlin.CommitmentTable.commitmentName}")
        onCreate(db)
    }
}
