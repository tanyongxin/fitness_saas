package member.impl;

import api.AbstractApiImpl;
import api.MemberHealthDataApi;
import api.pojo.MemberHealthData;
import api.pojo.PageReq;
import member.dao.MemberHealthDataMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service(interfaceClass = MemberHealthDataApi.class)
public class MemberHealthDataApiImpl extends AbstractApiImpl<MemberHealthData> implements MemberHealthDataApi {

    @Autowired
    private MemberHealthDataMapper memberHealthDataMapper;

    @Transactional
    @Override
    public boolean addMemberHealthData(MemberHealthData memberHealthData) {
        return memberHealthDataMapper.addMemberHealthData(memberHealthData) > 0;
    }

    @Transactional(readOnly = true)
    @Override
    public MemberHealthData.CompareRes calculateHealthData(Integer currentId, Integer lastId) {
        MemberHealthData current = memberHealthDataMapper.selectMemberHealthDataById(currentId);
        MemberHealthData last = memberHealthDataMapper.selectMemberHealthDataById(lastId);
        if (current != null && last != null){
            MemberHealthData.CompareRes compareRes = new MemberHealthData.CompareRes();
            // setScale 方法保留两位小数
            compareRes.setHeightRes((float)BigDecimal.valueOf(current.getHeight()).subtract(BigDecimal.valueOf(last.getHeight())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue())
                      .setBodyFatRes((float)BigDecimal.valueOf(current.getBodyFat()).subtract(BigDecimal.valueOf(last.getBodyFat())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue())
                      .setWeightRes((float)BigDecimal.valueOf(current.getWeight()).subtract(BigDecimal.valueOf(last.getWeight())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            compareRes.setFinish(current.getWeight().equals(last.getTargetWeight()) && current.getBodyFat().equals(last.getTargetBodyFat()));
            System.out.println("compareRes : " + compareRes);
            return compareRes;
        }
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<MemberHealthData> findMemberHealthDataByTime(PageReq<MemberHealthData> pageReq) {
        MemberHealthData healthData = pageReq.getT();
        pageReq = checkLastId(null,pageReq);
        if (pageReq.getLastId() < 0)
            return null;
        return memberHealthDataMapper.findMemberHealthDataByTime(pageReq.getLastId(),healthData,pageReq.getPageSize());
    }

    @Transactional(readOnly = true)
    @Override
    public List<MemberHealthData> findMemberHealthDataByWeight(PageReq<MemberHealthData> pageReq) {
        MemberHealthData healthData = pageReq.getT();
        pageReq = checkLastId(null,pageReq);
        if (pageReq.getLastId() < 0)
            return null;
        return memberHealthDataMapper.findMemberHealthDataByWeight(pageReq.getLastId(),healthData,pageReq.getPageSize());
    }

    @Transactional(readOnly = true)
    @Override
    public List<MemberHealthData> findMemberHealthDataByBodyFat(PageReq<MemberHealthData> pageReq) {
        MemberHealthData healthData = pageReq.getT();
        pageReq = checkLastId(null,pageReq);
        if (pageReq.getLastId() < 0)
            return null;
        return memberHealthDataMapper.findMemberHealthDataByBodyFat(pageReq.getLastId(),healthData,pageReq.getPageSize());
    }

    @Override
    protected  Integer getMinId(Integer brandId, PageReq<MemberHealthData> pageReq) {
        Integer memberId = pageReq.getT().getMemberId();
        Integer minId = memberHealthDataMapper.getMinId(memberId);
        return minId == null ? -1 : minId - 1;
    }
}
