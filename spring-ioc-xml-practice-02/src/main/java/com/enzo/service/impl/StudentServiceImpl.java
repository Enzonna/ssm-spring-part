package com.enzo.service.impl;

import com.enzo.dao.StudentDao;
import com.enzo.pojo.Student;
import com.enzo.service.StudentService;

import java.util.List;

/**
 * ClassName: StudentServiceImpl
 * Package: com.enzo.service.impl
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/18 15:42
 * @Version 1.0
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        System.out.println("studentList = " + studentList);
        return studentList;
    }
}
