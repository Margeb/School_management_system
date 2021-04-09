package com.margeb;

import java.util.ArrayList;
import java.util.List;

public class School
{
    private static List<Teacher> teacherList = new ArrayList<>();
    private static List<Student> studentList = new ArrayList<>();
    private static Float cost_of_subject = 500F;

    public static void addTeacher(Teacher teacher)
    {
        teacherList.add(teacher);
    }

    public static void addStudent(Student student)
    {
        studentList.add(student);
    }

    public static List<Teacher> getTeacherList() {
        return teacherList;
    }

    public static Float getCost_of_subject() {
        return cost_of_subject;
    }

    public static List<Student> getStudentList() {
        return studentList;
    }

}
