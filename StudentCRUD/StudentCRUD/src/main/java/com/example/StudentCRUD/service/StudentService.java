package com.example.StudentCRUD.service;


import com.example.StudentCRUD.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Abi", "AI"),
                    new Student(2, "mani", "GI")
            )
    );

    public List<Student> getStudents() {
        return students;
    }

    public Student getStdByRno(int rollno) {
        int index = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRno() == rollno) {
                index = i;
            }
        }
        return students.get(index);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String updateStudent(Student student) {
        int index = 0;
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRno() == student.getRno()) {
                index = i;
                found = true;
                break;
            }
        }
        if (!found) return "No such student exist";
        else {
            students.set(index, student);
            return "Updation is done";

        }
    }

    public String deleteStudent(int rno) {
        int index = 0;
        boolean found=false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRno() == rno) {
                index = i;
                found = true;
                break;
            }
        }
        if(found){
            students.remove(index);
            return "deleted sucessfully..";
        }
        else{
            return "no such student exists..";
        }

    }
}
