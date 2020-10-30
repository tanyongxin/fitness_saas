package api;


import api.pojo.Course;

import java.util.List;

public interface CourseApi {

    int addCourse(Course course);

    int delCourse(Integer id); // 表示课程结束

    Course findCourseById(Integer id);

    List<Course> findCourseByTeacherId(Integer teacherId,Integer lastId,Integer pageSize); // 根据老师 id 查询课表

    List<Course> findCourseByTime(String startTime,String endTime,Integer lastId,Integer pageSize); // 根据时间查询课表

    List<Course> findCourseByStoresId(Integer storesId,Integer lastId,Integer pageSize); // 根据门店 id 查询课表

    int updateCourse(Course course);

    // 创建对应的课程表结构
    void createCourseTable(Integer brandId);

}
