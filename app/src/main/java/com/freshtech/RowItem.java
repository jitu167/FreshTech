package com.freshtech;

/**
 * Created by KUSUM DEVI on 14-05-2016.
 */
public class RowItem {
    private String desc,price;
    int likes;
    private int icon;
    private  int items;
    private  boolean isLike=false;
    public RowItem(String price, int icon,String desc, int likes) {
        this.desc = desc;
        this.icon = icon;
        this.price=price;
        this.likes=likes;
    }

    public String getDesc() {
        return desc;
    }
    public String getPrice() {
        return price;
    }
    public void setLiked(boolean b)
    {
        isLike=b;
    }
    public int getLikes() {
        return likes;
    }
    public boolean isLiked()
    {
        return isLike;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
    public void setItems(int x)
    {
        items=x;
    }
    public int getItems()
    {
        return items;
    }
}
