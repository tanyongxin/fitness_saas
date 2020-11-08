package member.impl;

import api.AbstractApiImpl;
import api.CourseApi;
import api.ReserveCourseApi;
import api.pojo.Course;
import api.pojo.PageReq;
import api.pojo.ReserveCourse;
import member.dao.ReserveCourseMapper;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service(interfaceClass = ReserveCourseApi.class)
public class ReserveCourseApiImpl extends AbstractApiImpl<ReserveCourse> implements ReserveCourseApi {

    @Autowired
    private ReserveCourseMapper reserveCourseMapper;

    @Reference(check = false)
    private CourseApi courseApi;

    private ConcurrentHashMap<String, AtomicInteger> reserve = new ConcurrentHashMap<>(); // 预约人数的 map

    private ConcurrentHashMap<String, AtomicInteger> qualified = new ConcurrentHashMap<>(); // 限定人数的 map

    private static final String JOIN = "-";

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Transactional
    @Override
    public ReserveCourse.ReserveRes addReserveCourse(ReserveCourse reserveCourse) {
        if (reserveCourse.getQualified() <= 0 || reserveCourse.getHasReserve() < 0)
            return ReserveCourse.ReserveRes.failure;
        AtomicInteger reserveNumber = reserve.putIfAbsent(reserveCourse.getBrandId() + JOIN + reserveCourse.getCourseId(), new AtomicInteger(reserveCourse.getHasReserve()));
        AtomicInteger qualifiedNumber = qualified.putIfAbsent(reserveCourse.getBrandId() + JOIN + reserveCourse.getCourseId(), new AtomicInteger(reserveCourse.getQualified()));
        // 如果 qualifiedNumber.get() != reserveCourse.getQualified() && qualifiedNumber.get() < reserveCourse.getQualified() 条件为 true，说明课程人数被修改过，此时应该更新对应的限定人数
        if (qualifiedNumber != null && qualifiedNumber.get() != reserveCourse.getQualified() && qualifiedNumber.get() < reserveCourse.getQualified())
            qualified.put(reserveCourse.getBrandId() + JOIN + reserveCourse.getCourseId(), new AtomicInteger(reserveCourse.getQualified()));
        // 如果 reserveNumber.incrementAndGet() > reserveCourse.getQualified() 为 true，说明当前预约人数已达到上限
        if ( reserveNumber != null &&  reserveNumber.incrementAndGet() > reserveCourse.getQualified() )
            return ReserveCourse.ReserveRes.full;
        if ( reserveNumber == null ){
            reserveNumber = reserve.get(reserveCourse.getBrandId() + JOIN + reserveCourse.getCourseId());
            if ( reserveNumber.incrementAndGet() > reserveCourse.getQualified() )
                return ReserveCourse.ReserveRes.full;
        }
        try {
            if (reserveCourseMapper.addReserveCourse(reserveCourse) > 0 )
                return  ReserveCourse.ReserveRes.success;
        }catch (Throwable t){
            // 回滚预约人数
            if (reserve.get(reserveCourse.getBrandId() + JOIN + reserveCourse.getCourseId()).get() > 0)
                reserve.get(reserveCourse.getBrandId() + JOIN + reserveCourse.getCourseId()).decrementAndGet();
            throw t;
        }
        return ReserveCourse.ReserveRes.full;
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

    @Transactional(readOnly = true)
    @Override
    public List<Course> findReserveNumberByCourseId(List<Course> list) {
        list.forEach(course -> {
            if (!reserve.containsKey(course.getBrandId() + JOIN + course.getId()) ) {
                int reserveNumber = reserveCourseMapper.findReserveNumberByBrandIdAndCourseId(course.getBrandId(), course.getId());
                course.setReserveNumber(reserveNumber);
                reserve.putIfAbsent(course.getBrandId() + JOIN + course.getId(),new AtomicInteger(reserveNumber));
            }else
                course.setReserveNumber(reserve.get(course.getBrandId() + JOIN + course.getId()).get());
        });
        return list;
    }

    @Override
    protected Integer getMinId(Integer brandId, PageReq<ReserveCourse> pageReq) {
        Integer minId = reserveCourseMapper.getMinId(pageReq.getT().getMemberId());
        return minId == null ? -1 : minId - 1;
    }
}
