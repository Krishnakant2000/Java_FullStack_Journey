package Week_2_OOP_Deep_Dive.Day_14_Capstone_SMS;

public class Student {

    private String id;
    private String name;
    private  int age;
    private double grade;

    public Student(String id, String name, int age, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nAge: " + age + "\nGrade: " + grade;
    }

}
