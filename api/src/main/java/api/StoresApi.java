package api;

import api.pojo.PageReq;
import api.pojo.Stores;

import java.util.List;

public interface StoresApi {

    boolean addStores(Stores stores);

    boolean delStores(Integer brandId,Integer id); // 表示暂停营业

    Stores findStores(Integer brandId,Integer id); // 根据主键查询 Stores

    List<Stores> findStoresByBrandId(Integer brandId, PageReq<Stores> pageReq); // 根据品牌 id 查询旗下的门店

    boolean updateStores(Integer brandId,Stores stores);

    // 创建对应的门店表结构，子类实现时需要调用 CourseApi 创建对应的课程表结构
    void createStoresTable(Integer brandId);

}
