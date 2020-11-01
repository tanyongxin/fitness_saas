package api;

import api.pojo.PageReq;

public abstract class AbstractApiImpl<T> {

    protected  PageReq<T> checkLastId(Integer brandId,PageReq<T> pageReq){
        if (pageReq.getLastId() == null || pageReq.getLastId() <= 0)
            pageReq.setLastId(getMinId(brandId,pageReq));
        return pageReq;
    }

    protected  abstract  Integer getMinId(Integer brandId,PageReq<T> pageReq);
}
