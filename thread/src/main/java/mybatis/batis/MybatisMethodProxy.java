package mybatis.batis;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


/**
 * 通过一个接口就可以产生代理对象
 * 每一个对象都有一个类文件，只是动态代理的类文件是动态生成的，我们看不到
 */
public class MybatisMethodProxy {
    public static Object getInstance(Class clazz,CustomerMybatisInvocationHandler h) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //接口可以通过对象得到
        //Class clazz = target.getClass().getInterfaces()[0];
        String infName= clazz.getSimpleName();
        Class clazh = h.getClass().getInterfaces()[0];
        String cinfName= clazh.getSimpleName();
        String content = "";
        String line = "\n";//换行
        String tab = "\t";//tab键
        String packageContent= "package mybatis.baidu;"+line;
        String importContent = "import "+clazz.getName()+";"+line
                                +"import mybatis.batis.CustomerMybatisInvocationHandler;"+line
                                +"import java.lang.Exception;"+line
                                +"import java.lang.reflect.Method;"+line;
        String clazzFirstLineContent = "public class $ProxyMybatis implements "+infName+"{"+line;
        String filedContent = tab + "private CustomerMybatisInvocationHandler h;"+line;
        String constructorContent = tab+"public $ProxyMybatis ("+cinfName+" target){"+line
                +tab+tab+"this.h = target;"
                +line+tab+"}"+line;
        String methodContent = "";
        Method methods[] = clazz.getDeclaredMethods();
        for (Method method : methods) {
            String returnTypeName= method.getReturnType().getSimpleName();
            String methodName = method.getName();
            Class args[] = method.getParameterTypes();
            String argsContent = "";
            String paramsContents = "";
            int flag = 0;
            //query(String s,int a){
            // target.query(s,a)}
            for (Class arg : args) {
                String temp = arg.getSimpleName();
                argsContent+= temp+" p"+flag+",";
                paramsContents+="p"+flag+",";
                flag++;
            }
            if (argsContent.length()>0){
                argsContent = argsContent.substring(0,argsContent.lastIndexOf(","));
                paramsContents = paramsContents.substring(0,paramsContents.lastIndexOf(","));
            }
            //最好实现代理逻辑也动态
            // invocation.invoke();
            //Class aClass = invocation.getClass().getInterfaces()[0];
            //每个方法对应一个Method类，所以会返回一个Method数组
            //Method invokeMethods = aClass.getMethods()[0];
            //String invokeMethodsName = invokeMethods.getName();
            //String objectName = invocation.toString();

            methodContent+=tab+"public "+returnTypeName+" "+methodName+"("+argsContent+") throws Exception {"+line
                    +tab+tab+"Method method =Class.forName(\""+clazz.getName()+"\").getDeclaredMethod(\""+methodName+"\");"+line
                    +tab+tab+"h.invoke(method);"+line;
            methodContent+=tab+"}"+line;
        }
        content=packageContent+importContent+clazzFirstLineContent+filedContent+constructorContent+methodContent+
                "}";
        File file = new File("/Users/shienlei/IdeaProjects/test/mybatis/baidu/$ProxyMybatis.java");
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将.java类文件编译成.class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileMgr.getJavaFileObjects(file);
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
        t.call();

        //URL[] urls1 = new URL[]{new URL("file:D:\\\\")};
        URL[] urls = new URL []{new URL("file:/Users/shienlei/IdeaProjects/test/")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class loadClass = urlClassLoader.loadClass("mybatis.baidu.$ProxyMybatis");
        System.out.println(loadClass);
        Constructor constructor = loadClass.getConstructor(clazh);
        Object o = constructor.newInstance(h);//通过有参构造器生成对象
        return o;
    }
}
