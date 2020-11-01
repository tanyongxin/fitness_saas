package stores_course.dao;

import api.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TeacherMapper {

    int addTeacher(Teacher teacher);

    int updateTeacher(Teacher record);

    Teacher findTeacherById(Integer id);

    List<Teacher> findTeachersByBrandIdAndStoresId(@Param("teacher") Teacher teacher,@Param("lastId") Integer lastId,@Param("pageSize") Integer pageSize);

    Integer getMinId();

}