package mybatis.proxy;

import mybatis.services.IndexService;

public class IndexServiceProxyLog extends IndexService {
    @Override
    public void query() {
        System.out.println("start log");
        //目标对象的逻辑
        super.query();
    }
}
