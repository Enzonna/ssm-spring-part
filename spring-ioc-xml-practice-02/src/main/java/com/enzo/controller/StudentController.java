package com.enzo.controller;

import com.enzo.pojo.Student;
import com.enzo.service.StudentService;

import java.util.List;

/**
 * ClassName: StudentController
 * Package: com.enzo.controller
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/18 15:44
 * @Version 1.0
 */
public class StudentController {

    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void findAll(){
        List<Student> all = studentService.findAll();
        System.out.println("all = " + all);
    }

}
