package com.enzo.ioc_04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName: JavaBean
 * Package: com.enzo.com.enzo.ioc_04
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/18 20:39
 * @Version 1.0
 */
@Component
public class JavaBean {

    //方案1 直接赋值
    private String name = "胡歌";

    //方案2 注解赋值 @Value("")   读取外部配置文件
    @Value("${jdbc.username:admin}")    //admin默认值
    private String username;

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
