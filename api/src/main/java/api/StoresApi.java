package api;

import api.pojo.Stores;

public interface StoresApi {

    int addStores(Stores stores);

    int delStores(Integer id); // 表示暂停营业

    Stores findStores(Integer id);

    int updateStores(Stores stores);

}
