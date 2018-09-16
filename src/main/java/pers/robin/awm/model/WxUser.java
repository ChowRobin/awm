package pers.robin.awm.model;

public class WxUser {
    private Integer id;

    private String wxid;

    public WxUser(Integer id, String wxid) {
        this.id = id;
        this.wxid = wxid;
    }

    public WxUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWxid() {
        return wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid == null ? null : wxid.trim();
    }
}