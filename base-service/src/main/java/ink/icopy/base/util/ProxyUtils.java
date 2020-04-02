package ink.icopy.base.util;

import ink.icopy.verifycode.service.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lizhengguang
 */
public class ProxyUtils {

    /**
     * 使用JDK动态代理类
     *
     * @param userService
     * @return
     */
    public static UserService getProxy(final UserService userService) {
        UserService us = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 下面代码是反射中的api用法
                // 方法
                // 2.参数
                System.out.println("记录日志-开始");
                Object invoke = method.invoke(userService, args);
                System.out.println("日志记录-结束");
                return invoke;
            }
        });
        return us;
    }

    /**
     * 使用cglib增强对象方法
     * 它是基于继承的方式实现的
     *
     * @param userService
     * @return
     */
    public static UserService getProxyByCglib(UserService userService) {
        //创建增强器
        Enhancer enhancer = new Enhancer();
        // 这里设置增强类的类对象-实现类对象
        enhancer.setSuperclass(UserService.class);
        // 设置回调方法
        enhancer.setCallback(new MethodInterceptor() {
            /**
             *
             * @param o
             * @param method
             * @param objects 方法参数
             * @param methodProxy 代理之后的对象的方法
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                long start = System.currentTimeMillis();
                System.out.println("cglib 记录开始时间：" + start);
                //代理对象时目标的对象子类
                // 这行代码实际还是调用目标对象的方法
                // o是代理对象
                Object object = methodProxy.invokeSuper(o, objects);
                long end = System.currentTimeMillis();
                System.out.println("cglib 记录结束时间：" + end);
                return object;
            }
        });
        // 获取增强后的代理对象
        return (UserService) enhancer.create();
    }
}
