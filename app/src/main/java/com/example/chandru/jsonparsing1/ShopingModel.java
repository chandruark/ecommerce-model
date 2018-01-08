package com.example.chandru.jsonparsing1;



public class ShopingModel {

    private String discount;
    private String rate;
    private String imgid;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ShopingModel(String discount, String rate, String imgid, String url,String name) {
        this.discount = discount;
        this.rate = rate;
        this.imgid = imgid;
        this.url = url;
        this.name=name;
    }

    public ShopingModel() {

    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getImgid() {
        return imgid;
    }

    public void setImgid(String imgid) {
        this.imgid = imgid;
    }

}
