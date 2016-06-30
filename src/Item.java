/**
* Created by Qi Haochen on 2016/6/22.
        */
public class Item {

    private String barcode;    //编号
    private String name;    //名称
    private String unit;    //单位
    private float price;    //单价
    private int number=1;     //数量
    private float discount=1;     //折扣
    private float vipDiscount=1; //会员折扣
    private boolean promotion=false;  //促销

    //无参构造
    public Item(){
    }

    //有参数构造
    public Item(String barcode, String name, String unit, float price){
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public Item(String barcode, String name, String unit, float price,float discount){
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.discount=discount;
    }

    public Item(String barcode, String name, String unit, float price,float discount,boolean promotion){
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.discount=discount;
        this.promotion=promotion;
    }

    public Item(String barcode, String name, String unit, float price,float discount,float vipDiscount,boolean promotion){
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.discount=discount;
        this.vipDiscount=vipDiscount;
        this.promotion=promotion;
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

    public void setNumber(int number){this.number=number;}

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

    public void setVipDiscount(float vipDiscount){this.vipDiscount=vipDiscount;}

    public float getVipDiscount(){return vipDiscount;}

    public void setPromotion(boolean promotion){this.promotion=promotion;}

    public boolean getPromotion(){return promotion;}

    //单量加一
    public void addNum(){
        number+=1;
    }

    //返回总价
    public float allPrice(){
        if(!promotion) {
            return price * number * discount;
        }else{
            return (number/2)*price+(number%2)*price;
        }
    }

    //返回节省价格
    public float savePrice(){
        if(!promotion) {
            return price * number * (1 - discount);
        }else{
            return price*(number/2);
        }
    }

    public String toString(){
        return "名称：" + name + "，数量：" + number + unit + "，单价：" + String.format("%.2f",this.price) + "(元)，小计："
                + String.format("%.2f",allPrice())+ "(元)";
    }

}
