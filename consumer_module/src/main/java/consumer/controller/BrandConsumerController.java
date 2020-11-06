package consumer.controller;

import api.BrandApi;
import api.pojo.Brand;
import api.pojo.Res;
import api.pojo.StateCode;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class BrandConsumerController {

    @Reference
    BrandApi brandApi;


    // 测试通过
    @RequestMapping(value = "/addBrand",method = RequestMethod.POST)
    public Res<Void> addBrand(@RequestBody @Valid Brand brand, BindingResult bindingResult){
        boolean res = brandApi.addBrand(brand);
        return res ? new Res<>(StateCode.OPERATION_SUCCEED) : new Res<>(StateCode.OPERATION_FAILURE);
    }

    // 测试通过
    @RequestMapping(value = "/findBrand/{id}",method = RequestMethod.GET)
    public Res<Brand> findBrand(@PathVariable("id") Integer id){
        return new Res<>(StateCode.OPERATION_SUCCEED,brandApi.findBrand(id));
    }

    // 测试通过
    @RequestMapping(value = "/findBrandAndIntroduce/{id}",method = RequestMethod.GET)
    public Res<Brand> findBrandAndIntroduce(@PathVariable("id") Integer id){
        return new Res<>(StateCode.OPERATION_SUCCEED,brandApi.findBrandAndIntroduce(id));
    }

    // 测试通过
    @RequestMapping(value = "/updateBrand",method = RequestMethod.POST)
    public Res<Void> updateBrand(@RequestBody Brand brand){
        boolean res = brandApi.updateBrand(brand);
        return res ? new Res<>(StateCode.OPERATION_SUCCEED) : new Res<>(StateCode.OPERATION_FAILURE);
    }

}
