package consumer.controller;


import api.CourseApi;
import api.pojo.Course;
import api.pojo.PageReq;
import api.pojo.Res;
import api.pojo.StateCode;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CourseConsumerController {


//    @Reference
    private CourseApi courseApi;

    // 测试通过
    @RequestMapping(value = "/addCourse/{brandId}",method = RequestMethod.POST)
    public Res<Void> addCourse(@PathVariable("brandId")Integer brandId, @RequestBody @Valid Course course, BindingResult bindingResult){
        System.out.println(course);
        return courseApi.addCourse(brandId, course) ? new Res<>(StateCode.OPERATION_SUCCEED) : new Res<>(StateCode.OPERATION_FAILURE);
    }

    // 测试通过
    @RequestMapping(value = "/delCourse/{brandId}",method = RequestMethod.GET)
    public Res<Void> delCourse(@PathVariable("brandId")Integer brandId,@RequestParam("id")Integer id){
        return courseApi.delCourse(brandId, id) ? new Res<>(StateCode.OPERATION_SUCCEED) : new Res<>(StateCode.OPERATION_FAILURE);
    }

    // 测试通过
    @RequestMapping(value = "/findCourseById/{brandId}",method = RequestMethod.GET)
    public Res<Course> findCourseById(@PathVariable("brandId")Integer brandId,@RequestParam("id")Integer id){
        return new Res<>(StateCode.OPERATION_SUCCEED,courseApi.findCourseById(brandId, id));
    }

    // 测试通过
    @RequestMapping(value = "/findCourseByTeacherId/{brandId}",method = RequestMethod.POST)
    public Res<List<Course>> findCourseByTeacherId(@PathVariable("brandId")Integer brandId, @RequestBody Course course){
        course.setT(course);
        return new Res<>(StateCode.OPERATION_SUCCEED,courseApi.findCourseByTeacherId(brandId, course));
    }

    // 测试通过
    @RequestMapping(value = "/findCourseByTime/{brandId}",method = RequestMethod.POST)
    public Res<List<Course>> findCourseByTime(@PathVariable("brandId")Integer brandId, @RequestBody Course course){
        course.setT(course);
        return new Res<>(StateCode.OPERATION_SUCCEED,courseApi.findCourseByTime(brandId, course));
    }

    // 测试通过
    @RequestMapping(value = "/findCourseByStoresId/{brandId}",method = RequestMethod.POST)
    public Res<List<Course>> findCourseByStoresId(@PathVariable("brandId")Integer brandId, @RequestBody Course course){
        course.setT(course);
        return new Res<>(StateCode.OPERATION_SUCCEED,courseApi.findCourseByStoresId(brandId, course));
    }

    // 测试通过
    @RequestMapping(value = "/updateCourse/{brandId}",method = RequestMethod.POST)
    public Res<Void> updateCourse(@PathVariable("brandId")Integer brandId, @RequestBody Course course){
        return courseApi.updateCourse(brandId, course) ? new Res<>(StateCode.OPERATION_SUCCEED) : new Res<>(StateCode.OPERATION_FAILURE);
    }

}
