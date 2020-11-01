package api.pojo;

import java.io.Serializable;

// 课程和门店关联
public class Course extends PageReq<Course> implements Serializable {

    private Integer id; // 课程 id
    private Integer teacherId; // 课程老师的 id
    private Integer storesId; // 门店 id，课程和门店关联
    private Integer number; // 课程人数
    private Integer price; // 课程费用
    private String classroom; // 课程上课地点，教室
    private String pic; // 课程的相关的照片,多个照片用空格隔开
    private Boolean isStart; // 课程是否开始，从数据库查询出来的字段为 start
    private Byte is_start; // 不对应表字段，只是为了 springmvc 的封装
    private String courseName; // 课程名称
    private String startTime; // 课程开始时间，格式为 2020-10-29 14:37 ，数据库中存储为 int ，通过数据库函数 UNIX_TIMESTAMP 转换
    private String endTime; // 课程结束时间
    private String introduce ; // 课程介绍
    private String other ; // 其他信息，包括注意事项等


    public Byte getIs_start() {
        return is_start;
    }

    public Course setIs_start(Byte is_start) {
        this.is_start = is_start;
        setStart(is_start != 0);
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

    public Integer getId() {
        return id;
    }

    public Course setId(Integer id) {
        this.id = id;
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

    public Boolean getStart() {
        return isStart;
    }

    public Course setStart(Boolean start) {
        isStart = start;
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
