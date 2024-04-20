package com.enzo.service;

import com.enzo.pojo.Student;

import java.util.List;

/**
 * ClassName: StudentService
 * Package: com.enzo.service
 * Description:学生业务接口
 *
 * @Author ENZO
 * @Create 2024/3/18 15:40
 * @Version 1.0
 */

public interface StudentService {
    /**
     * 查询所有学员数据业务
     * @return
     */
    List<Student> findAll();
}
