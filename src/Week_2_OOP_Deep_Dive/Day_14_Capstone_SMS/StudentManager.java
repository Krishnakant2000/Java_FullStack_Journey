package Week_2_OOP_Deep_Dive.Day_14_Capstone_SMS;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    // The "Database" (In-Memory List)
    private List<Student> students =  new ArrayList<>();

    // 1. Add Student
    public void addStudent(String id, String name, int age, double grade) {
        Student student = new Student(id, name, age, grade);
        students.add(student);
        System.out.println("Success: Student added.");
    }

    // 2. View All
    public void viewAllStudents() {
        System.out.println("--- All Students ---");
        if (students.isEmpty()) {
            System.out.println("No Students found.");
        } else {
            // Method Reference shortcut (same as s -> System.out.println(s))
            students.forEach(System.out::println);
        }
    }

    // 3. Search by Name (Using STREAMS)
    public  void searchStudentByName(String keyword){
        System.out.println("--- Search Results ---");
        List<Student> found =  students.stream().filter(student -> student.getName().toLowerCase()
                            .contains(keyword.toLowerCase())).toList();
        if (found.isEmpty()) {
            System.out.println("No match found for: " + keyword);
        } else  {
            found.forEach(System.out::println);
        }
    }

    // 4. Calculate Class Average (Using STREAMS)
    public  void showClassAverage() {
        if (students.isEmpty()) return;
        double avg = students.stream().mapToDouble(Student::getGrade).average().orElse(0.0);

        System.out.println("Class Average Grade: " + avg);
    }


}
