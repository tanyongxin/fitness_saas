package member.dao;

import api.pojo.MemberHealthData;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberHealthDataMapper {

    int addMemberHealthData(MemberHealthData record);

    MemberHealthData selectMemberHealthDataById(Integer id);

    List<MemberHealthData> findMemberHealthDataByTime(@Param("lastId") Integer lastId, @Param("healthData") MemberHealthData healthData,@Param("pageSize") Integer pageSize);

    List<MemberHealthData> findMemberHealthDataByWeight(@Param("lastId") Integer lastId,@Param("healthData") MemberHealthData healthData,@Param("pageSize")  Integer pageSize);

    List<MemberHealthData> findMemberHealthDataByBodyFat(@Param("lastId") Integer lastId,@Param("healthData") MemberHealthData healthData,@Param("pageSize")  Integer pageSize);

    Integer getMinId(Integer memberId);

}