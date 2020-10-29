package brand.dao;

import api.pojo.BrandIntroduce;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandIntroduceMapper {

    int addBrandIntroduce(@Param("id") Integer id, @Param("introduce") String introduce);

    BrandIntroduce findBrandIntroduce(Integer id);

    int updateBrandIntroduce(@Param("id") Integer id, @Param("introduce") String introduce);
}