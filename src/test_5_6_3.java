import java.util.List;

/**
 * Created by user on 2016/6/30.
 */
public class test_5_6_3 {

    public static void main(String[] args) {

        //取得用户列表
        List<UserInfo> users = ItemFileReader.readUserListJSONToList("user_list.json");

        //取得商品索引列表
        List<Item> goodsIndex=ItemFileReader.readGoodsIndexJSONToList("user_goods_index2.json");

        //取得用户商品列表
        UserGoods userGoods=ItemFileReader.readUserGoodsListJSONToUserGoods("user_goods_list2.json");

        //获取当前用户
        UserInfo user=new UserInfo();
        for(UserInfo u:users){
            if(userGoods.getUser().equals(u.getName())){
                user=u;
            }
        }

        //是否是会员
        boolean isVip=false;
        if(user.isVip())
            isVip=true;
        else
            isVip=false;

        //整理购物车信息,计算数量
        //是否有买二赠一产品
        boolean hasPromotion=false;
        for (String itemName : userGoods.getItems()) {
            for (Item item : goodsIndex) {
                if (itemName.equals(item.getBarcode())) {
                    item.addNum();
                }
                if (item.getPromotion()) {
                    hasPromotion=true;
                }
            }
        }

        //计算总价
        float allPrice = 0;
        float savePrice = 0;
        for (Item i : goodsIndex) {
            if(0!=i.getNumber()){
                if(isVip){
                    //是vip
                    allPrice += i.allPriceOfVip();
                    savePrice += i.savePriceOfVip();
                }
                else{
                    //不是vip
                    allPrice += i.allPrice();
                    savePrice += i.savePrice();
                }
            }
        }

        //输出
        System.out.println("***商店购物清单***");
        if(isVip){
            if(user.getGrades()<=200){
                user.setGrades(user.getGrades()+(int)allPrice/5);
            }else if(user.getGrades()>200&&user.getGrades()<=500){
                user.setGrades(user.getGrades()+(int)allPrice/5*3);
            }else {
                user.setGrades(user.getGrades()+(int)allPrice/5*5);
            }
            System.out.println("会员编号:"+user.getName()+" 会员积分:"+user.getGrades()+"分");
        }
        System.out.println("----------------------");
        System.out.println("打印时间：2014年08月04日 08:09:05");
        System.out.println("----------------------");
        for (Item i : goodsIndex) {
            //打印商品索引中数量不为0的商品信息
            if(0!=i.getNumber()){
                if(isVip){
                    //是vip
                    System.out.println(i.toStringOfVip());
                }
                else{
                    //不是vip
                    System.out.println(i.toString());
                }
            }
        }
        System.out.println("----------------------");

        if(!isVip) {
            if(hasPromotion) {
                System.out.println("挥泪赠送商品:");
                for (Item i : goodsIndex) {
                    if (i.getPromotion()) {
                        System.out.printf("名称:%s, 数量:%d%s\n", i.getName(), i.getNumber() / 2,i.getUnit());
                    }
                }
                System.out.println("----------------------");
            }
        }

        System.out.printf("总计:%.2f(元)\n", allPrice);
        if (savePrice != 0)
            System.out.printf("节省:%.2f(元)\n", savePrice);
        System.out.println("**********************");

    }
}
