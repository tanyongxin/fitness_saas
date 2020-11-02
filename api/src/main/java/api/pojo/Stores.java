package api.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

// 门店和品牌关联
public class Stores extends PageReq<Stores> implements Serializable {

     // 门店 id
    @NotNull
    private Integer brandId; // 门店所属品牌的 id

    @NotNull
    @NotEmpty
    @NotBlank
    private String province; // 所在省

    @NotNull
    @NotEmpty
    @NotBlank
    private String city; // 所在市

    @NotNull
    @NotEmpty
    @NotBlank
    private String area; // 所在区

    @NotNull
    @NotEmpty
    @NotBlank
    private String phone; // 电话

    @NotNull
    @NotEmpty
    @NotBlank
    private String business; // 营业时间，格式为: 10:00 - 23:00
    private String pic = ""; // 门店照片,多个照片用空格隔开

    @NotNull
    @NotEmpty
    @NotBlank
    private String storesName; // 门店名称
    private String other; // 门店的其他信息，如注意事项
    private boolean isOpen = true; // 是否营业
    private Byte is_open;

    public Byte getIs_open() {
        return is_open;
    }

    public Stores setIs_open(Byte is_open) {
        this.is_open = is_open;
        setOpen(is_open != 0);
        return this;
    }

    public String getStoresName() {
        return storesName;
    }

    public void setStoresName(String storesName) {
        this.storesName = storesName;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
