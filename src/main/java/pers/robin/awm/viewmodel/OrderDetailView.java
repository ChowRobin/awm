package pers.robin.awm.viewmodel;

public class OrderDetailView {

    private Integer orderId;

    private Integer itemId;

    private String name;

    private Integer num;

    private Integer price;

    public OrderDetailView(Integer orderId, Integer itemId, Integer num, Integer price) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.num = num;
        this.price = price;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
