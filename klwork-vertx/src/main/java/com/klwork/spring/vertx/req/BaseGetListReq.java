package com.klwork.spring.vertx.req;

public class BaseGetListReq<T extends BaseGetListReq> extends BaseReq {

    protected static final int DEFAULT_LENGTH = 20;

    /**
     * 起始位置
     */
    private Integer offset = 0;

    /**
     * 分页大小
     */
    private Integer length = DEFAULT_LENGTH;

    private String sortKey;


    private String sortType;


    private String token;

    private T param;

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }


    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    // private Map<String, String> orderBy;

}
