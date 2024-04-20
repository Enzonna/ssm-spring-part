package com.enzo.ioc_02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * ClassName: JavaBean
 * Package: com.enzo.ioc_02
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/18 19:23
 * @Version 1.0
 */
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)     //单例 默认值
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)   //多例
@Component
public class JavaBean {
    @PostConstruct
    public void init(){
        System.out.println("JavaBean.init");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("JavaBean.destroy");
    }
}
