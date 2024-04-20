package com.enzo.ioc_03;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * ClassName: UserServiceImpl
 * Package: com.enzo.ioc_03
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/18 19:46
 * @Version 1.0
 */
@Controller("UserServiceImpl")
public class UserServiceImpl implements UserService{
    @Override
    public String show() {
        return "UserService show";
    }
}
