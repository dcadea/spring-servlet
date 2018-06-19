package club.cheapok.usm.ss.dao;

import club.cheapok.usm.ss.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StudentDao {

    private static List<Student> students = new ArrayList<Student>() {{
        add(new Student(1L, "Jora", "Partizan"));
        add(new Student(2L, "Valera", "Kardan"));
        add(new Student(3L, "Bill", "Gates"));
    }};

    public List<Student> findAll() {
        return students;
    }

    public void save(final Student student) {
        students.add(student);
    }

}
