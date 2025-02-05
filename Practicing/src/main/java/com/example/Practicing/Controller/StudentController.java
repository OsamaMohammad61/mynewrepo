package com.example.Practicing.Controller;

import com.example.Practicing.Model.Student;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/newStudent")
    public String newStudent(@RequestBody Student student){
        try{
            students.add(student);
            return "you think Student added successfully";
        }catch(Exception e ){
            e.printStackTrace();
        }
        return "Student didnt added";
    }

    @PutMapping("update/{id}")
    public Student updateIdname (@RequestBody Student student, @PathVariable int id){
        for (Student s : students){
            if (s.getId()==id){
                s.setName(student.getName());
                return s;
            }
        }
        return null;
    }
}

