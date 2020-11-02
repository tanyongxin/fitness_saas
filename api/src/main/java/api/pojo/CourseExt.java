package api.pojo;

import java.io.Serializable;

// 课程的扩展 pojo
public class CourseExt extends PageReq<CourseExt> implements Serializable {

    private String introduce;
    private String other;

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
