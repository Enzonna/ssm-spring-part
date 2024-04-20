package com.enzo.test;

import com.enzo.config.JavaConfiguration;
import com.enzo.config.JavaConfigurationA;
import com.enzo.config.JavaConfigurationB;
import com.enzo.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName: SpringIocTest
 * Package: com.enzo.test
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/18 22:18
 * @Version 1.0
 */
public class SpringIocTest {

    @Test
    public void test(){
        //1. 创建ioc容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        //2. 获取bean
        StudentController bean = applicationContext.getBean(StudentController.class);

        System.out.println("bean = " + bean);
    }

    @Test
    public void test_01(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfigurationA.class);
    }
}
