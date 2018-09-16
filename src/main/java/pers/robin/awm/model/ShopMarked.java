package pers.robin.awm.model;

import java.util.Date;

public class ShopMarked {
    private Integer userId;

    private Integer shopId;

    private Boolean status;

    private Date createdAt;

    private Date updatedAt;

    public ShopMarked(Integer userId, Integer shopId, Boolean status, Date createdAt, Date updatedAt) {
        this.userId = userId;
        this.shopId = shopId;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ShopMarked() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
}