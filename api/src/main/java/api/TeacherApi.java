package api;

import api.pojo.Teacher;

public interface TeacherApi {

    int addTeacher(Teacher teacher);

    int updateTeacher(Teacher teacher);

    Teacher findTeacherById(Integer id);

}
