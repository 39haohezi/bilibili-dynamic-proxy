package cn.nihaopiaoliang.proxy;

public class Production implements IProduction {

    public void sales(float price) {
        System.out.println("销售商品，价格：" + price);
    }

}
