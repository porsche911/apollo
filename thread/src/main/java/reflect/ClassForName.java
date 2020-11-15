package reflect;

public class ClassForName {
    //静态代码块
    static {
        System.out.println("执行了静态代码块");
    }
    //静态变量
    private static String staticField = staticMethod();

    private static String staticMethod() {
        System.out.println("执行了静态方法");
        return "给静态字段赋值";
    }
}
