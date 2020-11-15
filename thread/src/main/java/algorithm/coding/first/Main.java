package algorithm.coding.first;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Main {
    public static void main(String[] args) throws IOException {
        List<String> stringList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (br == null) return;
        int dateNum = 0;
        String date = br.readLine();
        if (date !=null || date != ""){
            dateNum = Integer.parseInt(date);
        }
        String miwen = "";
        while (true){
            String s = br.readLine().trim();
            char start = s.charAt(0);
            if (start>='0' && start <='9'){
                miwen = s.trim();
                break;
            }
            stringList.add(s);
        }
        br.close();
        //将输入数据全部放入到stringList中
        //将密文放入到queue中
        Queue<Integer> queue = new LinkedList<Integer>();
        String[] split = miwen.split("");
        for (int i = 0; i < split.length; i++) {
            int miwenInt = Integer.parseInt(split[i]);
            queue.add(miwenInt);
        }
        ArrayList<Character> res = new ArrayList<>(16);
        int lineOff = 1;
        int count = 1;
        for (int i = dateNum-1; i < stringList.size(); i++) {
            //有两个位置，需要确定，倾斜45的偏移后的位置lineOff，密文左移后的位置tmpOff
            //lineOff，在长度范围之内，lineOff++,2、超过指定长度，lineOff--
            //tmpOff = lineOff + q,1、在长度之内，2、超过指定长度。lineOff + q-lineLength
            if (queue.isEmpty()) break;
            int tmpOff = 0;
            Character s = ' ';
            int q = queue.poll();
            String tmp = stringList.get(i);
            int lineLength = tmp.length();
            int modle = count /lineLength;
            if (modle % 2 ==0){
                //此时是右移操作
                tmpOff = lineOff +q;
                //无跨行操作
                if (tmpOff<=lineLength){
                    s = tmp.charAt(tmpOff-1);
                    res.add(s);
                }else {
                    //此时需要换行操作
                    tmp = stringList.get(i+1);
                    int index= tmpOff-lineLength-1;
                    s =tmp.charAt(index);
                    res.add(s);
                }
                lineOff++;
            }
            if (modle % 2 !=0){
                //此时左移操作
                tmpOff = lineOff +q;
                //无需跨行操作
                if (tmpOff<=lineLength){
                    s = tmp.charAt(tmpOff-1);
                    res.add(s);
                }else {
                    //此时需要换行操作
                    tmp = stringList.get(i+1);
                    int index= tmpOff-lineLength-1;
                    s =tmp.charAt(index);
                    res.add(s);
                }
                lineOff--;
            }
            count++;
        }
        for (Character re : res) {
            System.out.print(re);
        }
    }
}
