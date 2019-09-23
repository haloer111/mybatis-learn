package org.gexiao.mybatis.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.gexiao.mybatis.reflect.service.HelloService;
import org.gexiao.mybatis.reflect.service.impl.HelloServiceImpl;

import java.lang.reflect.Method;

/**
 * @auther: gexiao
 * @since: 2019/9/23 17:33
 */
public class HelloServiceCglib implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("====我是 CGLIB 的动态代理====");
        //反射方法前调用
        System.out.println("我准备说 hello");
        Object returnObj = proxy.invokeSuper(obj, args);
        System.out.println("我已经说 hello");

        return returnObj;
    }

    public static void main(String[] args) {
        HelloServiceCglib cglib = new HelloServiceCglib();
        HelloService instance = (HelloService) cglib.getInstance(new HelloServiceImpl());
        instance.sayHello("小老八");
    }
}
