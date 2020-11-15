package algorithm.coding.fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String[]> ywStoreList = new ArrayList<>(16);
        List<String[]> zfStoreList = new ArrayList<>(16);
        List<algorithm.coding.fourth.DataOut> res = new ArrayList<>(16);
        while (true){
            String line = br.readLine();
            //String [] tmp = new String[line.length()];
            if ("-1".equals(line)) break;
            String[] split = line.split(",");
            ywStoreList.add(split);
        }
        while (true){
            String line = br.readLine();
            //String [] tmp = new String[line.length()];
            if ("-1".equals(line)) break;
            String[] split = line.split(",");
            zfStoreList.add(split);
        }
        br.close();
        //将数据存储在ywStoreList和zfStoreList,处理数据
        //先判定是否存在重复数据
        res = repeateData(ywStoreList,zfStoreList,res);
        //判断是否存在数据条数确实
        res = luckData(ywStoreList,zfStoreList,res);
        //判断具体数据差异
        res = differentData(ywStoreList,zfStoreList,res);
        Collections.sort(res);
        for (DataOut re : res) {
            System.out.println(re.toString());
        }
    }

    /**
     * 判断具体数据差异,交易金额数据差异D，交易时间数据差异E，交易金额和交易时间数据差异DE
     * @param ywStoreList
     * @param zfStoreList
     * @param res
     * @return
     */
    private static List<DataOut> differentData(List<String[]> ywStoreList, List<String[]> zfStoreList,List<DataOut> res) {
        //先去重，通过hashset
        ywStoreList = discont(ywStoreList);
        zfStoreList = discont(zfStoreList);
        String ywOrderID = "";
        String ywTransPrice = "";
        String ywTransTime = "";
        String zfChannelID = "";
        String zfTransPrice = "";
        String zfTransTime = "";
        String reason = "";
        for (String[] strings : ywStoreList) {
            ywOrderID = strings[0];
            ywTransPrice = strings[2];
            ywTransTime = strings[3];
            DataOut dataOut = new DataOut();
            dataOut.setFlag(false);
            for (int i = 0; i < zfStoreList.size(); i++) {
                zfChannelID = zfStoreList.get(i)[0];
                zfTransPrice = zfStoreList.get(i)[2];
                zfTransTime = zfStoreList.get(i)[3];
                if (Arrays.toString(zfStoreList.get(i)).contains(ywOrderID)){
                    //开始具体数据对比
                    if (ywTransPrice.equals(zfTransPrice)){
                        if (!ywTransTime.equals(zfTransTime)){
                            reason = "E";
                            dataOut.setFlag(true);
                        }
                    }else {
                        reason = "D";
                        if (!ywTransTime.equals(zfTransTime)){
                            reason = "DE";
                        }
                        dataOut.setFlag(true);
                    }
                    if (dataOut.isFlag()){
                        dataOut.setYwOrderID(ywOrderID);
                        dataOut.setYwTransPrice(ywTransPrice);
                        dataOut.setYwTransTime(ywTransTime);
                        dataOut.setZfChannelID(zfChannelID);
                        dataOut.setZfTransPrice(zfTransPrice);
                        dataOut.setZfTransTime(zfTransTime);
                        dataOut.setReason(reason);
                        res.add(dataOut);
                    }

                }
            }
        }
        return res;
    }

    /**
     * 去重方法
     * @param storeList
     * @return
     */
    private static List<String[]> discont(List<String[]> storeList) {
        HashSet<String[]> set = new HashSet<>();
        for (String[] strings : storeList) {
            set.add(strings);
        }
        storeList.clear();
        for (String[] strings : set) {
            storeList.add(strings);
        }
        return storeList;
    }
    /**
     * 用于判断是否缺少数据条数
     * @param ywStoreList
     * @param zfStoreList
     * @param res
     * @return
     */
    private static List<DataOut> luckData(List<String[]> ywStoreList, List<String[]> zfStoreList,List<DataOut> res) {
        //交易数据仅在业务系统存在 +
        String ywOrderID = "";
        String ywTransPrice = "";
        String ywTransTime = "";
        String zfChannelID = "";
        String zfTransPrice = "";
        String zfTransTime = "";
        String reason = "";
        for (String[] strings : ywStoreList) {
            ywOrderID = strings[0];
            DataOut dataOut = new DataOut();
            dataOut.setFlag(false);
            for (int i = 0; i < zfStoreList.size(); i++) {
                if (Arrays.toString(zfStoreList.get(i)).contains(ywOrderID)){
                    dataOut.setFlag(true);//如果交易数据不在支付系统中存在，则为默认值false
                }
                }
            if (!dataOut.isFlag()){
                ywTransPrice = strings[2];
                ywTransTime = strings[3];
                zfChannelID = strings[4];
                reason = "+";
                dataOut.setYwOrderID(ywOrderID);
                dataOut.setYwTransPrice(ywTransPrice);
                dataOut.setYwTransTime(ywTransTime);
                dataOut.setZfChannelID(zfChannelID);
                dataOut.setReason(reason);
                res.add(dataOut);
            }
        }
        //判断数据只在交易系统中存在 -
        for (String[] strings : zfStoreList) {
            DataOut dataOut = new DataOut();
            zfChannelID = strings[0];
            dataOut.setFlag(false);
            for (int i = 0; i < ywStoreList.size(); i++) {
                if (Arrays.toString(ywStoreList.get(i)).contains(zfChannelID)){
                    dataOut.setFlag(true);
                }
            }
            if (!dataOut.isFlag()){
                ywOrderID = strings[1];
                zfChannelID = strings[0];
                zfTransPrice = strings[2];
                zfTransTime = strings[3];
                reason = "-";
                dataOut.setYwOrderID(ywOrderID);
                dataOut.setZfChannelID(zfChannelID);
                dataOut.setZfTransPrice(zfTransPrice);
                dataOut.setZfTransTime(zfTransTime);
                dataOut.setReason(reason);
                res.add(dataOut);
            }
        }
        return res;
    }

    /**
     * 用于判断业务数据和支付数据自身有无重复的情况
     * @param ywStoreList
     * @param zfStoreList
     * @param res
     * @return
     */
    private static List<DataOut> repeateData(List<String[]> ywStoreList, List<String[]> zfStoreList, List<DataOut> res) {
        String ywOrderID = "";
        String ywTransPrice = "";
        String ywTransTime = "";
        String zfChannelID = "";
        String zfTransPrice = "";
        String zfTransTime = "";
        String reason = "";
        int ywCount = 0;//记录业务数据重复的条数
        for (int i = 0; i < ywStoreList.size()-1; i++) {
            for (int j = i+1; j < ywStoreList.size(); j++) {
                if (Arrays.toString(ywStoreList.get(i)).equals(Arrays.toString(ywStoreList.get(j)))){
                    ywCount++;
                }
            }
            if (ywCount >0){
                //表示业务数据中有重复的数据
                DataOut dataOut = new DataOut();//该条数据的结果
                ywOrderID = ywStoreList.get(i)[0];
                ywTransPrice = ywStoreList.get(i)[2];
                ywTransTime = ywStoreList.get(i)[3];
                zfChannelID = ywStoreList.get(i)[4];
                reason = "F"+ywCount;
                dataOut.setYwOrderID(ywOrderID);
                dataOut.setYwTransPrice(ywTransPrice);
                dataOut.setYwTransTime(ywTransTime);
                dataOut.setZfChannelID(zfChannelID);
                dataOut.setReason(reason);
                res.add(dataOut);
            }
        }
        int zfCount = 0; //记录支付数据中重复的条数
        for (int i = 0; i < zfStoreList.size() - 1; i++) {
            for (int j = i+1; j < zfStoreList.size(); j++) {
                if (Arrays.toString(zfStoreList.get(i)).equals(Arrays.toString(zfStoreList.get(j)))){
                    zfCount++;
                }
            }
            if (zfCount > 0){
                //表示支付数据中有重复的数据
                DataOut dataOut = new DataOut();//该条数据的结果
                ywOrderID = zfStoreList.get(i)[1];
                zfChannelID = zfStoreList.get(i)[0];
                zfTransPrice = zfStoreList.get(i)[2];
                zfTransTime = zfStoreList.get(i)[3];
                reason = "G"+zfCount;
                dataOut.setYwOrderID(ywOrderID);
                dataOut.setZfChannelID(zfChannelID);
                dataOut.setZfTransPrice(zfTransPrice);
                dataOut.setZfTransTime(zfTransTime);
                dataOut.setReason(reason);
                res.add(dataOut);
            }
        }

        return res;
    }
}
class DataOut implements Comparable<DataOut> {
    String ywOrderID;
    String ywTransPrice;
    String ywTransTime;
    String zfChannelID;
    String zfTransPrice;
    String zfTransTime;
    String reason;
    boolean flag;

    public String getYwTransTime() {
        return ywTransTime;
    }

    public String getZfTransTime() {
        return zfTransTime;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setYwOrderID(String ywOrderID) {
        this.ywOrderID = ywOrderID;
    }

    public void setYwTransPrice(String ywTransPrice) {
        this.ywTransPrice = ywTransPrice;
    }

    public void setYwTransTime(String ywTransTime) {
        this.ywTransTime = ywTransTime;
    }

    public void setZfChannelID(String zfChannelID) {
        this.zfChannelID = zfChannelID;
    }

    public void setZfTransPrice(String zfTransPrice) {
        this.zfTransPrice = zfTransPrice;
    }

    public void setZfTransTime(String zfTransTime) {
        this.zfTransTime = zfTransTime;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    //(x < y) ? -1 : ((x == y) ? 0 : 1)
    @Override
    public String toString() {
        return ((ywOrderID == null)? "": ywOrderID)  +
                "," + ((ywTransPrice == null)? "":ywTransPrice)  +
                "," + ((ywTransTime == null)? "":ywTransTime)  +
                "," + ((zfChannelID == null)? "":zfChannelID)  +
                "," + ((zfTransPrice == null) ? "":zfTransPrice)  +
                "," + ((zfTransTime == null) ? "":zfTransTime)  +
                "," + ((reason == null) ? "": reason);
    }
    @Override
    public int compareTo(DataOut that) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            if (this.getYwTransTime() != that.getYwTransTime()){
                Date thisYwTransTime = dateFormat.parse(this.getYwTransTime());
                Date thatYwTransTime =dateFormat.parse(that.getYwTransTime());
                return Long.compare(thisYwTransTime.getTime(),thatYwTransTime.getTime());
        }else {
                Date thisZfTransTime = dateFormat.parse(this.getYwTransTime());
                Date thatZfTransTime = dateFormat.parse(that.getYwTransTime());
                return Long.compare(thisZfTransTime.getTime(),thatZfTransTime.getTime());
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
