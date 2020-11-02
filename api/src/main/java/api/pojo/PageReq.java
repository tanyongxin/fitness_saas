package api.pojo;

import java.io.Serializable;

// 分页的请求对象
public class PageReq<T> implements Serializable {

    private final Integer PAGE_SIZE = 10;

    private T t;

    private Integer lastId;

    protected Integer id;

    public Integer getId() {
        return id;
    }

    public PageReq<T> setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getPageSize() {
        return PAGE_SIZE;
    }

    public T getT() {
        return t;
    }

    public PageReq<T> setT(T t) {
        this.t = t;
        return this;
    }

    public Integer getLastId() {
        return lastId;
    }

    public PageReq<T> setLastId(Integer laseId) {
        this.lastId = laseId;
        return this;
    }
}
