package org.gexiao.mybatis.reflect.service.impl;

import org.gexiao.mybatis.reflect.service.HelloService;

/**
 * @auther: gexiao
 * @since: 2019/9/23 16:50
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello = " + name);
    }
}
