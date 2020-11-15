package spring;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass("xx", new Class[]{I.class});
        File file =new File("/Users/shienlei/Documents/xx.class");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(proxyClassFile);
        fileOutputStream.flush();
        fileOutputStream.close();

    }
}
