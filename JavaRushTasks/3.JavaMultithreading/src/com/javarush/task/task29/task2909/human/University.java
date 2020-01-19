package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class University {

    private String name;
    private int age;
    private List<Student> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students = new ArrayList<>();
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student student1 = null;
        for (Student student : students) {
            if(student.getAverageGrade() == averageGrade)
                student1 = student;
        }
        return student1;
    }

    public Student getStudentWithMaxAverageGrade() {
        students.sort(Comparator.comparing(Student::getAverageGrade).reversed());
        return students.get(0);
    }

    public Student getStudentWithMinAverageGrade() {
        students.sort(Comparator.comparing(Student::getAverageGrade));
        return students.get(0);
    }

    public void expel(Student student){
        students.remove(student);
    }
}