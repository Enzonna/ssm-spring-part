package com.enzo.service;

import com.enzo.pojo.Student;

import java.util.List;

/**
 * ClassName: StudentService
 * Package: com.enzo.service
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/18 21:29
 * @Version 1.0
 */
public interface StudentService {
    List<Student> findAll();
}
