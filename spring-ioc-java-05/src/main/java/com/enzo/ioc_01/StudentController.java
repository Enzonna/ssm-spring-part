package com.enzo.ioc_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * ClassName: StudentController
 * Package: com.enzo.ioc_01
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/18 22:06
 * @Version 1.0
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;


}
