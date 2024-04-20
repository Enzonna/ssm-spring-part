package com.enzo.ioc;

import com.enzo.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: SpringIocTest
 * Package: com.enzo.ioc
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/18 21:57
 * @Version 1.0
 */
public class SpringIocTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentController bean = applicationContext.getBean(StudentController.class);

        bean.findAll();
    }
}
