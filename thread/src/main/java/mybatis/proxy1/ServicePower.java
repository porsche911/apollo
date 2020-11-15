package mybatis.proxy1;

import mybatis.services.Service;

public class ServicePower implements Service {
    Service target;

    public ServicePower(Service target) {
        this.target = target;
    }

    @Override
    public void query() {
        System.out.println("power");
        target.query();
    }
}
