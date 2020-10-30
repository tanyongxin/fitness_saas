package consumer.controller;

import api.BrandApi;
import api.pojo.Brand;
import api.pojo.Res;
import api.pojo.StateCode;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@RestController
public class BrandConsumerController {

    @Reference
    BrandApi brandApi;

    @RequestMapping(value = "/addBrand",method = RequestMethod.POST)
    public Res<Void> addBrand(@RequestBody  Brand brand){
        boolean res = brandApi.addBrand(brand);
        return res ? new Res<>(StateCode.OPERATION_SUCCEED) : new Res<>(StateCode.OPERATION_FAILURE);
    }

    @RequestMapping(value = "/findBrand/{id}",method = RequestMethod.GET)
    public Res<Brand> findBrand(@PathVariable("id") Integer id){
        return new Res<>(StateCode.OPERATION_SUCCEED,brandApi.findBrand(id));
    }

    @RequestMapping(value = "/findBrandAndIntroduce/{id}",method = RequestMethod.GET)
    public Res<Brand> findBrandAndIntroduce(@PathVariable("id") Integer id){
        return new Res<>(StateCode.OPERATION_SUCCEED,brandApi.findBrandAndIntroduce(id));
    }

    @RequestMapping(value = "/updateBrand",method = RequestMethod.POST)
    public Res<Void> updateBrand(@RequestBody Brand brand){
        boolean res = brandApi.updateBrand(brand);
        return res ? new Res<>(StateCode.OPERATION_SUCCEED) : new Res<>(StateCode.OPERATION_FAILURE);
    }

}
