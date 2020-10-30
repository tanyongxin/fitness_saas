package api;

import api.pojo.Stores;

import java.util.List;

public interface StoresApi {

    int addStores(Stores stores);

    int delStores(Integer id); // 表示暂停营业

    Stores findStores(Integer id); // 根据主键查询 Stores

    List<Stores> findStoresByBrandId(Integer brandId); // 根据品牌 id 查询旗下的门店

    int updateStores(Stores stores);

    // 创建对应的门店表结构，子类实现时需要调用 CourseApi 创建对应的课程表结构
    void createStoresTable(Integer brandId);

}
