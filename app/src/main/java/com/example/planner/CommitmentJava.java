package com.example.planner;

import java.util.UUID;

public class CommitmentJava {
    private String mDate;
    private String mHour;
    private String mDescription;
    private UUID mUUID;

    public CommitmentJava(String date, String hour, String description) {
        mDate = date;
        mHour = hour;
        mDescription = description;
        mUUID = UUID.randomUUID();
    }

    public CommitmentJava(UUID uuid, String date, String hour, String description) {
        this(date, hour, description);
        mUUID = uuid;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getHour() {
        return mHour;
    }

    public void setHour(String hour) {
        mHour = hour;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public UUID getUUID() {
        return mUUID;
    }

    public void setUUID(UUID uuid) {
        mUUID = uuid;
    }

}
