package com.example.Practicing.Controller;

import com.example.Practicing.Model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class StudentController {

    private ArrayList<Student> students = new ArrayList<>();
    public StudentController() {
//        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student(1,"osama"));
        students.add(new Student(2, "Asma"));
        students.add(new Student(3, "Maryam"));
        students.add(new Student(4, "Fahad"));
    }

    @GetMapping
    public ArrayList<Student> getAll(){
        return students;
    }

    @GetMapping("{id}")
    public Student getOne(@PathVariable int id){
        for (Student s: students) {
            if(s.getId() == id){
                return s;
            }
        }
       return null;
    }
}

