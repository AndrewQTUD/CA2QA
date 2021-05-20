package com.company;

import java.util.ArrayList;

public class Rubric {

    private String rubricName;
    private ArrayList<String> criteria = new ArrayList<>();


    public String getRubricName() {
        return rubricName;
    }

    public void setRubricName(String rubricName) {
        this.rubricName = rubricName;
    }

    public ArrayList<String> getCriteria() {
        return criteria;
    }

    @Override
    public String toString() {
        return "Rubric{" +
                "rubricName='" + rubricName + '\'' +
                ", criteria=" + criteria +
                '}';
    }
}
