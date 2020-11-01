package member.impl;

import api.AbstractApiImpl;
import api.MemberHealthDataApi;
import api.pojo.MemberHealthData;
import api.pojo.PageReq;
import member.dao.MemberHealthDataMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
            compareRes.setHeightRes(current.getHeight() - last.getHeight()).setBodyFatRes(current.getBodyFat() - last.getBodyFat()).setWeightRes(current.getWeight() - last.getWeight());
            compareRes.setFinish(current.getWeight().equals(last.getTargetWeight()) && current.getBodyFat().equals(last.getTargetBodyFat()));
            return compareRes;
        }
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<MemberHealthData> findMemberHealthDataByTime(PageReq<MemberHealthData> pageReq) {
        MemberHealthData healthData = pageReq.getT();
        pageReq = checkLastId(null,pageReq);
        return memberHealthDataMapper.findMemberHealthDataByTime(pageReq.getLastId(),healthData,pageReq.getPageSize());
    }

    @Transactional(readOnly = true)
    @Override
    public List<MemberHealthData> findMemberHealthDataByWeight(PageReq<MemberHealthData> pageReq) {
        MemberHealthData healthData = pageReq.getT();
        pageReq = checkLastId(null,pageReq);
        return memberHealthDataMapper.findMemberHealthDataByWeight(pageReq.getLastId(),healthData,pageReq.getPageSize());
    }

    @Transactional(readOnly = true)
    @Override
    public List<MemberHealthData> findMemberHealthDataByBodyFat(PageReq<MemberHealthData> pageReq) {
        MemberHealthData healthData = pageReq.getT();
        pageReq = checkLastId(null,pageReq);
        return memberHealthDataMapper.findMemberHealthDataByBodyFat(pageReq.getLastId(),healthData,pageReq.getPageSize());
    }

    @Override
    protected  Integer getMinId(Integer brandId, PageReq<MemberHealthData> pageReq) {
        Integer memberId = pageReq.getT().getMemberId();
        return memberHealthDataMapper.getMinId(memberId);
    }
}
