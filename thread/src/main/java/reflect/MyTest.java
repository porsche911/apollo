package reflect;

public class MyTest {
    public static void main(String[] args) {
        try {
            Class.forName("reflect.ClassForName");
            System.out.println("=====================");
            ClassLoader.getSystemClassLoader().loadClass("reflect.ClassForName");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
