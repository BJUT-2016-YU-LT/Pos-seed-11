/**
 * Created by zhukaihao on 16/6/30.
 */

import java.util.*;

public class UserInfo {
    private String name;
    private boolean isVip=false;
    private int grades=0;

    public UserInfo(){}

    public UserInfo(String name, boolean isVip){this.name=name;this.isVip=isVip;}

    public UserInfo(String name, boolean isVip,int grades){this.name=name;this.isVip=isVip;this.grades=grades;}

    public void setName(String name){this.name=name;}

    public void setVip(boolean isVip){this.isVip=isVip;}

    public void setGrades(int grades){this.grades=grades;}

    public String getName(){return name;}

    public boolean isVip(){return isVip;}

    public int getGrades(){return grades;}

}
