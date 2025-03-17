package IndirectionWithPrinciple;

import java.util.ArrayList;
import java.util.List;

// Student class (Represents an entity)
class Student {
    String name;
    int id;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// DAO Interface for abstraction
interface StudentDAO {
    void addStudent(Student student);
    List<Student> getAllStudents();
}

// Data Access Implementation (Handles data storage)
class StudentDAOImpl implements StudentDAO {
    private List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added to database: " + student.name);
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }
}

// Student Service (Uses DAO as Indirection Layer)
class StudentService {
    private StudentDAO studentDAO;

    // Constructor Injection (Dependency Injection)
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void addStudent(int id, String name) {
        studentDAO.addStudent(new Student(id, name));
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}

// Main Class
public class StudentDatabase {
    public static void main(String[] args) {
        // Using DAO with Indirection
        StudentDAO studentDAO = new StudentDAOImpl();
        StudentService service = new StudentService(studentDAO);

        // Adding Students
        service.addStudent(1, "Ali");
        service.addStudent(2, "Ayesha");

        // Displaying Students
        for (Student s : service.getAllStudents()) {
            System.out.println(s.id + " - " + s.name);
        }
    }
}
