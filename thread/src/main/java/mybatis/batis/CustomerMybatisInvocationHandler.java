package mybatis.batis;

import java.lang.reflect.Method;

public interface CustomerMybatisInvocationHandler {
    public Object invoke(Method method);
}
