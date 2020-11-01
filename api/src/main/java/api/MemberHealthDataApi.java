package api;

import api.pojo.MemberHealthData;
import api.pojo.PageReq;
import java.util.List;

public interface MemberHealthDataApi {

    boolean addMemberHealthData(MemberHealthData memberHealthData);

    MemberHealthData.CompareRes calculateHealthData(Integer currentId,Integer lastId);

    List<MemberHealthData> findMemberHealthDataByTime(PageReq<MemberHealthData> pageReq);

    // 查找小于 weight 的健康数据
    List<MemberHealthData> findMemberHealthDataByWeight(PageReq<MemberHealthData> pageReq);

    // 查找小于 BodyFat 的健康数据
    List<MemberHealthData> findMemberHealthDataByBodyFat(PageReq<MemberHealthData> pageReq);


}
