package com.example.exercise2.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    public static final Model instance = new Model();

    private Model(){
        data.add(new Student("Meyron", "206534034", false, "054-5531135", "Rosh Ha'Ayin"));
        data.add(new Student("Ohad", "206399099", true, "054-3924044", "Rosh Ha'Ayin"));
        data.add(new Student("Shimon", "123456789", false, "054-1234567", "Tel Aviv"));
    }

    List<Student> data = new LinkedList<Student>();

    public List<Student> getAllStudents(){
        return data;
    }

    public void addStudent(Student student){
        data.add(student);
    }

    public Student getStudent(int position){
        return data.get(position);
    }
}
