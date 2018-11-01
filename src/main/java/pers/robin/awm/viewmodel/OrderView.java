package pers.robin.awm.viewmodel;

import java.util.Date;
import java.util.List;

public class OrderView {

    private Integer id;

    private String code;

    private Integer price;

    private Integer userId;

    private String ip;

    private String address;

    private Integer provider;

    private Short status;

    private String deliveryDate;

    private String deliveryTime;

    private String remark;

    private Date createdAt;

    private Date updatedAt;

    private List<OrderDetailView> orderDetailViews;

    public OrderView(Integer id, String code, Integer price, Integer userId, String ip, String address,
                     Integer provider, Short status, String deliveryDate, String deliveryTime, String remark,
                     Date createdAt, Date updatedAt) {
        this.id = id;
        this.code = code;
        this.price = price;
        this.userId = userId;
        this.ip = ip;
        this.address = address;
        this.provider = provider;
        this.status = status;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.remark = remark;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getProvider() {
        return provider;
    }

    public void setProvider(Integer provider) {
        this.provider = provider;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<OrderDetailView> getOrderDetailViews() {
        return orderDetailViews;
    }

    public void setOrderDetailViews(List<OrderDetailView> orderDetailViews) {
        this.orderDetailViews = orderDetailViews;
    }
}
