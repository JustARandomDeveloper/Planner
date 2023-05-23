package com.example.planner
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class CommitmentDbKotlin(context: Context) {
    private val db: SQLiteDatabase = DbHelperKotlin(context).writableDatabase
    private fun getValues(value: CommitmentKotlin): ContentValues {
        val values = ContentValues()

        values.put(DbSchemaKotlin.CommitmentTable.Cols.date, value.getDate())
        values.put(DbSchemaKotlin.CommitmentTable.Cols.hour, value.getHour())
        values.put(DbSchemaKotlin.CommitmentTable.Cols.description, value.getDescription())
        return values
    }

    fun addCommitment(value: CommitmentKotlin) {
        val values = getValues(value)
        db.insert(DbSchemaKotlin.CommitmentTable.commitmentName, null, values)
    }

    fun deleteCommitment() {
        db.delete(
            DbSchemaKotlin.CommitmentTable.commitmentName, null, null
        )
    }

    fun queryCommitment(clausulaWhere: String?, argsWhere: Array<String>?): Cursor? {
        return db.query(
        DbSchemaKotlin.CommitmentTable.commitmentName,
            null,
            clausulaWhere,
            argsWhere,
            null,
            null,
            null
        )
    }

}