package stores_course.impl;

import api.AbstractApiImpl;
import api.StoresApi;
import api.pojo.PageReq;
import api.pojo.Stores;
import api.pojo.StoresExt;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import stores_course.dao.StoresExtMapper;
import stores_course.dao.StoresMapper;

import java.util.List;

@Service(interfaceClass = StoresApi.class)
public class StoresApiImpl extends AbstractApiImpl<Stores> implements StoresApi {

    @Autowired
    private StoresMapper storesMapper;

    @Autowired
    private StoresExtMapper storesExtMapper;

    @Autowired
    private CourseApiImpl courseApi;

    @Transactional
    @Override
    public boolean addStores(Stores stores) {
        if (stores.getBrandId() == null || stores.getBrandId() <= 0)
            return false;
        int i = storesMapper.insertStores(stores.getBrandId(),stores);
        if (i > 0 && stores.getOther() != null){
            int k = storesExtMapper.insertStoresExt(stores.getBrandId(),stores.getId(),stores.getOther());
            return k > 0;
        }
        return i > 0;
    }

    @Transactional
    @Override
    public boolean delStores(Integer brandId,Integer id) {
        return storesMapper.delStores(brandId ,id) > 0;
    }

    @Transactional(readOnly = true)
    @Override
    public Stores findStores(Integer brandId,Integer id) {
        Stores stores = storesMapper.selectStoresById(brandId, id);
        if (stores != null){
            StoresExt storesExt = storesExtMapper.selectStoresExtById(brandId, id);
            stores.setOther(storesExt != null ? storesExt.getOther() : "");
            return stores;
        }
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Stores> findStoresByBrandId(Integer brandId,PageReq<Stores> pageReq) {
        pageReq = checkLastId(brandId,pageReq);
//        System.out.println("pageReq : " + pageReq.getLastId());
        return storesMapper.findStoresByBrandId(brandId,pageReq.getLastId(),pageReq.getPageSize());
    }

    @Transactional
    @Override
    public boolean updateStores(Integer brandId,Stores stores) {
        int i = storesMapper.updateStores(brandId, stores);
        if (i > 0 && stores.getOther() != null) {
            // 可能之前并没有对应的 StoresExt 对象
            StoresExt storesExt = storesExtMapper.selectStoresExtById(brandId, stores.getId());
            if (storesExt == null)
                return storesExtMapper.insertStoresExt(brandId,stores.getId(),stores.getOther()) > 0;
            return storesExtMapper.updateStoresExtById(brandId, stores.getId(), stores.getOther()) > 0;
        }
        return i > 0;
    }

    @Transactional
    @Override
    public void createStoresTable(Integer brandId) {
        storesMapper.createStoresTable(brandId);
        storesExtMapper.createStoresExtTable(brandId);
        courseApi.createCourseTable(brandId);
    }

    @Transactional(readOnly = true)
    @Override
    protected Integer getMinId(Integer brandId,PageReq<Stores> pageReq) {
        Integer minId = storesMapper.getMinId(brandId);
        return minId == null ?  - 1 : minId - 1;
    }
}
