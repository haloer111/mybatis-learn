package org.gexiao.mybatis.proxy;

import org.gexiao.mybatis.reflect.service.HelloService;
import org.gexiao.mybatis.reflect.service.impl.HelloServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auther: gexiao
 * @since: 2019/9/23 16:51
 */
public class HelloServiceProxy implements InvocationHandler {
    /**
     * 真实服务对象
     */
    private Object target;

    /**
     * 绑定委托对象并返回一个代理类
     *
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        // 第一个参数target.getClass().getClassLoader()：是类加载器，
        // 第二个参数target.getClass().getInterfaces()：是接口（代理对象挂在哪个接口下），
        // 第三个参数this代表当前HelloServiceProxy类，使用HelloServiceProxy的代理方法作为对象的代理执行者
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("====我是JDK动态代理====");
        Object result = null;
        // 反射方法前调用
        System.out.println("我准备说hello");
        // 执行方法，相当于调用 HelloServiceImpl类的sayHello方法
        result = method.invoke(target, args);
        System.out.println("我已经说hello");
        return result;
    }

    public static void main(String[] args) {
        HelloServiceProxy proxy = new HelloServiceProxy();
        HelloService bind = (HelloService) proxy.bind(new HelloServiceImpl());
        bind.sayHello("张三");
    }
}
