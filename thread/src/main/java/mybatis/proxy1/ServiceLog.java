package mybatis.proxy1;

import mybatis.services.Service;

public class ServiceLog implements Service {
    Service target;

    public ServiceLog(Service target) {
        this.target = target;
    }

    @Override
    public void query() {
        System.out.println("log");
        target.query();
    }
}
