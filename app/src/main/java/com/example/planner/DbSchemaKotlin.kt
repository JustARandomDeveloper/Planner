package com.example.planner;

object DbSchemaKotlin {
    object CommitmentTable {
        const val commitmentName = "commitmentName"

        object Cols {
            const val uuid = "uuid"
            const val description = "description"
            const val date = "date"
            const val hour = "hour"
        }
    }
}
