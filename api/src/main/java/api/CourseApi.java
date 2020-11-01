package api;


import api.pojo.Course;
import api.pojo.PageReq;

import java.util.List;

public interface CourseApi {

    boolean addCourse(Integer brandId,Course course);

    boolean delCourse(Integer brandId,Integer id); // 表示课程结束

    Course findCourseById(Integer brandId,Integer id);

    List<Course> findCourseByTeacherId(Integer brandId, PageReq<Course> pageReq); // 根据老师 id 查询课表

    List<Course> findCourseByTime(Integer brandId,PageReq<Course> pageReq); // 根据时间查询课表

    List<Course> findCourseByStoresId(Integer brandId,PageReq<Course> pageReq); // 根据门店 id 查询课表

    boolean updateCourse(Integer brandId,Course course);

    // 创建对应的课程表结构
    void createCourseTable(Integer brandId);

}
