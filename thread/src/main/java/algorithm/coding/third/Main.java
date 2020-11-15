package algorithm.coding.third;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 S22 bind  No3
 S22 bind  No4
 U22 scan No3
 U22 scan No4
 -1
 S22 bind success
 S22 bind fail
 U22 pay to S22
 U22 scan fail


 S22 bind No3
 S23 bind No4
 U22 scan No3
 U22 scan No4
 S22 unbind No3
 U22 scan No3
 U22 scan No4
 U21 bind No3
 -1

 S22 bind success
 S23 bind success
 U22 pay to S22
 U22 pay to S23
 S22 unbind success
 U22 scan fail
 U22 pay to S23
 unknown command
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (br == null) return;
        List<String> res = new ArrayList<>();//存放结果
        HashMap<String, String> bindMap = new HashMap<>(16);//一个商家只能绑定一个二维码 商家与二维码的对应
        HashMap<String, String> codebindMap = new HashMap<>(16);//二维码与商家进行对应
        while (true){
            String s = br.readLine().trim();
            if ("-1".equals(s)){
                break;
            }
            String[] split = s.split(" ");
            String key = split[0];
            String opt = split[1];
            String value = split[2];
            String result = "";
            //S1 bind success
            //S1 bind fail
            if ("bind".equals(opt)){
                if (key.startsWith("U")){
                    //用户进行绑定操作，输出unknown command
                    result = "unknown command";
                    res.add(result);
                    continue;
                }
                if (bindMap.containsKey(key)){
                    //该商户已绑定二维码,不能再重新绑定
                    result = key + " "+"bind fail";
                    res.add(result);
                    continue;
                }
                /*if (bindMap.containsValue(value)){
                    //该二维码已被绑定，不能再被其它商家绑定
                    continue;

                }*/
                bindMap.put(key,value);
                codebindMap.put(value,key);
                result = key + " "+ "bind success";
                res.add(result);
                continue;
            }
            //S1 unbind success
            //S1 unbind fail
            if ("unbind".equals(opt)){
                if (bindMap.containsKey(key)){
                    result = key + " unbind success";
                    res.add(result);
                    //解绑成功后，将信息移除
                    bindMap.remove(key);
                    codebindMap.remove(bindMap.get(key));
                    continue;
                }else {
                    result = key + " unbind fail";
                    res.add(result);
                    continue;
                }
            }
            //U1 pay to S22 #可以扫码付款给对应商家
            //U1 scan fail     #任意错误导致的不能执行付款
            if ("scan".equals(opt)){
                if (bindMap.containsValue(value)){
                    result = key+" pay to "+codebindMap.get(value);
                    res.add(result);
                    continue;
                }else {
                    result = key + " scan fail";
                    res.add(result);
                    continue;
                }
            }
        }
        br.close();
        for (String re : res) {
            System.out.println(re);
        }
    }
}
