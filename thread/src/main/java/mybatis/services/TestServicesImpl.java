package mybatis.services;

public class TestServicesImpl implements TestService {
    @Override
    public void query1() {
        System.out.println("xxxxxxx");
    }

    @Override
    public void update() {
        //return "i am proxy!";
        System.out.println("i am proxy!");
    }
}
