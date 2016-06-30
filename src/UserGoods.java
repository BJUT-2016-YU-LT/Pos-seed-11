/**
 * Created by zhukaihao on 16/6/30.
 */

import java.util.*;

public class UserGoods {
    private String user;
    private List<String> items=new ArrayList<String>();

    public UserGoods(){}

    public void setUser(String user){this.user=user;}

    public void setItems(List<String> items){this.items=items;}

    public String getUser(){return user;}

    public List<String> getItems(){return items;}
}
