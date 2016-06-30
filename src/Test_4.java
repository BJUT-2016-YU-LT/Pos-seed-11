/**
 * Created by zhukaihao on 16/6/30.
 * 迭代3测试文件
 */

import java.util.*;

public class Test_4 {
    public static void main(String[] args) {

        //取得用户列表
        List<UserInfo> users = ItemFileReader.readUserListJSONToList("user_list.json");

        //取得商品索引列表
        List<Item> goodsIndex=ItemFileReader.readGoodsIndexJSONToList("user_goods_index.json");

        //取得用户商品列表
        UserGoods userGoods=ItemFileReader.readUserGoodsListJSONToList("user_goods_list.json");

    }
}
