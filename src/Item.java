/**
* Created by Qi Haochen on 2016/6/22.
        */
public class Item {

    private String barcode;    //编号
    private String name;    //名称
    private String unit;    //单位
    private float price;    //单价
    private int number;     //数量
    private float discount;     //折扣

    //无参构造
    public Item(){
        discount=1;
    }

    //有参数构造
    public Item(String barcode, String name, String unit, float price){
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.number = 1;
        this.discount=1;
    }

    public Item(String barcode, String name, String unit, float price,float discount){
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.number = 1;
        this.discount=discount;
    }

    public String getBarcode(){
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

    public void setPrice(float price){
        this.price = price;
    }

    public void setBarcode(String barcode){ this.barcode=barcode; }

    public void setName(String name){ this.name=name; }

    public void setUnit(String unit){ this.unit=unit; }

    public void setDiscount(float discount){this.discount=discount;}

    public float getDiscount(){return discount;}

    //单量加一
    public void addNum(){
        number+=1;
    }

    //返回总价
    public float allPrice(){
        return price*number*discount;
    }

    //返回节省价格
    public float savePrice(){ return price*number*(1-discount);}

    public String toString(){
        return "名称：" + name + "，数量：" + number + unit + "，单价：" + String.format("%.2f",this.price) + "(元)，小计："
                + String.format("%.2f",allPrice())+ "(元)";
    }

}
