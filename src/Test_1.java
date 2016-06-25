import java.util.*;


/**
 * Created by zhukaihao on 16/6/22.
 */
public class Test_1 {
        public static void main(String[] args){

            //取得购物车信息
            List<Item> list=ItemFileReader.readCartJSONToList("cart_item.json");

            //整理购物车信息
            List<Item> items=new ArrayList<Item>();
            for(Item i:list){
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

            //输出
            System.out.println("***商店购物清单***");
            float allPrice=0;
            for(Item i:items) {
                System.out.println(i.toString());
                allPrice+=i.allPrice();
            }
            System.out.println("----------------------");
            System.out.printf("总计:%.2f(元)\n",allPrice);
            System.out.println("**********************");
        }
}
