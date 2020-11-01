package stores_course.dao;

import api.pojo.Stores;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StoresMapper {

    Stores selectStoresById(@Param("suffix")Integer suffix,@Param("id") Integer id);

    int insertStores(@Param("suffix")Integer suffix,@Param("stores") Stores stores);

    int updateStores(@Param("suffix")Integer suffix,@Param("stores") Stores stores);

    int delStores(@Param("suffix")Integer suffix, @Param("id")Integer id);

    List<Stores> findStoresByBrandId(@Param("suffix") Integer suffix, @Param("lastId") Integer lastId,@Param("pageSize") Integer pageSize);

    void createStoresTable(Integer suffix);

    Integer getMinId(Integer suffix);

}