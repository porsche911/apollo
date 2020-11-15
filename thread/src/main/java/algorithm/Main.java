package algorithm;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         List<String> list1 = new ArrayList<>();
         while (scanner.hasNext()){
             String line = scanner.nextLine();
             if (line.equals("-1")){
                 break;
             }
             list1.add(line);
         }
         List<String> list2 = new ArrayList<>();
         while (scanner.hasNext()){
             String line = scanner.nextLine();
             if (line.equals("-1")){
                 break;
             }
             list2.add(line);
         }
         //再将list中的数据整成数组
         List<Map> lista1 = new ArrayList();
         List<Map> lista2 = new ArrayList();
         //业务订单号，姓名，交易金额，交易时间，支付流水
         //支付流水，业务订单号，交易金额，交易时间，支付时间
         //
         for (String s : list1) {
             HashMap<String, String> transMap = new HashMap<>(16);
             String[] strings = s.split(",");
             transMap.put("transOrderID",strings[0]);
             transMap.put("name",strings[1]);
             transMap.put("transAmt",strings[2]);
             transMap.put("transTime",strings[3]);
             transMap.put("transNum",strings[4]);
             lista1.add(transMap);
         }
         for (String s : list2) {
             HashMap<String, String> orderMap = new HashMap<>(16);
             String[] strings = s.split(",");
             orderMap.put("transNum",strings[0]);
             orderMap.put("transOrderID",strings[1]);
             orderMap.put("transAmt",strings[2]);
             orderMap.put("transTime",strings[3]);
             orderMap.put("orderTime",strings[5]);
             lista2.add(orderMap);
         }
         //错误情况:
         //业务系统和支付系统同一笔交易的数据存在差异
         //交易数据在业务系统中存在，在支付系统中不存在
         //交易数据在支付系统中存在，在业务系统中不存在
         //业务系统中存在重复数据
         //交易数据中存在重复数据
         List<Map> resultList = new ArrayList<>();
         //输出格式
         //、先后打印数据差异，按照交易时间(优先使用业务数据中交易时间，如果无业务交易时间就使用支付数据中的交易时间)升序排列
         //2、无交易数据或业务数据的字段输出空，以逗号分隔
         //先判断是否有重复
         for (int i = 0; i < lista1.size(); i++) {
             lista1.get(i);
         }
         for (int i = 0; i < lista1.size(); i++) {
             for (int j = i; j < lista2.size(); j++) {
                 //先判断业务数据是否有重复
                 if (lista1.get(i).get("transOrderID").equals(lista2.get(j).get("transOrderID"))){
                     //业务订单号相等,比较订单金额和交易时间
                     if (lista1.get(i).get("transAmt").equals(lista2.get(j).get("transAmt")) && lista1.get(i).get("transTime").equals(lista2.get(j).get("transTime"))){
                         //该订单没问题
                     }else {
                         //交易金额没问题,再判断交易时间
                         if (!lista1.get(i).get("transTime").equals(lista2.get(j).get("transTime"))){
                             //交易时间有问题
                             HashMap<String, String> resultMap = new HashMap<>(16);
                             //resultMap
                             resultList.add(lista2.get(j));
                         }else {
                             //交易金额有问题
                             resultList.add(lista2.get(j));
                         }
                     }
                 }
             }
         }
     }
}
