package com.example.tvscience.tvscience.bean;

/**
 * Created by admin on 2017/6/12.
 */

public class Video {
    private Goods goods;
    private int id;
    private String name;
    private String sid;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
