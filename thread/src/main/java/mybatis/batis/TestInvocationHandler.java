package mybatis.batis;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestInvocationHandler implements InvocationHandler {
    Object target;

    public TestInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * proxy代理对象
     * @param proxy
     * @param method  目标方法
     * @param args  目标参数
     *              告诉jdk要代理哪些接口，及这些接口的代理逻辑
     * @return
     * @throws Throwable
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("InvocationHandler jdk");//代理逻辑
        method.invoke(target,args);//方法执行到一个目标对象上去   这样目标对象执行完毕

        return null;
    }
}
