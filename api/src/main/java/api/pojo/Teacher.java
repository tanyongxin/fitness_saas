package api.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

// 课程教师表，教师和门店挂钩
public class Teacher extends PageReq<Teacher> implements Serializable {

    @NotNull
    private Integer brandId; // 品牌 id

    @NotNull
    private Integer storesId; // 门店 id

    private Boolean sex; // 性别，false 表示男，true 表示女

    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

    @NotNull
    @NotEmpty
    @NotBlank
    private String contact; // 联系方式

    @NotNull
    @NotEmpty
    @NotBlank
    private String goodAt; // 擅长的方面

    private String pic;
    private String introduce;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", brandId=" + brandId +
                ", storesId=" + storesId +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", goodAt='" + goodAt + '\'' +
                ", pic='" + pic + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }

    public String getContact() {
        return contact;
    }

    public Teacher setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public String getGoodAt() {
        return goodAt;
    }

    public Teacher setGoodAt(String goodAt) {
        this.goodAt = goodAt;
        return this;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public Teacher setBrandId(Integer brandId) {
        this.brandId = brandId;
        return this;
    }

    public Boolean getSex() {
        return sex;
    }

    public Teacher setSex(Boolean sex) {
        this.sex = sex;
        return this;
    }

    public Integer getStoresId() {
        return storesId;
    }

    public void setStoresId(Integer storesId) {
        this.storesId = storesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
