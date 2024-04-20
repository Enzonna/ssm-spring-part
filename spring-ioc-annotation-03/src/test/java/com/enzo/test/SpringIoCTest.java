package com.enzo.test;

import com.enzo.ioc_01.XxxDao;
import com.enzo.ioc_01.XxxService;
import com.enzo.ioc_02.JavaBean;
import com.enzo.ioc_03.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: SpringIoCTest
 * Package: com.enzo.test
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/18 16:41
 * @Version 1.0
 */

public class SpringIoCTest {
    @Test
    public void testIoc_01(){
        /**
         * 未解决，配置有问题？
         */
        //1 创建ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        //2 获取组件
        XxxDao bean = applicationContext.getBean(XxxDao.class);
        System.out.println("bean = " + bean);
        XxxService bean1 = applicationContext.getBean(XxxService.class);
        bean1.insert();
        //添加ioc注解，默认的组件名为   类的首字母小写
        Object xxxService = applicationContext.getBean("xxxService");
        System.out.println(xxxService);

        //3 close容器
    }

    @Test
    public void testIoc_02(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        JavaBean bean = applicationContext.getBean(JavaBean.class);
        JavaBean bean1 = applicationContext.getBean(JavaBean.class);
        System.out.println(bean == bean1);

        applicationContext.close();
    }

    @Test
    public void testIoc_03(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");
        UserController bean = applicationContext.getBean(UserController.class);
        bean.show();
    }

    @Test
    public void testIoc_04(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");
        com.enzo.ioc_04.JavaBean bean = applicationContext.getBean(com.enzo.ioc_04.JavaBean.class);
        System.out.println("bean = " + bean);
    }

}
