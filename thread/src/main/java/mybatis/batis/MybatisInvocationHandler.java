package mybatis.batis;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MybatisInvocationHandler implements InvocationHandler {
    Object target;
    public MybatisInvocationHandler(Object target){
        this.target = target;

    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(target,args);//目标对象执行完了
        System.out.println("conn db");
        Select annotation = method.getAnnotation(Select.class);
        String sql = annotation.value()[0];
        System.out.println("----:"+sql);
        return null;
    }
}
