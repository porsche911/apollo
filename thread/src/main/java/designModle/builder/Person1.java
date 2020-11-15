package designModle.builder;

public class Person1 {
    //必要参数
    private final int id;
    private final String name;
    //可选参数
    private int age;
    private String sex;
    private String phone;
    private String address;
    private String desc;

    public Person1(int id, String name){
        this(id,name,0);
    }
    public Person1(int id, String name, int age) {
        this(id, name, age, "");
    }
    public Person1(int id, String name, int age, String sex) {
        this(id, name, age, sex, "");
    }
    public Person1(int id, String name, int age, String sex, String phone) {
        this(id, name, age, sex, phone, "");
    }
    public Person1(int id, String name, int age, String sex, String phone,
                   String address) {
        this(id, name, age, sex, phone, address, "");
    }
    public Person1(int id, String name, int age, String sex, String phone,
                   String address, String desc) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
        this.desc = desc;
    }

}
