package pers.robin.awm.model;

import java.util.Date;

public class comment {
    private Integer id;

    private Byte score;

    private Byte type;

    private String content;

    private Integer userId;

    private Integer shopId;

    private String reply;

    private Date createdAt;

    private Date updatedAt;

    public comment(Integer id, Byte score, Byte type, String content, Integer userId, Integer shopId, String reply, Date createdAt, Date updatedAt) {
        this.id = id;
        this.score = score;
        this.type = type;
        this.content = content;
        this.userId = userId;
        this.shopId = shopId;
        this.reply = reply;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public comment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getScore() {
        return score;
    }

    public void setScore(Byte score) {
        this.score = score;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
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