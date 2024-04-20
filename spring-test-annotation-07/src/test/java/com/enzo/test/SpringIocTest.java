package com.enzo.test;

import com.enzo.components.A;
import com.enzo.components.B;
import com.enzo.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * ClassName: SpringIocTest
 * Package: com.enzo.test
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/19 16:24
 * @Version 1.0
 */
//@SpringJUnitConfig(locations = "指定配置文件xml",value = "指定配置类")
@SpringJUnitConfig(value = JavaConfig.class)
public class SpringIocTest {
    @Autowired
    private A a;

    @Autowired
    private B b;

    @Test
    public void test_01() {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

}


