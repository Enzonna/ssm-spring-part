package com.enzo.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.enzo.controller.StudentController;
import com.enzo.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 测试JavaTemplate如何使用
 */
public class JdbcTemplateTest {
    public void testForJava() {
        /**
         * JdbcTemplate 简化数据库的crud 不提供连接池
         * DruidDataSource  负责连接的创建和数据库驱动的注册等等
         */

        //0 创建一个连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc::mysql:///studb");//url地址
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");//驱动
        dataSource.setUsername("root");
        dataSource.setPassword("010320");

        //1 实例化对象即可
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(dataSource);

        //2 调用方法即可
        //jdbcTemplate.update()     DDl DML DCL 非查询语言
        //jdbcTemplate.queryForObject()     DQL 查询单个对象
        //jdbcTemplate.query()      DQL 查询集合

    }

    /**
     * 通过ioc容器读取配置的JdbcTemplate组件
     */
    @Test
    public void testForIoC() {
        //1 创建ioc组件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        //2 获取jdbcTemplate组件
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        //3 进行数据库的curd组件
        //3.1 插入 删除 和修改DML update
        String sql = "insert into students (id,name,gender,age,class) values (?,?,?,?,?)";

        int rows = jdbcTemplate.update(sql,11,"胡歌","男",30,"三年三班");
        System.out.println("rows = " + rows);

        //3.2查询单条数据
        //根据id查询学生数据，返回对应的实体对象
        sql = "select * from students where id = ?;";
        /**
         * 参数2： RowMapper   列名和属性名的映射器接口
         * 返回值  rowMapper指定的对象
         */
        Student student1 = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            //re 结果集
            //rowNum 行数
            //re 结果集中获取列的值 赋值给实体类对象即可
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setGender(rs.getString("gender"));
            student.setClasses(rs.getString("class"));
            return student;
        }, 1);
        System.out.println("student1 = " + student1);

        //3.3 查询所有学生数据
        sql = "select id,name,gender,age,class as classes from students;";

        //TODO:BeanProperRowMapper帮助我们自动映射列和属性值
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println("studentList = " + studentList);
    }

    /**
     * 从ioc容器中获取controller并且调用业务，内部都是ioc容器进行组装
     */
    @Test
    public void testQueryAll(){
        //1 创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        //2 获取组件对象
        StudentController bean = applicationContext.getBean(StudentController.class);
        //3 使用组件对象
        bean.findAll();
        //4 关闭容器
        applicationContext.close();
    }
}
