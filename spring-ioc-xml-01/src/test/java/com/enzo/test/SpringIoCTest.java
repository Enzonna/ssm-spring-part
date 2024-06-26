package com.enzo.test;


import com.enzo.ioc_03.HappyComponent;
import com.enzo.ioc_04.JavaBean2;
import com.enzo.ioc_05.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {
    /**
     * 讲解如何创建ioc容器并且读取配置文件
     */
    public void creatIoC() {
        //1 创建容器 选择合适的容器 实现即可
        /**
         * 接口
         *      BeanFactory
         *      ApplicationContext
         * 实现类
         *      可以直接通过构造函数实例化的
         *      ClassPathXmlApplicationContext      读取类路径下xml配置方法   classes
         *      FileSystemXmlApplicationContext     读取指定系统文件位置的xml配置方法
         *      AnnotationConfigApplicationContext  读取配置类方式的ioc容器
         *      WebApplicationContext               web项目专属的配置的ioc容器
         */

        //方式1 直接创建容器并且指定配置文件即可[推荐]
        //构造函数(String...配置文件)   可以填写一个或多个
        //ioc di
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        //方式2 先创建ioc容器对象，再指定配置文件，再刷新
        //源码的配置过程 创建容器 [spring] 和配置文件指定 分开[自己指定]
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        applicationContext1.setConfigLocations("spring-03.xml");
        applicationContext1.refresh();
    }

    /**
     * 讲解如何在IoC容器中获取组件Bean
     */
    @Test
    public void getBeanFromIoC() {
        //1 创建ioc容器对象
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocations("spring-03.xml");
        applicationContext.refresh();//ioc di的动作
        //2 读取ioc容器的组件
        //方案1 直接根据beanId获取即可    返回值类型是object 需要强转(不推荐)
        HappyComponent happyComponent = (HappyComponent) applicationContext.getBean("happyComponent");
        //方案2 根据beanId，同时指定bean的类型 Class
        HappyComponent happyComponent1 = applicationContext.getBean("happyComponent", HappyComponent.class);
        //方案3 直接根据类型获取
        //TODO:根据bean的类型获取，同一个类型，在ioc容器中只能有一个bean！！！
        //TODO：如果ioc容器存在多个同类型的bean，会出现NoUniqueBeanDefiniteException
        //TODO：ioc的配置一定是实现类，但是可以根据接口类型获取值。getBean(类型); instanceof ioc容器的类型 == true
        HappyComponent happyComponent2 = applicationContext.getBean(HappyComponent.class);

        happyComponent2.doWork();

        System.out.println(happyComponent == happyComponent1);
        System.out.println(happyComponent == happyComponent2);

    }

    /**
     * 测试ioc的初始化和销毁方法的触发
     */
    @Test
    public void test04() {
        //1 创建ioc容器 就会进行组件对象的实例化  init
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");
        //ioc -> 容器去调用destroy
        //ioc会立即释放掉

        JavaBean2 bean = applicationContext.getBean(JavaBean2.class);
        JavaBean2 bean1 = applicationContext.getBean(JavaBean2.class);
        System.out.println(bean == bean1);

        //2 正常结束ioc容器
        applicationContext.close();
    }

    /**
     * 读取factoryBean工厂配置的组件对象
     */
    @Test
    public void test_05(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-05.xml");
        JavaBean javaBean = applicationContext.getBean("javaBean", JavaBean.class);
        System.out.println("javaBean = " + javaBean);

        //TODO:FactoryBean工厂也会加入到ioc容器中，名字 &id
        Object bean = applicationContext.getBean("&javaBean");
        System.out.println("bean = " + bean);

        applicationContext.close();
    }
}
