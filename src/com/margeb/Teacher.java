package com.margeb;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person
{

    private static int id = 1;
    private int teacherID;
    private Float salary;


    public Teacher(String name, String last_name, Float salary) {
        this.name = name;
        this.last_name = last_name;
        this.salary = salary;
        this.teacherID = id;
        id++;
    }


    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public int getTeacherID() {
        return teacherID;
    }

    @Override
    public String toString() {
        return "Teacher: " +
                "\n   ID = " + teacherID +
                "\n   Name = " + name +
                "\n   Last name = " + last_name +
                "\n   Subjects = " + getSubjects() +
                "\n   Salary = " + salary;
    }

}
