package api.pojo;

import javax.validation.constraints.NotNull;

// 预定课程 pojo
public class ReserveCourse extends PageReq<ReserveCourse> {

    @NotNull
    private Integer memberId; // 会员 id

    @NotNull
    private Integer courseId; // 课程 id

    private Integer number = 1; // 预定人数

    @NotNull
    private String expectTime; // 预计到达时间,格式为 年-月-日 10:00
    private String otherMess; // 附加信息

    public static class ReserveCourseVo {

    }

    public Integer getNumber() {
        return number;
    }

    public ReserveCourse setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public ReserveCourse setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public ReserveCourse setCourseId(Integer courseId) {
        this.courseId = courseId;
        return this;
    }

    public String getExpectTime() {
        return expectTime;
    }

    public ReserveCourse setExpectTime(String expectTime) {
        this.expectTime = expectTime;
        return this;
    }

    public String getOtherMess() {
        return otherMess;
    }

    public ReserveCourse setOtherMess(String otherMess) {
        this.otherMess = otherMess;
        return this;
    }
}
