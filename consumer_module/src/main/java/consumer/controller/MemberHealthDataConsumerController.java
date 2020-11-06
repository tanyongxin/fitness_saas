package consumer.controller;

import api.MemberHealthDataApi;
import api.pojo.MemberHealthData;
import api.pojo.Res;
import api.pojo.StateCode;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class MemberHealthDataConsumerController {

//    @Reference
    private MemberHealthDataApi memberHealthDataApi;

    // 测试通过
    @RequestMapping(value = "/addMemberHealthData/{memberId}",method = RequestMethod.POST)
    public Res<Void> addMemberHealthData(@PathVariable("memberId") Integer memberId, @RequestBody @Valid MemberHealthData memberHealthData, BindingResult bindingResult){
        return memberHealthDataApi.addMemberHealthData(memberHealthData) ? new Res<>(StateCode.OPERATION_SUCCEED) : new Res<>(StateCode.OPERATION_FAILURE);
    }

    // 测试通过
    @RequestMapping(value = "/calculateHealthData/{memberId}",method = RequestMethod.GET)
    public Res<MemberHealthData.CompareRes> calculateHealthData(@PathVariable("memberId") Integer memberId, @RequestParam("currentId") Integer currentId,
                                                                @RequestParam("lastId") Integer lastId){
        return new Res<>(StateCode.OPERATION_SUCCEED,memberHealthDataApi.calculateHealthData(currentId, lastId));
    }

    // 测试通过
    @RequestMapping(value = "/findMemberHealthDataByTime/{memberId}",method = RequestMethod.POST)
    public Res<List<MemberHealthData>> findMemberHealthDataByTime(@PathVariable("memberId") Integer memberId,@RequestBody MemberHealthData memberHealthData){
        memberHealthData.setT(memberHealthData);
        return new Res<>(StateCode.OPERATION_SUCCEED,memberHealthDataApi.findMemberHealthDataByTime(memberHealthData));
    }

    // 测试通过
    @RequestMapping(value = "/findMemberHealthDataByWeight/{memberId}",method = RequestMethod.POST)
    public Res<List<MemberHealthData>> findMemberHealthDataByWeight(@PathVariable("memberId") Integer memberId,@RequestBody MemberHealthData memberHealthData){
        memberHealthData.setT(memberHealthData);
        return new Res<>(StateCode.OPERATION_SUCCEED,memberHealthDataApi.findMemberHealthDataByWeight(memberHealthData));
    }

    // 测试通过
    @RequestMapping(value = "/findMemberHealthDataByBodyFat/{memberId}",method = RequestMethod.POST)
    public Res<List<MemberHealthData>> findMemberHealthDataByBodyFat(@PathVariable("memberId") Integer memberId,@RequestBody MemberHealthData memberHealthData){
        memberHealthData.setT(memberHealthData);
        return new Res<>(StateCode.OPERATION_SUCCEED,memberHealthDataApi.findMemberHealthDataByBodyFat(memberHealthData));
    }


}
