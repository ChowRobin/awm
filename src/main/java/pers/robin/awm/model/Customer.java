package pers.robin.awm.model;

import java.util.Date;

public class Customer extends User {
    private Integer id;

    private String name;

    private short gender;

    private String sid;

    private String img;

    private Date createdAt;

    private Date updatedAt;

    private String tel;

    private String password;

    private short role;

    public Customer(Integer id, String name, Byte gender, String sid, String img, Date createdAt, Date updatedAt,
                    String tel, String password) {
        super(id, tel, password, (short) 0, createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.sid = sid;
        this.img = img;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Customer(Integer id, String name, Short gender, String sid, String img, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.sid = sid;
        this.img = img;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Customer() {
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

    public short getGender() {
        return gender;
    }

    public void setGender(short gender) {
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