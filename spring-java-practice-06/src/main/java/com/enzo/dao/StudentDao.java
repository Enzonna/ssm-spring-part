package com.enzo.dao;

import com.enzo.pojo.Student;

import java.util.List;

/**
 * ClassName: StudentDao
 * Package: com.enzo.dao
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/18 21:25
 * @Version 1.0
 */
public interface StudentDao {

    List<Student> queryAll();
}
