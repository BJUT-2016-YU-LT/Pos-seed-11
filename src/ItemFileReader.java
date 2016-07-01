import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * Created by zhukaihao on 16/6/22.
 */
public class ItemFileReader {

    /**
     * 读取购物车文件内容,保存入List中
     * @param fileName 购物车文件名
     */
    public static List<Item> readCartJSONToList(String fileName) {
        String str=readFileToString(fileName);
        List<Item> list=JSON.parseArray(str,Item.class);
        return list;
    }

    /**
     * 读取打折文件内容,保存入List中
     * @param fileName 打折文件名
     */
    public static List<Item> readDiscountJSONToList(String fileName) {
        String str=readFileToString(fileName);
        List<Item> list=JSON.parseArray(str,Item.class);
        return list;
    }

    /**
     * 读取商品索引文件,保存入List中
     * 商品number均为0
     * @param fileName 打折文件名
     */
    public static List<Item> readGoodsIndexJSONToList(String fileName) {
        String str=readFileToString(fileName);
        Map<String,Item> map=JSON.parseObject(str, new TypeReference<Map<String, Item>>() {});
        List<Item> list=new ArrayList<Item>();
        //遍历map
        for(String key:map.keySet()){
            Item i=map.get(key);
            list.add(new Item(key,i.getName(),i.getUnit(),i.getPrice(),i.getDiscount(),i.getVipDiscount(),i.getPromotion()));
        }
        for(Item i:list){
            i.setNumber(0);
        }
        return list;
    }


    /**
     * 读取商品列表文件,保存入List中
     * @param fileName 打折文件名
     */
    public static List<String> readGoodsListJSONToList(String fileName) {
        String str=readFileToString(fileName);
        List<String> list=JSON.parseArray(str,String.class);
        return list;
    }


    /**
     * 读取用户列表文件,保存入List中
     * @param fileName 用户列表
     */
    public static List<UserInfo> readUserListJSONToList(String fileName) {
        String str=readFileToString(fileName);
        Map<String, UserInfo> map=JSON.parseObject(str, new TypeReference<Map<String, UserInfo>>() {});
        List<UserInfo> list=new ArrayList<UserInfo>();
        //遍历map
        for(String key:map.keySet()){
            UserInfo i=map.get(key);
            list.add(new UserInfo(i.getName(),i.isVip(),i.getGrades()));
        }
        return list;
    }

    /**
     * 读取用户商品列表,保存入UserGoods对象中
     * @param fileName 打折文件名
     */
    public static UserGoods readUserGoodsListJSONToUserGoods(String fileName) {
        String str=readFileToString(fileName);
        UserGoods userGoods=JSON.parseObject(str, UserGoods.class);
        return userGoods;
    }


    /**
     * 读取文件所有内容到字符串
     * @param fileName JSON文件名
     */
    public static String readFileToString(String fileName) {

        String allstr=""; // 文件所有的内容
        String line=""; // 下一行的内容
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            // 读取文件所有内容
            while (br.ready()) {
                line = br.readLine(); //读取一行
                allstr+=line;
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allstr;
    }

    /**
     * 将会员信息写入文件
     * @param user
     * @param fileName
     */
    public static void writeUserToFile(UserInfo user,String fileName){
        //读取现在的会员文件内容
        String str=readFileToString(fileName);
        Map<String, UserInfo> map=JSON.parseObject(str, new TypeReference<Map<String, UserInfo>>() {});
        List<UserInfo> list=new ArrayList<UserInfo>();
        //遍历map
        for(UserInfo u:map.values()){
            if(u.getName().equals(user.getName()))
                u.setGrades(user.getGrades());
        }
        String userinfo=JSON.toJSONString(map);
        try {
            FileWriter fr = new FileWriter(fileName);
            fr.write(userinfo);
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
