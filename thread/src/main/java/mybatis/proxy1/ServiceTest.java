package mybatis.proxy1;

import mybatis.services.Service;

public class ServiceTest implements Service {
    @Override
    public void query() {
        System.out.println("test--------");
    }
}
