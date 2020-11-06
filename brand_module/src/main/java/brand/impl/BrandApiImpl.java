package brand.impl;

import api.BrandApi;
import api.StoresApi;
import api.pojo.Brand;
import api.pojo.BrandIntroduce;
import brand.dao.BrandIntroduceMapper;
import brand.dao.BrandMapper;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service(interfaceClass = BrandApi.class)
public class BrandApiImpl implements BrandApi {

    @Autowired
    private BrandIntroduceMapper brandIntroduceMapper;

    @Autowired
    private BrandMapper brandMapper;

//    @Reference
    private StoresApi storesApi;

    @Transactional
    @Override
    public boolean addBrand(Brand brand) {
        int i = brandMapper.addBrand(brand);
        int k = 1;
        if (brand.getIntroduce() != null)
            k = brandIntroduceMapper.addBrandIntroduce(brand.getId(),brand.getIntroduce());
        // 调用 storesApi 创建对应的门店表结构
        storesApi.createStoresTable(brand.getId());
        return i > 0 && k > 0;
    }

    @Transactional(readOnly = true)
    @Override
    public Brand findBrand(Integer id) {
        return brandMapper.findBrand(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Brand findBrandAndIntroduce(Integer id) {
        Brand brand = brandMapper.findBrand(id);
        BrandIntroduce brandIntroduce = brandIntroduceMapper.findBrandIntroduce(id);
        if (brand != null){
            brand.setIntroduce(brandIntroduce != null ? brandIntroduce.getIntroduce() : null);
            return brand;
        }
        return null;
    }

    @Transactional
    @Override
    public boolean updateBrand(Brand brand) {
        int i = brandMapper.updateBrand(brand);
        if (i > 0 && brand.getIntroduce() != null){
            BrandIntroduce brandIntroduce = brandIntroduceMapper.findBrandIntroduce(brand.getId());
            if (brandIntroduce != null)
                return brandIntroduceMapper.updateBrandIntroduce(brand.getId(), brand.getIntroduce()) > 0;
            brandIntroduceMapper.addBrandIntroduce(brand.getId(),brand.getIntroduce());
        }
        return i > 0;
    }
}
