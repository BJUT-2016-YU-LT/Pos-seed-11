import java.util.List;

/**
 * Created by user on 2016/6/30.
 */
public class Test_22 {
    public static void main(String[] args){

        //取得商品索引,商品列表
        List<Item> cartIndex=ItemFileReader.readGoodsIndexJSONToList("goods_index1.json");
        List<String> goodsList=ItemFileReader.readGoodsListJSONToList("goods_list1.json");

        //整理购物车信息
        for(String str:goodsList){
            for(Item j:cartIndex){
                if(str.equals(j.getBarcode())){
                    j.addNum();
                }
            }
        }

        //输出
        float allPrice=0;
        float savePrice=0;
        System.out.println("***商店购物清单***");
        for(Item i:cartIndex) {
            if (i.getNumber()!=0){
                System.out.println(i.toString());
            }
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