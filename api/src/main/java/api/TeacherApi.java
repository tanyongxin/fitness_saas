package api;

import api.pojo.PageReq;
import api.pojo.Teacher;
import java.util.List;

public interface TeacherApi {

    boolean addTeacher(Teacher teacher);

    boolean updateTeacher(Teacher teacher);

    Teacher findTeacherById(Integer id);

    List<Teacher> findTeachersByBrandIdAndStoresId(PageReq<Teacher> pageReq);

}
