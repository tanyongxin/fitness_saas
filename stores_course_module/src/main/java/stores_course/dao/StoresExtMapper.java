package stores_course.dao;

import api.pojo.StoresExt;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StoresExtMapper {

    int insertStoresExt(@Param("suffix")Integer suffix,@Param("id")Integer id,@Param("other") String other);

    StoresExt selectStoresExtById(@Param("suffix")Integer suffix,@Param("id") Integer id);

    int updateStoresExtById(@Param("suffix")Integer suffix,@Param("id")Integer id,@Param("other") String other);

    void createStoresExtTable(Integer suffix);
}