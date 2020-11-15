package algorithm.coding.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 以递归的方法来解决该题
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>(16);
        if (br == null) return;
        String s = br.readLine().trim();
        br.close();
        String[] strings = s.split(" ");
        int iterNum = Integer.parseInt(strings[0]); //决斗的轮数
        int length = strings.length;
        Integer[] peoples = new Integer[length-1];
        for (int i = 0; i < length - 1; i++) {
            peoples[i] = Integer.parseInt(strings[i+1]);
        }
        Set<String> hashSet = new HashSet<>();
        hashSet = getResult(peoples,iterNum,hashSet);
        System.out.println(hashSet.size());
    }

    private static Set<String> getResult(Integer[] peoples, int iterNum, Set<String> hashSet) {
        if (iterNum == 0){
            hashSet.add(Arrays.toString(peoples));
            return hashSet;
        }
        int length = peoples.length;
        for (int i = 0; i < length-1; i++) {
            if (peoples[i] == 0) continue;
            for (int j = i+1; j < length; j++) {
                if (peoples[j] == 0) continue;
                Integer[] tmp = Arrays.copyOfRange(peoples,0,length);
                if (tmp[i] >= tmp[j]){
                    tmp[i] = tmp[i]-tmp[j];
                    tmp[j] = 0;
                }
                if (tmp[i] < tmp[j]){
                    tmp[j] = tmp[j]-tmp[i];
                    tmp[i] = 0;
                }
                getResult(tmp,iterNum-1,hashSet);
            }
        }
        return hashSet;
    }
}
