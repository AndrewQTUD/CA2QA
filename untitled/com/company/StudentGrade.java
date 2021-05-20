package com.company;

import java.util.HashMap;

public class StudentGrade {
    private String studentName;
    private String rubricName;
    private HashMap<String, Integer> scores;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRubricName() {
        return rubricName;
    }

    public void setRubricName(String rubricName) {
        this.rubricName = rubricName;
    }

    public HashMap<String, Integer> getScores() {
        return scores;
    }

    public void setScores(HashMap<String, Integer> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "StudentGrade{" +
                "studentName='" + studentName + '\'' +
                ", rubricName='" + rubricName + '\'' +
                ", scores=" + scores +
                '}';
    }
}
