import java.util.Vector;

/**
 * Created by zhukaihao on 16/6/22.
 */
public class Test {
        public static void main(String[] args){
            Vector<Item> vs=new Vector<Item>();
            ItemFileReader.readCartItemFile(vs,"cart_item.txt");

            float all=0;
            for(Item i:vs)
                all+=i.allPrice();

            //输出
            System.out.println("***商店购物清单***");
            for(Item i:vs)
                System.out.println(i.toString());
            System.out.println("----------------------");
            System.out.printf("总计:%.2f(元)\n",all);
            System.out.println("**********************");
        }
}
