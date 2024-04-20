package com.enzo.dao.impl;

import com.enzo.dao.StudentDao;
import com.enzo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: StudentImpl
 * Package: com.enzo.dao.impl
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/18 21:27
 * @Version 1.0
 */
@Repository
public class StudentImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Student> queryAll() {
        String sql = "select id , name , age , gender , class as classes from students ;";

        /*
          query可以返回集合!
          BeanPropertyRowMapper就是封装好RowMapper的实现,要求属性名和列名相同即可
         */
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));

        return studentList;
    }
}
