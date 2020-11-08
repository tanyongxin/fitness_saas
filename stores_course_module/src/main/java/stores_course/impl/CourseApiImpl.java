package stores_course.impl;

import api.AbstractApiImpl;
import api.CourseApi;
import api.ReserveCourseApi;
import api.pojo.Course;
import api.pojo.CourseExt;
import api.pojo.PageReq;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import stores_course.dao.CourseExtMapper;
import stores_course.dao.CourseMapper;
import java.util.List;

@Service(interfaceClass = CourseApi.class)
public class CourseApiImpl extends AbstractApiImpl<Course> implements CourseApi {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseExtMapper courseExtMapper;

    @Reference
    private ReserveCourseApi reserveCourseApi;

    @Transactional
    @Override
    public boolean addCourse(Integer brandId,Course course) {
        int i = courseMapper.addCourse(brandId, course);
        if (i > 0 && (course.getIntroduce() != null || course.getOther() != null)){
            return courseExtMapper.addCourseIntroduceAndOther(brandId,course.getId(),course.getIntroduce(),course.getOther()) > 0;
         }
        return i > 0;

    }

    @Transactional
    @Override
    public boolean delCourse(Integer brandId,Integer id) {
        return courseMapper.delCourse(brandId, id) > 0;
    }

    @Transactional(readOnly = true)
    @Override
    public Course findCourseById(Integer brandId,Integer id) {
        Course course = courseMapper.findCourseById(brandId, id);
        CourseExt courseIntroduceAndOther = courseExtMapper.findCourseIntroduceAndOther(brandId, id);
        if (courseIntroduceAndOther != null)
            course.setIntroduce(courseIntroduceAndOther.getIntroduce()).setOther(courseIntroduceAndOther.getOther());
        return course;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Course> findCourseByTeacherId(Integer brandId, PageReq<Course> pageReq) {
        Course course = pageReq.getT();
        pageReq = checkLastId(brandId,pageReq);
        List<Course> courses = courseMapper.findCourseByTeacherId(brandId, course, pageReq.getLastId(), pageReq.getPageSize());
        courses.forEach(course1 -> course1.setBrandId(brandId));
        return reserveCourseApi.findReserveNumberByCourseId(courses);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Course> findCourseByTime(Integer brandId,PageReq<Course> pageReq) {
        Course course = pageReq.getT();
        pageReq = checkLastId(brandId,pageReq);
        List<Course> courses = courseMapper.findCourseByTime(brandId, course, pageReq.getLastId(), pageReq.getPageSize());
        courses.forEach(course1 -> course1.setBrandId(brandId));
        return reserveCourseApi.findReserveNumberByCourseId(courses);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Course> findCourseByStoresId(Integer brandId, PageReq<Course> pageReq) {
        Course course = pageReq.getT();
        pageReq = checkLastId(brandId,pageReq);
        List<Course> courses = courseMapper.findCourseByStoresId(brandId, course, pageReq.getLastId(), pageReq.getPageSize());
        courses.forEach(course1 -> course1.setBrandId(brandId));
        return reserveCourseApi.findReserveNumberByCourseId(courses);
    }

    @Transactional
    @Override
    public boolean updateCourse(Integer brandId, Course course) {
        int i = courseMapper.updateCourse(brandId, course);
        if (i > 0 && (course.getOther() != null || course.getIntroduce() != null)) {
            CourseExt courseIntroduceAndOther = courseExtMapper.findCourseIntroduceAndOther(brandId, course.getId());
            if (courseIntroduceAndOther != null)
                return courseExtMapper.updateCourseIntroduceAndOther(brandId, course.getId(), course.getIntroduce(), course.getOther()) > 0;
            return courseExtMapper.addCourseIntroduceAndOther(brandId,course.getId(),course.getIntroduce(),course.getOther()) > 0;
        }
        return i > 0;
    }

    @Transactional
    @Override
    public void createCourseTable(Integer brandId) {
        courseMapper.createCourseTable(brandId);
        courseExtMapper.createCourseExtTable(brandId);
    }

    @Override
    protected Integer getMinId(Integer brandId,PageReq<Course> pageReq) {
        Integer minId = courseMapper.getMinId(brandId);
        return minId == null ? - 1 : minId - 1;
    }
}
