package pers.robin.awm.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "upload.image")
public class UploadProperty {
    private String path;
    private int maxSize;
    private List<String> acceptType = new ArrayList<>();

    public UploadProperty() {
    }

    @Override
    public String toString() {
        return "UploadProperty{" +
                "path='" + path + '\'' +
                ", maxSize=" + maxSize +
                ", acceptType=" + acceptType +
                '}';
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<String> getAcceptType() {
        return acceptType;
    }

    public void setAcceptType(List<String> acceptType) {
        this.acceptType = acceptType;
    }
}
