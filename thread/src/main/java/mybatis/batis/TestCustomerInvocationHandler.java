package mybatis.batis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCustomerInvocationHandler implements CustomerMybatisInvocationHandler {
    Object target;

    public TestCustomerInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Method method) {
        System.out.println("TestCustomerInvocationHandler --------");
        try {
            return method.invoke(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
