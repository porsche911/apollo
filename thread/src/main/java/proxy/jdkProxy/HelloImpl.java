package proxy.jdkProxy;

public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("hello world");
    }
}
