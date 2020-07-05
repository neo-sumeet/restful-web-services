package com.ss.restfulwebservices.responseFiltering.staticFiltering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("students")
    private List<Student> getStudentList(){
            return Arrays.asList(new Student(1,"John","john@xyz.com"));
    }

    @GetMapping("students/{id}")
    private Student getStudent(@PathVariable("id") String id){
        return new Student(1,"John","john@xyz.com");
    }
}
