/**
* Created by Qi Haochen on 2016/6/22.
        */
public class Item {

    private int barcode;    //编号
    private String name;    //名称
    private String unit;    //单位
    private float price;    //单价
    private int number;     //数量

    //有参数构造
    public Item(String name, String nuit, int barcode, float price){
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = 0;
        this.number = 1;
    }
    //获取函数
    public int getBarcode(){
        return barcode;
    }

    public String getName(){
        return name;
    }

    public String getUnit(){
        return unit;
    }

    public int getNumber(){
        return number;
    }

    public float getPrice(){
        return price;
    }
    //单量加一
    public void addNum(){
        number+=1;
    }
    //设置价格
    public void setPrice(float price){
        this.price = price;
    }
    //返回总价
    public float allPrice(){
        return price*number;
    }

    public String toString(){
        return "名称：" + name + "，数量：" + number + unit + "，单价：" + System.out.printf("%.2f", this.price) + "(元)，小计："
                + System.out.printf("%.2f", allPrice()) + "(元)";
    }

}
