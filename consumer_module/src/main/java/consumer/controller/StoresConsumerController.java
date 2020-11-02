package consumer.controller;

import api.StoresApi;
import api.pojo.PageReq;
import api.pojo.Res;
import api.pojo.StateCode;
import api.pojo.Stores;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoresConsumerController {

//    @Reference
    private StoresApi storesApi;

    // 测试通过
    @RequestMapping(value = "/addStores/{brandId}",method = RequestMethod.POST)
    public Res<Void> addStores(@PathVariable("brandId") Integer brandId, @RequestBody Stores stores){
       return storesApi.addStores(stores) ? new Res<>(StateCode.OPERATION_SUCCEED) : new Res<>(StateCode.OPERATION_FAILURE);
    }

    // 测试通过
    @RequestMapping(value = "/delStores/{brandId}",method = RequestMethod.GET)
    public Res<Void> delStores(@PathVariable("brandId") Integer brandId,@RequestParam("id") Integer id){
        return storesApi.delStores(brandId, id) ? new Res<>(StateCode.OPERATION_SUCCEED) : new Res<>(StateCode.OPERATION_FAILURE);
    }

    // 测试通过
    @RequestMapping(value = "/findStores/{brandId}",method = RequestMethod.GET)
    public Res<Stores> findStores(@PathVariable("brandId") Integer brandId,@RequestParam("id") Integer id){
        return new Res<>(StateCode.OPERATION_SUCCEED,storesApi.findStores(brandId, id));
    }

    // 测试通过
    @RequestMapping(value = "/findStoresByBrandId/{brandId}",method = RequestMethod.POST)
    public Res<List<Stores>> findStoresByBrandId(@PathVariable("brandId") Integer brandId, @RequestBody PageReq<Stores> req){
        return new Res<>(StateCode.OPERATION_SUCCEED,storesApi.findStoresByBrandId(brandId,req));
    }

    // 测试通过
    @RequestMapping(value = "/updateStores/{brandId}",method = RequestMethod.POST)
    public Res<Void> updateStores(@PathVariable("brandId") Integer brandId, @RequestBody Stores stores){
        return storesApi.updateStores(brandId,stores) ? new Res<>(StateCode.OPERATION_SUCCEED) : new Res<>(StateCode.OPERATION_FAILURE);
    }
}
