package nettyDemo.test;

import com.google.common.collect.ImmutableList;


import java.util.Iterator;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        String[] strs = {"shienlei","公众号;123","地址：123"};
        for (String str : strs) {
            System.out.println(str);
        }
        List stringList = ImmutableList.of("shienlei","123","地址：123","公众号");
        String s;
        for(Iterator iterator = stringList.iterator();iterator.hasNext(); System.out.println(s))
            s=(String) iterator.next();
    }
}
