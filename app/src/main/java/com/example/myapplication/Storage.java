package com.example.myapplication;


import java.util.ArrayList;
import java.util.List;

public class Storage {

    private List<Object> students;
    private Storage()
    {
        students = new ArrayList<Object>();
    }
    static private Storage instanca;

    static Storage getInstance()
    {
        if(instanca==null)
        {
            instanca = new Storage();
            instanca.students.add("List:");
        }
        return  instanca;
    }

    public void setStudents(Student student) {
        this.students.add(student);
    }

    public List<Object> getStudents() {
        return students;
    }
}
