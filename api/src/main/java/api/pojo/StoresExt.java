package api.pojo;

import java.io.Serializable;

public class StoresExt implements Serializable {

    private Integer id;
    private String other;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
