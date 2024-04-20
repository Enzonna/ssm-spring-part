package com.enzo;

import com.enzo.config.JavaConfig;
import com.enzo.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName: SpringTest
 * Package: com.enzo
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/19 15:21
 * @Version 1.0
 */
public class SpringIocTest {


    @Test
    public void test_01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        StudentController bean = applicationContext.getBean(StudentController.class);
        bean.findAll();
    }
}
