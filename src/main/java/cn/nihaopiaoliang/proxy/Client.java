package cn.nihaopiaoliang.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 动态代理：基于 JDK Proxy 类
 */
public class Client {

    public static void main(String[] args) {

        float price = 8000f;

        final IProduction finalProduction = new Production();

        System.out.println("finalProduction" + finalProduction.toString());

        IProduction production = (IProduction) Proxy.newProxyInstance(finalProduction.getClass().getClassLoader(), finalProduction.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 在这里做增强操作
                        Object o = null;
                        if ("sales".equals(method.getName())) {
                            args[0] = (Float) args[0] * 0.8f;
                        }
                        o = method.invoke(finalProduction, args);
                        return o;
                    }
                });

        production.sales(price);

        System.out.println("==============");

        System.out.println("production：" + production.toString());
        System.out.println("finalProduction：" + finalProduction.toString());

    }

}
