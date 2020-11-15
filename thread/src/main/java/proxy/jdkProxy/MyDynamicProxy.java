package proxy.jdkProxy;

import java.lang.reflect.Proxy;

public class MyDynamicProxy {
    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        //hello是目标对象
        MyInvocationHandler handler = new MyInvocationHandler(hello);
        //构造代码实例
        Hello hello1 = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(), handler);
        hello1.sayHello();

    }

}
