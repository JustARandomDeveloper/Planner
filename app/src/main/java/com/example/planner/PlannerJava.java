package com.example.planner;
import java.util.ArrayList;
import java.util.List;

public class PlannerJava {
    private List<CommitmentJava> commitmentList = new ArrayList<>();

    public List<CommitmentJava> getList() {
        return commitmentList;
    }

    public void setList(List<CommitmentJava> list) {
        this.commitmentList = new ArrayList<>(list);
    }
}
