package com.example.planner;

class PlannerKotlin {
    private var commitmentList: MutableList<CommitmentKotlin> = ArrayList()

    fun getList(): List<CommitmentKotlin> {
        return commitmentList
    }

    fun setList(list: List<CommitmentKotlin>) {
        this.commitmentList = list.toMutableList()
    }
}