package com.margeb;

import java.util.ArrayList;
import java.util.List;

public abstract class Person
{
    protected String name;
    protected String last_name;
    protected List<Subjects> subjects = new ArrayList<Subjects>();

    public String getSubjects()
    {
        String subjects_string = "";
        for(Subjects subject: subjects)
        {
            subjects_string = subjects_string + subject + ", ";
        }
        if(subjects_string.length()>0)
            return subjects_string.substring(0, subjects_string.length()-2);
        return subjects_string;
    }

    public void addSubject(Subjects subject)
    {
        if(!subjects.contains(subject))
        {
            subjects.add(subject);
            if(this.getClass() == Student.class)
            {
                ((Student) this).setBalance(School.getCost_of_subject());
            }
        }
        else
        {
            System.out.println("The subject " + subject + " is already assigned to " + name + " " + last_name + ".");
        }
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
