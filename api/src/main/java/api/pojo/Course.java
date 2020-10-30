package api.pojo;

import java.io.Serializable;

// 课程和门店关联
public class Course implements Serializable {

    private Integer id; // 课程 id
    private Integer teacherId; // 课程老师的 id
    private Integer storesId; // 门店 id，课程和门店关联
    private String classroom; // 课程上课地点，教室
    private String pic; // 课程的相关的照片,多个照片用空格隔开
    private Boolean isStart; // 课程是否开始
    private String courseName; // 课程名称
    private String startTime; // 课程开始时间，格式为 2020-10-29 14:37 ，数据库中存储为 int ，通过数据库函数 UNIX_TIMESTAMP 转换
    private String endTime; // 课程结束时间
    private String introduce; // 课程介绍
    private String other; // 其他信息，包括注意事项等

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Boolean getStart() {
        return isStart;
    }

    public void setStart(Boolean start) {
        isStart = start;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getStoresId() {
        return storesId;
    }

    public void setStoresId(Integer storesId) {
        this.storesId = storesId;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
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

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
