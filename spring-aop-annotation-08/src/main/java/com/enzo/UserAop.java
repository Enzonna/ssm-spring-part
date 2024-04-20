package com.enzo;

import com.enzo.statics.StaticProxyCalculator;

/**
 * ClassName: UserAop
 * Package: com.enzo
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/19 16:51
 * @Version 1.0
 */
public class UserAop {
    public static void main(String[] args) {
        Calculator target = new CalculatorPureImpl();

        //代理
        Calculator proxy = new StaticProxyCalculator(target);

        //调用
        proxy.add(1,1);

    }
}
