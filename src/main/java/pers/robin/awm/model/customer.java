package pers.robin.awm.model;

import java.util.Date;

public class customer {
    private Integer id;

    private String name;

    private Byte gender;

    private String sid;

    private String img;

    private Date createdAt;

    private Date updatedAt;

    public customer(Integer id, String name, Byte gender, String sid, String img, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.sid = sid;
        this.img = img;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public customer() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
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