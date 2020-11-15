package designModle.builder;

public class Test {
    public static void main(String[] args) {
        Person build = new Person.Builder(1, "shienlei").age(22).sex("男").desc("使用builder模式").build();
        System.out.println(build.toString());
    }
}
