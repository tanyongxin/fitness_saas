package stores_course.impl;

import api.StoresApi;
import api.pojo.Stores;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(interfaceClass = StoresApi.class)
public class StoresApiImpl implements StoresApi {


    @Override
    public int addStores(Stores stores) {
        return 0;
    }

    @Override
    public int delStores(Integer id) {
        return 0;
    }

    @Override
    public Stores findStores(Integer id) {
        return null;
    }

    @Override
    public List<Stores> findStoresByBrandId(Integer brandId) {
        return null;
    }

    @Override
    public int updateStores(Stores stores) {
        return 0;
    }

    @Override
    public void createStoresTable(Integer brandId) {

    }
}
