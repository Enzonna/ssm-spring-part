package com.enzo.service;

import com.enzo.dao.StudentDao;
import com.enzo.dao.impl.StudentImpl;
import com.enzo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: StudentServiceImpl
 * Package: com.enzo.service
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/18 21:30
 * @Version 1.0
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentImpl studentImpl;

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentImpl.queryAll();
        return studentList;
    }
}
