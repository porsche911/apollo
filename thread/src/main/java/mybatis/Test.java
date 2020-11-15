package mybatis;

import mybatis.batis.*;
import mybatis.proxy1.ServiceTest;
import mybatis.services.*;
import spi.demo1.IShout;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.util.ServiceLoader;

public class Test {
    public static void main(String[] args) throws Exception {
        //System.out.println("1234");
       /* AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(ac.getBean(AppConfig.class));*/

        /*DataSource dataSource = null;
        TransactionFactory transactionFactory =
                new JdbcTransactionFactory();
        Environment environment =
                new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        //dao层
        configuration.addMapper(AppConfig.class);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AppConfig mapper = sqlSession.getMapper(AppConfig.class);*/
        //得到一个实现了UserDao接口的对象
        //UserDao userDao = (UserDao) MybatisFactory.getMapper(UserDao.class);
        //完成数据库的查询功能
        //userDao.query();
        /*IndexService proxyLog = new IndexServiceProxyLog();
        proxyLog.query();
        System.out.println("=============");

        IndexService logPower = new IndexServiceProxyLogPower();
        logPower.query();
        System.out.println("==============");
        IndexService indexService = new IndexServiceProxyPowerLog();
        indexService.query();*/
       /* Service target = new ServiceLog(new IndexService());
        Service proxy = new ServicePower(target);
        proxy.query();*/
        //Service service= (Service) MybatisProxy.getInstance(Service.class);
        //service.query();
        //Service service = new ServiceTest();
        //InvocationHandler invocationHandler = new MybatisInvoke();
        //自定义的动态代理
        /*TestService testService =new TestServicesImpl();
        TestService service2 = (TestService) MybatisProxy.getInstance(testService);
        String update = service2.update();
        System.out.println(update);*/
        //jdk自己实现的
        /*TestService service = (TestService) Proxy.newProxyInstance(
                Test.class.getClassLoader(),new Class[]{TestService.class},new TestInvocationHandler(new TestServicesImpl()));
        service.query1();
        service.update();*/
        //我自己实现的
        /*TestService testService = (TestService) MybatisMethodProxy.getInstance(TestService.class,new TestCustomerInvocationHandler(new TestServicesImpl()));
        testService.update();*/
        /*ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        for (IShout shout : shouts) {
            shout.shout();
        }*/
        //System.in.read();
        String str1 = "11";
        System.out.println(str1);
        char[] arr = new char[]{'1','2'};
        //while (true);
    }
}
