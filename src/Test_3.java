/**
 * 需求四
 * Created by zhukaihao on 16/6/26.
 */


import java.util.*;

public class Test_3 {
    public static void main(String[] args) {
        //取得商品索引,商品列表
        List<Item> cartIndex = ItemFileReader.readGoodsIndexJSONToList("goods_promotion.json");
        List<String> goodsList = ItemFileReader.readGoodsListJSONToList("goods_list_prom.json");

        //整理购物车信息
        for (String str : goodsList) {
            for (Item j : cartIndex) {
                if (str.equals(j.getBarcode())) {
                    j.addNum();
                }
            }
        }

        //输出
        float allPrice = 0;
        float savePrice = 0;
        System.out.println("***商店购物清单***");
        System.out.println("打印时间：2014年08月04日 08:09:05");
        System.out.println("----------------------");
        for (Item i : cartIndex) {
            System.out.println(i.toString());
            allPrice += i.allPrice();
            savePrice += i.savePrice();
        }
        System.out.println("----------------------");
        System.out.println("挥泪赠送商品:");
        for (Item i : cartIndex) {
            if(i.getPromotion()){
                System.out.printf("名称:%s, 数量:%d瓶\n", i.getName(),i.getNumber()/2);
            }
        }
        System.out.println("----------------------");
        System.out.printf("总计:%.2f(元)\n", allPrice);
        if (savePrice != 0)
            System.out.printf("节省:%.2f(元)\n", savePrice);
        System.out.println("**********************");
    }
}
