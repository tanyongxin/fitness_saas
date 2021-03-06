package api.pojo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

// 会员健康数据
public class MemberHealthData extends PageReq<MemberHealthData> {

    @NotNull
    private Integer memberId;

    @NotNull
    private Float height; // 身高,整数部分最多两位，小数部分最多两位

    @NotNull
    private Float weight; // 体重，整数部分最多三位，小数部分最多两位

    @NotNull
    private Float bodyFat; // 体脂，整数部分最多两位，小数部分最多一位

    @NotNull
    private Float targetWeight; // 目标体重

    @NotNull
    private Float targetBodyFat; // 目标体脂

    @NotNull
    private String addDate; // 添加该数据时的日期，最大值为 年-月-日 23:59，最小值为 年-月-日 00:00

    private String endDate; // 结束日期，不对应表中字段，只是用于封装查询条件

    // 会员健康数据的比较结果
    public static class CompareRes implements Serializable {

        private Float weightRes; // 体重的比较结果
        private Float heightRes; // 身高的比较结果
        private Float bodyFatRes; // 体脂的比较结果
        private Boolean isFinish; // 是否完成目标


        public Boolean getFinish() {
            return isFinish;
        }

        public CompareRes setFinish(Boolean finish) {
            isFinish = finish;
            return this;
        }

        public Float getWeightRes() {
            return weightRes;
        }

        public CompareRes setWeightRes(Float weightRes) {
            this.weightRes = weightRes;
            return this;
        }

        public Float getHeightRes() {
            return heightRes;
        }

        public CompareRes setHeightRes(Float heightRes) {
            this.heightRes = heightRes;
            return this;
        }

        public Float getBodyFatRes() {
            return bodyFatRes;
        }

        public CompareRes setBodyFatRes(Float bodyFatRes) {
            this.bodyFatRes = bodyFatRes;
            return this;
        }

        @Override
        public String toString() {
            return "CompareRes{" +
                    "weightRes='" + weightRes + '\'' +
                    ", heightRes='" + heightRes + '\'' +
                    ", bodyFatRes='" + bodyFatRes + '\'' +
                    ", isFinish=" + isFinish +
                    '}';
        }
    }


    public String getEndDate() {
        return endDate;
    }

    public MemberHealthData setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getAddDate() {
        return addDate;
    }

    public MemberHealthData setAddDate(String addDate) {
        this.addDate = addDate;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public MemberHealthData setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public Float getHeight() {
        return height;
    }

    public MemberHealthData setHeight(Float height) {
        this.height = height;
        return this;
    }

    public Float getWeight() {
        return weight;
    }

    public MemberHealthData setWeight(Float weight) {
        this.weight = weight;
        return this;
    }

    public Float getBodyFat() {
        return bodyFat;
    }

    public MemberHealthData setBodyFat(Float bodyFat) {
        this.bodyFat = bodyFat;
        return this;
    }

    public Float getTargetWeight() {
        return targetWeight;
    }

    public MemberHealthData setTargetWeight(Float targetWeight) {
        this.targetWeight = targetWeight;
        return this;
    }

    public Float getTargetBodyFat() {
        return targetBodyFat;
    }

    public MemberHealthData setTargetBodyFat(Float targetBodyFat) {
        this.targetBodyFat = targetBodyFat;
        return this;
    }
}
