package consumer.controller;

import api.ReserveCourseApi;
import api.pojo.Res;
import api.pojo.ReserveCourse;
import api.pojo.StateCode;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ReserveCourseConsumerController {


    @Reference
    private ReserveCourseApi reserveCourseApi;

    // 测试通过
    @RequestMapping(value = "/addReserveCourse/{memberId}",method = RequestMethod.POST)
    public Res<ReserveCourse.ReserveRes> addReserveCourse(@PathVariable("memberId") Integer memberId, @RequestBody @Valid ReserveCourse reserveCourse, BindingResult bindingResult){
        ReserveCourse.ReserveRes reserveRes = reserveCourseApi.addReserveCourse(reserveCourse);
//        System.out.println("reserveRes : "  + reserveRes.getRes());
//        if (reserveRes == ReserveCourse.ReserveRes.full){
//            System.out.println("full ");
//        }
        return new Res<>(StateCode.OPERATION_SUCCEED,reserveRes) ;
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
