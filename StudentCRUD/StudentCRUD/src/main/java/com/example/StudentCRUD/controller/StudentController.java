package com.example.StudentCRUD.controller;

import com.example.StudentCRUD.model.Student;
import com.example.StudentCRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class StudentController {
   @Autowired
    StudentService studentService;
   @GetMapping("students")
   public List<Student> getStudents(){
       return studentService.getStudents();

   }
   @GetMapping("students/{rno}")
    public Student getStudentByRno(@PathVariable("rno") int rollno){
       return studentService.getStdByRno(rollno);
   }
   @PostMapping("students")
   public String addStudent(@RequestBody Student student){
       studentService.addStudent(student);
       return "Success";
   }

   @PutMapping("students")
    public String updateStudent(@RequestBody Student student){
       return studentService.updateStudent(student);

   }

   @DeleteMapping("students/{rno}")
    public String delete(@PathVariable int rno){
       return studentService.deleteStudent(rno);

   }
}
