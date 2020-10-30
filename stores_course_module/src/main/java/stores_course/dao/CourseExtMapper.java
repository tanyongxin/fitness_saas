package stores_course.dao;

import api.pojo.CourseExt;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseExtMapper {

    int addCourseIntroduceAndOther(@Param("suffix")String suffix,@Param("id")Integer id,@Param("introduce") String introduce,@Param("other") String other);

    int updateCourseIntroduceAndOther(@Param("suffix")String suffix,@Param("id") Integer id,@Param("introduce") String introduce,@Param("other") String other);

    CourseExt findCourseIntroduceAndOther(@Param("suffix")String suffix,@Param("id") Integer id);
}
