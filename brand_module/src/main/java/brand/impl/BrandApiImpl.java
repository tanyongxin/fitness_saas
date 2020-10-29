package brand.impl;

import api.BrandApi;
import api.pojo.Brand;
import org.apache.dubbo.config.annotation.Service;

@Service(interfaceClass = BrandApi.class)
public class BrandApiImpl implements BrandApi {


    @Override
    public int addBrand(Brand brand) {
        System.out.println("addBrand ... ");
        return 0;
    }

    @Override
    public Brand findBrand(Integer id) {
        System.out.println("findBrand ... ");
        return null;
    }

    @Override
    public int updateBrand(Brand brand) {
        System.out.println("updateBrand ... ");
        return 0;
    }
}
