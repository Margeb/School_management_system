package com.margeb;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person
{
    private static int id = 1;
    private int studentID;
    private int grade;
    private Float balance = 0F;
    private List<Subjects> studentSubjects = new ArrayList<Subjects>();

    public void setBalance(Float balance) {
        this.balance += balance;
    }


    public Student(String name, String last_name, int grade) {
        this.name = name;
        this.last_name = last_name;
        this.grade = grade;
        studentID = id;
        id++;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getGrade() {
        return grade;
    }

    public Float getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Student: " +
                "\n   ID = " + studentID +
                "\n   Name = " + name +
                "\n   Last name = " + last_name +
                "\n   Grade = " + grade +
                "\n   Subjects = " + this.getSubjects() +
                "\n   Balance = " + balance;
    }

}
