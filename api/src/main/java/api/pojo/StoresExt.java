package api.pojo;

import java.io.Serializable;

public class StoresExt extends PageReq<StoresExt> implements Serializable {

    private String other;

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
