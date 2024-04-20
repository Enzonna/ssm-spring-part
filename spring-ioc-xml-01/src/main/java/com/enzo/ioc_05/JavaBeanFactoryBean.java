package com.enzo.ioc_05;

import org.springframework.beans.factory.FactoryBean;

/**
 * 1 实现FactoryBean接口 <返回值类型>
 *
 */
public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {

    @Override
    public JavaBean getObject() throws Exception {
        //使用你自己的方式实例化对象
        JavaBean javaBean = new JavaBean();
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }
}
