package api.pojo;

import java.io.Serializable;

public class BrandIntroduce extends PageReq<BrandIntroduce> implements Serializable {

    private String introduce;

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }
}