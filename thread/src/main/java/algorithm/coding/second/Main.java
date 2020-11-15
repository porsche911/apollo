package algorithm.coding.second;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Main {
    public static void main(String[] args) throws IOException {
        List<Set<List<Integer>>> result = new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> list = new ArrayList<>(16);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (br == null) return;
        String s = br.readLine().trim();
        br.close();
        String[] strings = s.split(" ");
        int iterNum = Integer.parseInt(strings[0]);
        int length = strings.length;
        for (int i = 1; i < length; i++) {
            list.add(Integer.parseInt(strings[i]));
        }
        //处理多次迭代的情况
        res.add(list);
        result.add(res);
        for (int i = 0; i < iterNum; i++) {
            result = helper1(result,result.get(i),i);
        }
        System.out.println(result.get(iterNum).size());
    }
    private static List<Set<List<Integer>>> helper1(List<Set<List<Integer>>> result, Set<List<Integer>> lists,int m) {
        Set<List<Integer>> res = new HashSet<>();
        for (List<Integer> list : lists) {
            for (int i = 0; i < list.size()-1; i++) {
                for (int j = i+1; j < list.size(); j++) {
                    List<Integer> tmp = new ArrayList<>();
                    int a = list.get(i);
                    int b = list.get(j);
                    if (a==0 || b==0){
                        continue;
                    }
                    if (a >=b){
                        a= a-b;
                        b=0;
                        //组成新的数组
                        for (int k = 0; k < list.size(); k++) {
                            if (k==i){
                                tmp.add(k,a);
                            }else if (k==j){
                                tmp.add(k,b);
                            }else {
                                tmp.add(k,list.get(k));
                            }
                        }
                        res.add(tmp);
                    }else {
                        b= b-a;
                        a=0;
                        //组成新的数组
                        for (int k = 0; k < list.size(); k++) {
                            if (k==i){
                                tmp.add(k,a);
                            }else if (k==j){
                                tmp.add(k,b);
                            }else {
                                tmp.add(k,list.get(k));
                            }
                        }
                        res.add(tmp);
                    }
                }
            }
        }
        result.add(m+1,res);
        return result;
    }
}
