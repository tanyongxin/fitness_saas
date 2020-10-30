package stores_course.dao;

import api.pojo.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
// todo:考虑到是 saas ，因此每个品牌会有与其对应的课程表，不同品牌的课程表名不同，但字段相同，因此查询时需要加上表名前缀，为后期的分库和分表打基础
@Repository
public interface CourseMapper {

    int addCourse(@Param("suffix")String suffix,@Param("course") Course course);

    int delCourse(@Param("suffix")String suffix,@Param("id") Integer id); // 表示课程结束

    Course findCourseById(@Param("suffix")String suffix,@Param("id") Integer id);

    // todo:返回集合都涉及到分页的问题
    // 根据老师 id 查询课程列表，默认查询未开始的，不排序
    List<Course> findCourseByTeacherId(@Param("suffix")String suffix,@Param("teacherId") Integer teacherId,@Param("isStart") Boolean isStart
            ,@Param("storesId")Integer storesId, @Param("lastId") Integer lastId,@Param("pageSize") Integer pageSize);

    // 根据起始时间和结束时间查询课程列表，只查询未开始的，不排序
    List<Course> findCourseByTime(@Param("suffix")String suffix,@Param("startTime") String startTime, @Param("endTime") String endTime,
                                  @Param("storesId")Integer storesId, @Param("lastId") Integer lastId,@Param("pageSize") Integer pageSize);

    // 根据门店 id 查询课程列表
    List<Course> findCourseByStoresId(@Param("suffix")String suffix,@Param("storesId") Integer storesId,@Param("isStart") Boolean isStart,
                                      @Param("lastId") Integer lastId,@Param("pageSize") Integer pageSize);

    int updateCourse(@Param("suffix")String suffix,@Param("course") Course course);





}
