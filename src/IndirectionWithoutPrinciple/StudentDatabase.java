package IndirectionWithoutPrinciple;

import java.util.ArrayList;
import java.util.List;

// Student class (Represents an entity)
class Student {
    String name;
    int id;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// StudentService class (Handles student operations)
class StudentService {
    private List<Student> students = new ArrayList<>();

    void addStudent(int id, String name) {
        students.add(new Student(id, name));
        System.out.println("Student added to database: " + name);
    }

    List<Student> getAllStudents() {
        return students;
    }
}

// Main class to run the program
public class StudentDatabase {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        service.addStudent(1, "Ali");
        service.addStudent(2, "Ayesha");

        for (Student s : service.getAllStudents()) {
            System.out.println(s.id + " - " + s.name);
        }
    }
}
