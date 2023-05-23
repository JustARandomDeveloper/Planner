package com.example.planner;

import java.util.*

class CommitmentKotlin(private var mDate: String, private var mHour: String, private var mDescription: String) {
    private var mUUID: UUID = UUID.randomUUID()

    constructor(uuid: UUID, date: String, hour: String, description: String) : this(date, hour, description) {
        mUUID = uuid
    }

    fun getDate(): String {
        return mDate
    }

    fun setDate(date: String) {
        mDate = date
    }

    fun getHour(): String {
        return mHour
    }
    fun setHour(hour: String) {
        mHour = hour
    }

    fun getDescription(): String {
        return mDescription
    }

    fun setDescription(description: String) {
        mDescription = description
    }

    fun getUUID(): UUID {
        return mUUID
    }

    fun setUUID(uuid: UUID) {
        mUUID = uuid
    }

}