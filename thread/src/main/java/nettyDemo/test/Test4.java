package nettyDemo.test;

public class Test4 {
    String name;
    public void useInnerClass(int num){
        DataBean dataBean = new DataBean("shienlei");
        InnerClass innerClass = new InnerClass(){
            @Override
            void doSomething() {
                System.out.println("num = "+num);
                System.out.println("bean name is:"+dataBean.name);
            }
        };
        innerClass.doSomething();

    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        test4.useInnerClass(123);
    }
}
class InnerClass{
    void doSomething(){
        System.out.println("1234");

    }
}
class DataBean{
    public DataBean(String name){this.name =name;}
    public String name;
}
