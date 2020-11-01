package stores_course.dao;

import api.pojo.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
// todo:考虑到是 saas ，因此每个品牌会有与其对应的课程表，不同品牌的课程表名不同，但字段相同，因此查询时需要加上表名前缀，为后期的分库和分表打基础
@Repository
public interface CourseMapper {

    int addCourse(@Param("suffix")Integer suffix,@Param("course") Course course);

    int delCourse(@Param("suffix")Integer suffix,@Param("id") Integer id); // 表示课程结束

    Course findCourseById(@Param("suffix")Integer suffix,@Param("id") Integer id);

    // todo:返回集合都涉及到分页的问题
    // 根据老师 id 查询课程列表，包含是否开始的查询条件，不排序
    List<Course> findCourseByTeacherId(@Param("suffix")Integer suffix,@Param("course")Course course, @Param("lastId") Integer lastId,@Param("pageSize") Integer pageSize);

    // 根据起始时间和结束时间查询课程列表，只查询未开始的，不排序
    List<Course> findCourseByTime(@Param("suffix")Integer suffix,@Param("course")Course course, @Param("lastId") Integer lastId,@Param("pageSize") Integer pageSize);

    // 根据门店 id 查询课程列表，包含是否开始的查询条件，不排序
    List<Course> findCourseByStoresId(@Param("suffix")Integer suffix, @Param("course")Course course,@Param("lastId") Integer lastId,@Param("pageSize") Integer pageSize);

    int updateCourse(@Param("suffix")Integer suffix,@Param("course") Course course);

    void createCourseTable(Integer suffix);

    Integer getMinId(Integer suffix);
}
