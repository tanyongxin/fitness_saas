package api.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

// pojo 需要实现 Serializable 接口，否则使用 dubbo 调用提供者时会报错
public class Brand extends PageReq<Brand> implements Serializable {

    private Boolean isValid = true;

    @NotNull
    @NotEmpty
    @NotBlank
    private String name;
    private String pic = ""; // 品牌商标，多个照片用空格隔开
    private String introduce ; // 富文本中的内容


    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

}
