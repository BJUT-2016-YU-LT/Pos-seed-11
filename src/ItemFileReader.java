import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.List;
import com.alibaba.fastjson.JSON;

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

}
