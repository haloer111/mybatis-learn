package org.gexiao.mybatis.reflect.service;

import java.lang.reflect.Method;

/**
 * @auther: gexiao
 * @since: 2019/9/23 14:26
 */
public class ReflectService {
    public void sayHello(String name){
        System.out.println("name = " + name);
    }

    public static void main(String[] args) throws Exception {
        //通过反射创建ReflectService对象
        Class aClass = Class.forName(ReflectService.class.getName());
        //获取反射方法
        Method method = aClass.getMethod("sayHello", String.class);
        //反射调用方法
        Object obj = aClass.newInstance();
        method.invoke(obj,"小王八");
    }
}
