import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by zhukaihao on 16/6/22.
 */
public class ItemFileReader {

    public static void readCartItemFile(Vector<Item> vs, String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String barcode, name, unit, pricestr; //编号,名称,单位,单价(字符串)
            float price; //单价
            while (br.ready()) {

                String data = br.readLine();
                if (data == null)  //到达文件末尾
                    break;
                else {
                    if (-1 != (data.indexOf("barcode"))) {
                        //获取商品编号
                        barcode = data.substring(data.indexOf("'") + 1, data.lastIndexOf("'"));

                        //检查vs中是否已经有这个商品.若有,则数量加1;若没有,则添加为新条目
                        boolean has = false;
                        for (Item item : vs) {
                            if (barcode.equals(item.getBarcode())) {
                                has = true;
                                item.addNum();
                                break;
                            }
                        }

                        if (has) {
                            br.readLine();
                            br.readLine();
                            br.readLine();
                        } else {
                            //商品名称
                            data = br.readLine();
                            name = data.substring(data.indexOf("'") + 1, data.lastIndexOf("'"));
                            //商品单位
                            data = br.readLine();
                            unit = data.substring(data.indexOf("'") + 1, data.lastIndexOf("'"));
                            //商品单价
                            data = br.readLine();
                            pricestr = data.substring(data.indexOf(":") + 1);
                            price = Float.parseFloat(pricestr);

                            vs.add(new Item(barcode, name, unit, price));
                        }
                    }
                }
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
