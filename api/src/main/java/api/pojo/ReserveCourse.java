package api.pojo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

// 预定课程 pojo
public class ReserveCourse extends PageReq<ReserveCourse> {

    @NotNull
    private Integer memberId; // 会员 id

    @NotNull
    private Integer courseId; // 课程 id

    @NotNull
    private Integer brandId; // 品牌 id

    private Integer number = 1; // 预定人数

    @NotNull
    private Integer qualified; // 课程的限定人数，需要从前端传入，不能为 null 或 0，不对应表字段

    @NotNull
    private Integer hasReserve; // 已预定人数，需要从前端传入，不能为 null，不对应表字段

    @NotNull
    private String expectTime; // 预计到达时间,格式为 年-月-日 10:00
    private String otherMess; // 附加信息

    public static class ReserveCourseVo {

    }

    // 预约结果
    public static class ReserveRes implements Serializable {
        private int res; // 预定课程的结果，0 表示预约失败，1 表示预约人数已满，2 表示预约成功

        public static final ReserveRes failure = new ReserveRes(0);
        public static final ReserveRes full = new ReserveRes(1);
        public static final ReserveRes success = new ReserveRes(2);

        public ReserveRes(int res){
            this.res = res;
        }

        public int getRes() {
            return res;
        }

        public ReserveRes setRes(int res) {
            this.res = res;
            return this;
        }
    }


    public Integer getHasReserve() {
        return hasReserve;
    }

    public ReserveCourse setHasReserve(Integer hasReserve) {
        this.hasReserve = hasReserve;
        return this;
    }

    public Integer getQualified() {
        return qualified;
    }

    public ReserveCourse setQualified(Integer qualified) {
        this.qualified = qualified;
        return this;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public ReserveCourse setBrandId(Integer brandId) {
        this.brandId = brandId;
        return this;
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
