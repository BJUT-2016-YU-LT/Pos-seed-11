/**
 * Created by zhukaihao on 16/6/30.
 */

import java.util.*;

public class UserInfo {
    private String name;
    private boolean isVip;
    private float grades;

    public UserInfo(){}

    public UserInfo(String name, boolean isVip){this.name=name;this.isVip=isVip;}

    public void setName(String name){this.name=name;}

    public void setVip(boolean isVip){this.isVip=isVip;}

    public void setGrades(float grades){this.grades=grades;}

    public String getName(){return name;}

    public boolean isVip(){return isVip;}

    public float getGrades(){return grades;}

}
