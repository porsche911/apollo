package mybatis.batis;

import mybatis.proxy1.ServiceLog;
import mybatis.proxy1.ServiceTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MybatisFactory {
    public static Object getMapper(Class clazz){
        //实现jdk的动态代理
        //ClassLoader loader,动态加载一个类
        //Class<?>[] interfaces,
        //InvocationHandler h ，代理对象实现UserDao之后，重写里面方法的具体逻辑
        Class[] classes = new Class[]{clazz};
        Object o = Proxy.newProxyInstance(MybatisFactory.class.getClassLoader(), classes, new MybatisInvocationHandler(new ServiceTest()));
        return o;
    }
}
