package pers.robin.awm.model;

public class config {
    private String key;

    private String value;

    public config(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public config() {
        super();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}