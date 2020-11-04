package consumer.mock;

import api.BrandApi;
import api.pojo.Brand;

public class BrandApiMock implements BrandApi {
    @Override
    public boolean addBrand(Brand brand) {
        return false;
    }

    @Override
    public Brand findBrand(Integer id) {
        System.out.println("id : " + id);
        return null;
    }

    @Override
    public Brand findBrandAndIntroduce(Integer id) {
        return null;
    }

    @Override
    public boolean updateBrand(Brand brand) {
        return false;
    }
}
