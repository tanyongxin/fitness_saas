package api;


import api.pojo.Brand;

public interface BrandApi {

    int addBrand(Brand brand);

    Brand findBrand(Integer id);

    int updateBrand(Brand brand);
}
