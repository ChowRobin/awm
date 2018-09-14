package pers.robin.awm.model;

public class orderDetail {
    private Integer orderId;

    private Integer itemId;

    private Integer num;

    private Integer price;

    public orderDetail(Integer orderId, Integer itemId, Integer num, Integer price) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.num = num;
        this.price = price;
    }

    public orderDetail() {
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}