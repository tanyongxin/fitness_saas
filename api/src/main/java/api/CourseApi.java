package api;


import api.pojo.Course;

public interface CourseApi {

    int addCourse(Course course);

    int delCourse(Integer id); // 表示课程结束

    Course findCourseById(Integer id);

    Course findCourseByTeacherId(Integer teacherId);

    Course findCourseByTime(String startTime,String endTime);

    int updateCourse(Course course);

}
