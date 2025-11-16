package com.relearn.redemo1.rest;

import com.relearn.redemo1.Exception.StudentErrorResponse;
import com.relearn.redemo1.Exception.StudentNotFoundException;
import com.relearn.redemo1.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents=new ArrayList<>();

    @PostConstruct
    public void loadData()
    {
        theStudents.add(new Student("Rajesh","Ram"));
        theStudents.add(new Student("Suresh","Ram"));
        theStudents.add(new Student("Ramesh","Mahto"));
    }
    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return theStudents;
    }
    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        if(studentId<0 || studentId>theStudents.size())
        {
            throw new StudentNotFoundException("No student found with id: "+studentId);
        }
        return theStudents.get(studentId);
    }


}
