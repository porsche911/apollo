package aqs;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public void a(){

    }

    public static void main(String[] args) {
        Map map = new HashMap();
        Object shienlei = map.get("shienlei");
        if (shienlei ==null){
            System.out.println("1234");
        }
    }
}
