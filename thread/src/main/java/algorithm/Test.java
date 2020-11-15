package algorithm;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        Scanner scanner1 =new Scanner(next);*/
        //List<String> list = new ArrayList<>();
        ArrayList<Data> data1 = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        HashSet<List<String>> hashSet = new HashSet<>();
        HashSet<Data> dataHashSet = new HashSet<>();
        HashMap<List<String>, String> hashMap = new HashMap<>(16);
        HashMap<String[], String> hashMap1 = new HashMap<>();
        new HashMap<String[], String>();
        Integer tmp;
        //Data data =new Data();
        for (int i = 0; i < 5; i++) {
            //String[] strings = {"a"};
            //strings.hashCode();
            //hashMap1.put(strings,String.valueOf(i));
            List<String> list = new ArrayList<>();
            list.add("a");
            //list.hashCode();
            //int h = (list == null) ? 0 : (h = list.hashCode()) ^ (h >>> 16);

            //list.hashCode() ^ (list.hashCode() >>> 16);
            //hashSet.add(list);
            hashMap.put(list,String.valueOf(i));
            //tmp = String.valueOf(i);
            //list.add(tmp);
            /*data.setA(String.valueOf(i));
            data.setB(String.valueOf(i+10));
            data1.add(data);*/
            //tmp = i;
            //integers.add(tmp);
            /*Data data = new Data();
            data.setA("a");
            data.setB("b");
            dataHashSet.add(data);*/
        }
        for (List<String> stringList : hashMap.keySet()) {
            System.out.println(stringList);
        }
        /*for (List<String> strings : hashSet) {
            System.out.println(strings.get(0));
        }*/
        /*for (String s : list) {
            System.out.println(s);
        }*/
       /* for (Data data2 : data1) {
            System.out.println(data2.toString());
        }*/
        /*for (Integer integer : integers) {
            System.out.println(integer);
        }*/
        for (Data data : dataHashSet) {
            System.out.println(data.toString());
        }
    }
}
class Data {
    String a;
    String b;

    @Override
    public String toString() {
        return "Data{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
