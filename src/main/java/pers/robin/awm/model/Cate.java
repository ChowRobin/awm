package pers.robin.awm.model;

public class Cate {
    private Integer id;

    private Integer shopId;

    private String name;

    public Cate(Integer id, Integer shopId, String name) {
        this.id = id;
        this.shopId = shopId;
        this.name = name;
    }

    public Cate() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}