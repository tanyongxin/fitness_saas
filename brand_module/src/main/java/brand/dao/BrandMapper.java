package brand.dao;

import api.pojo.Brand;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandMapper {


    int addBrand(Brand brand);


    Brand findBrand(Integer id);


    int updateBrand(Brand brand);

    int delBrand(Integer id);

}
