package member.impl;

import api.AbstractApiImpl;
import api.ReserveCourseApi;
import api.pojo.PageReq;
import api.pojo.ReserveCourse;
import member.dao.ReserveCourseMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service(interfaceClass = ReserveCourseApi.class)
public class ReserveCourseApiImpl extends AbstractApiImpl<ReserveCourse> implements ReserveCourseApi {

    @Autowired
    private ReserveCourseMapper reserveCourseMapper;


    @Transactional
    @Override
    public boolean addReserveCourse(ReserveCourse reserveCourse) {
        return reserveCourseMapper.addReserveCourse(reserveCourse) > 0;
    }

    @Transactional
    @Override
    public boolean updateReserveCourse(ReserveCourse reserveCourse) {
        return reserveCourseMapper.updateReserveCourse(reserveCourse) > 0;
    }

    // todo：findReserveCourseById 方法和 findReserveCourseByMemberId 方法还需要调用其他服务提供者获取前台需要展示的信息
    @Transactional(readOnly = true)
    @Override
    public ReserveCourse findReserveCourseById(Integer id) {
        return reserveCourseMapper.findReserveCourseById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ReserveCourse> findReserveCourseByMemberId(PageReq<ReserveCourse> pageReq) {
        ReserveCourse course = pageReq.getT();
        pageReq = checkLastId(null,pageReq);
        if (pageReq.getLastId() < 0)
            return null;
        return reserveCourseMapper.findReserveCourseByMemberId(pageReq.getLastId(),course,pageReq.getPageSize());
    }

    @Override
    protected Integer getMinId(Integer brandId, PageReq<ReserveCourse> pageReq) {
        Integer minId = reserveCourseMapper.getMinId(pageReq.getT().getMemberId());
        return minId == null ? -1 : minId - 1;
    }
}
