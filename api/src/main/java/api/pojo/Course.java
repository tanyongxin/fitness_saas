package api.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

// 课程和门店关联
public class Course extends PageReq<Course> implements Serializable {

    // 课程 id 在父类中
    @NotNull
    private Integer teacherId; // 课程老师的 id

    @NotNull
    private Integer storesId; // 门店 id，课程和门店关联
    @NotNull
    private Integer number; // 课程人数

    private Integer reserveNumber; // 已预约人数
    private Integer brandId; // 品牌 id

    private Integer price = 0; // 课程费用
    @NotNull
    @NotEmpty
    @NotBlank
    private String classroom; // 课程上课地点，教室
    private String pic = ""; // 课程的相关的照片,多个照片用空格隔开

    private Byte isStart = 0; // 课程状态，从数据库查询出来的字段为 start，开始的标志为 1，结束的标志为 -1，未开始为 0

    private Byte is_start; // 不对应表字段，只是为了 springmvc 的封装，开始的标志为 1，结束的标志为 -1，未开始为 0

    @NotNull
    @NotEmpty
    @NotBlank
    private String courseName; // 课程名称

    @NotNull
    @NotEmpty
    @NotBlank
    private String startTime; // 课程开始时间，格式为 2020-10-29 14:37 ，数据库中存储为 int ，通过数据库函数 UNIX_TIMESTAMP 转换

    @NotNull
    @NotEmpty
    @NotBlank
    private String endTime; // 课程结束时间

    private String introduce ; // 课程介绍
    private String other ; // 其他信息，包括注意事项等


    public Integer getBrandId() {
        return brandId;
    }

    public Course setBrandId(Integer brandId) {
        this.brandId = brandId;
        return this;
    }

    public Byte getIs_start() {
        return is_start;
    }

    public Course setIs_start(Byte is_start) {
        this.is_start = is_start;
        setIsStart(is_start);
        return this;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", storesId=" + storesId +
                ", number=" + number +
                ", price=" + price +
                ", classroom='" + classroom + '\'' +
                ", pic='" + pic + '\'' +
                ", isStart=" + isStart +
                ", courseName='" + courseName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", introduce='" + introduce + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public Integer getNumber() {
        return number;
    }

    public Course setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public Course setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public Course setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    public Integer getStoresId() {
        return storesId;
    }

    public Course setStoresId(Integer storesId) {
        this.storesId = storesId;
        return this;
    }

    public String getClassroom() {
        return classroom;
    }

    public Course setClassroom(String classroom) {
        this.classroom = classroom;
        return this;
    }

    public String getPic() {
        return pic;
    }

    public Course setPic(String pic) {
        this.pic = pic;
        return this;
    }

    public Byte getIsStart() {
        return isStart;
    }

    public Course setIsStart(Byte isStart) {
        this.isStart = isStart;
        return this;
    }

    public Integer getReserveNumber() {
        return reserveNumber;
    }

    public Course setReserveNumber(Integer reserveNumber) {
        this.reserveNumber = reserveNumber;
        return this;
    }

    public String getCourseName() {
        return courseName;
    }

    public Course setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public Course setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public Course setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public String getIntroduce() {
        return introduce;
    }

    public Course setIntroduce(String introduce) {
        this.introduce = introduce;
        return this;
    }

    public String getOther() {
        return other;
    }

    public Course setOther(String other) {
        this.other = other;
        return this;
    }


}
