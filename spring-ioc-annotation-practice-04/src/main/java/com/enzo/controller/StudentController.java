package com.enzo.controller;

import com.enzo.pojo.Student;
import com.enzo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * ClassName: StudentController
 * Package: com.enzo.com.enzo.controller
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/18 21:45
 * @Version 1.0
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    public void findAll(){
        List<Student> all = studentService.findAll();
        System.out.println("all = " + all);
    }

}
