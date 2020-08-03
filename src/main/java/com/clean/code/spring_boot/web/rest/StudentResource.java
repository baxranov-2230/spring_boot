package com.clean.code.spring_boot.web.rest;

import com.clean.code.spring_boot.model.Student;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {
    @GetMapping("/student")
    public ResponseEntity getAll(){
        Student student = new Student(1L, "Aziz", "Azizov", "3-kurs");
        Student student1 = new Student(1L, "Zafar", "Zafarov", "3-kurs");
        Student student2 = new Student(1L, "Hsanboy", "Hasanov", "3-kurs");

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        return ResponseEntity.ok(students);
    }
@GetMapping("/student/{id}")
public ResponseEntity getOne(@PathVariable Long id){
    Student student = new Student(id, "Aziz", "Azizov", "3-kurs");
    return ResponseEntity.ok(student);
}

@PostMapping("/student")
    public ResponseEntity create(@RequestBody Student student){
        return ResponseEntity.ok(student);
}
    @PutMapping("/student/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Student studentNew){
        Student student = new Student(1L, "Aziz", "Azizov", "3-kurs");
        student.setId(id);
        student.setName(studentNew.getName());
        student.setLastName(studentNew.getLastName());
        return ResponseEntity.ok(student);
    }


    @GetMapping("/student/{id}")
    public ResponseEntity getOne(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String lastName,
                                 @RequestParam String course){
        Student student = new Student(id, "Aziz", "Azizov", "3-kurs");
        return ResponseEntity.ok(student);
    }



//    @RequestMapping(value = "/student", method = RequestMethod.GET)
//    public String hello(){
//        return "Hello world";
//    }
}
