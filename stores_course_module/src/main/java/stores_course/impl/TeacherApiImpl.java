package stores_course.impl;

import api.AbstractApiImpl;
import api.TeacherApi;
import api.pojo.PageReq;
import api.pojo.Teacher;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import stores_course.dao.TeacherMapper;
import java.util.List;

@Service(interfaceClass = TeacherApi.class)
public class TeacherApiImpl extends AbstractApiImpl<Teacher> implements TeacherApi {

    @Autowired
    private TeacherMapper teacherMapper;

    @Transactional
    @Override
    public boolean addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher) > 0;
    }

    @Transactional
    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher) > 0;
    }

    @Transactional(readOnly = true)
    @Override
    public Teacher findTeacherById(Integer id) {
        return teacherMapper.findTeacherById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Teacher> findTeachersByBrandIdAndStoresId(PageReq<Teacher> pageReq) {
        Teacher teacher = pageReq.getT();
        pageReq = checkLastId(teacher.getBrandId(),pageReq);
        return teacherMapper.findTeachersByBrandIdAndStoresId(teacher,pageReq.getLastId(),pageReq.getPageSize());
    }

    @Override
    protected Integer getMinId(Integer brandId,PageReq<Teacher> pageReq) {
        Integer minId = teacherMapper.getMinId();
        return minId == null ? -1 : minId - 1;
    }
}
