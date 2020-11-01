package consumer.controller;

import api.TeacherApi;
import api.pojo.PageReq;
import api.pojo.Res;
import api.pojo.StateCode;
import api.pojo.Teacher;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherConsumerController {

    @Reference
    private TeacherApi teacherApi;

    // 测试通过
    @RequestMapping(value = "/addTeacher",method = RequestMethod.POST)
    public Res<Void> addTeacher(@RequestBody Teacher teacher){
        return teacherApi.addTeacher(teacher) ? new Res<>(StateCode.OPERATION_SUCCEED) : new Res<>(StateCode.OPERATION_FAILURE);
    }

    // 测试通过
    @RequestMapping(value = "/updateTeacher",method = RequestMethod.POST)
    public Res<Void> updateTeacher(@RequestBody Teacher teacher){
        return teacherApi.updateTeacher(teacher) ? new Res<>(StateCode.OPERATION_SUCCEED) : new Res<>(StateCode.OPERATION_FAILURE);
    }

    // 测试通过
    @RequestMapping(value = "/findTeacherById/{id}",method = RequestMethod.GET)
    public Res<Teacher> findTeacherById(@PathVariable("id") Integer id){
        return new Res<>(StateCode.OPERATION_SUCCEED,teacherApi.findTeacherById(id));
    }

    // 测试通过
    @RequestMapping(value = "/findTeachersByBrandIdAndStoresId",method = RequestMethod.POST)
    public Res<List<Teacher>> findTeachersByBrandIdAndStoresId(@RequestBody Teacher teacher){
        teacher.setT(teacher);
        return new Res<>(StateCode.OPERATION_SUCCEED,teacherApi.findTeachersByBrandIdAndStoresId(teacher));
    }
}
