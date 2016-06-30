
/**
 * 需求一、二
 */


import java.util.*;


public class Requirement_1_2 {
        public static void main(String[] args){

            //取得购物车信息,打折商品信息
            List<Item> cartList=ItemFileReader.readCartJSONToList("cart_item.json");
            List<Item> discountList=ItemFileReader.readDiscountJSONToList("discount_item.json");

            //整理购物车信息
            List<Item> items=new ArrayList<Item>();
            for(Item i:cartList){
                //是否已存在该商品信息,如存在,该商品数量加一
                boolean has=false;
                for(Item j:items){
                    if(i.getBarcode().equals(j.getBarcode())){
                        j.addNum();
                        has=true;
                        break;
                    }
                }
                //如果不存在,添加该商品
                if(!has){
                    items.add(new Item(i.getBarcode(),i.getName(),i.getUnit(),i.getPrice()));
                }
            }
            //打折商品
            for(Item i:discountList){
                for(Item j:items){
                    if(j.getBarcode().equals(i.getBarcode())){
                        j.setDiscount(i.getDiscount());
                    }
                }
            }
            //输出
            float allPrice=0;
            float savePrice=0;
            System.out.println("***商店购物清单***");
            for(Item i:items) {
                System.out.println(i.toString());
                allPrice+=i.allPrice();
                savePrice+=i.savePrice();
            }
            System.out.println("----------------------");
            System.out.printf("总计:%.2f(元)\n",allPrice);
            if(savePrice!=0)
                System.out.printf("节省:%.2f(元)\n",savePrice);
            System.out.println("**********************");
        }
}
