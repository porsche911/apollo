package mybatis.services;

public class MybatisInvoke implements InvocationHandler {
    @Override
    public void invoke() {
        System.out.println("我是模拟的mybatisinvoke");
    }
}
