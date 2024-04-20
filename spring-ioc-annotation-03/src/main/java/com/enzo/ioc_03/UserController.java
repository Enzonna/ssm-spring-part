package com.enzo.ioc_03;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * ClassName: UserController
 * Package: com.enzo.ioc_03
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/18 19:45
 * @Version 1.0
 */

@Controller
public class UserController {

    /**
     * 在成员变量上直接标记，不需要提高setter方法，以后我们在项目中的正式用法就是这样。
     */
    @Autowired  //自动装配注解(DI)：1. ioc容器中查找符合类型的组件对象   2. 设置给当前属性(di)
    //required = false  佛系装配 不推荐使用！装配的数据候期都会调用，会出现空指针
    //如果出现所需类型bean不止一个，使用@Qualifier
    @Qualifier(value = "UserServiceImpl")   //不能单独使用，必须配合Autowired，使用注解指定获取bean的id
    private UserService userService;

    @Resource(name = "UserServiceImpl")     //@Resource     等于  @Autowired + @Qualifier 简化
    private NewUserServiceImpl newUserService;

    public void show(){
        //调用业务层方法
        String show = userService.show();
        System.out.println("show = " + show);

    }
}
