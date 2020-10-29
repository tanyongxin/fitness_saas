package api;


import api.pojo.Brand;

public interface BrandApi {

    boolean addBrand(Brand brand);

    Brand findBrand(Integer id);

    Brand findBrandAndIntroduce(Integer id);

    boolean updateBrand(Brand brand);
}
