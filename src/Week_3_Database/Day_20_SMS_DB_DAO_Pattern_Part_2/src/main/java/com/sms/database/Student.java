package com.sms.database;

public class Student {

    private int id;
    private String name;
    private int age;
    private double grade;

    public Student(int id, String name, int age, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }

    @Override
    public String toString() {
        return String.format("ID: %-3d | Name: %-15s | Age: %-3d | Grade: %.2f", id, name, age, grade);
    }

}
