package consumer.controller;

import api.ReserveCourseApi;
import api.pojo.Res;
import api.pojo.ReserveCourse;
import api.pojo.StateCode;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReserveCourseConsumerController {


    @Reference
    private ReserveCourseApi reserveCourseApi;

    // 测试通过
    @RequestMapping(value = "/addReserveCourse/{memberId}",method = RequestMethod.POST)
    public Res<Void> addReserveCourse(@PathVariable("memberId") Integer memberId, @RequestBody ReserveCourse reserveCourse){
        return reserveCourseApi.addReserveCourse(reserveCourse) ? new Res<>(StateCode.OPERATION_SUCCEED) : new Res<>(StateCode.OPERATION_FAILURE);
    }

    // 测试通过
    @RequestMapping(value = "/updateReserveCourse/{memberId}",method = RequestMethod.POST)
    public Res<Void> updateReserveCourse(@PathVariable("memberId") Integer memberId, @RequestBody ReserveCourse reserveCourse){
        return reserveCourseApi.updateReserveCourse(reserveCourse) ? new Res<>(StateCode.OPERATION_SUCCEED) : new Res<>(StateCode.OPERATION_FAILURE);
    }

    // 测试通过
    @RequestMapping(value = "/findReserveCourseById/{memberId}",method = RequestMethod.GET)
    public Res<ReserveCourse> findReserveCourseById(@PathVariable("memberId") Integer memberId,@RequestParam("id") Integer id){
        return new Res<>(StateCode.OPERATION_SUCCEED,reserveCourseApi.findReserveCourseById(id));
    }

    // 测试通过
    @RequestMapping(value = "/findReserveCourseByMemberId/{memberId}",method = RequestMethod.POST)
    public Res<List<ReserveCourse>> findReserveCourseByMemberId(@PathVariable("memberId") Integer memberId, @RequestBody ReserveCourse reserveCourse){
        reserveCourse.setT(reserveCourse);
        return new Res<>(StateCode.OPERATION_SUCCEED,reserveCourseApi.findReserveCourseByMemberId(reserveCourse));
    }
}
