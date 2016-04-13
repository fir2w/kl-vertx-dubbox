package com.klwork.common.domain.repository;

import java.io.Serializable;

/**
 * 对于DomainObject存取操作的封装
 * 
 * @author ww
 */
public interface DomainRepository <T, PK extends Serializable> {

    /** 
     * 对一个新的实例进行持久化处理。
     * 注意：新生成的主键将直接赋值给newInstance，因此如果需要得到主键的信息，
     * 那么就直接通过newInstance的响应方法取得即可。 
     * 
     * @param newInstance 新建的实例
     */
    int insert(T newInstance);

    /** 
     * 更新实体对象
     * 
     * @param transientObject 未在持久态的对象
     */
    int update(T transientObject);
    

    /** 
     * 删除实体对象 
     * 
     * @param persistentObject 已在数据库中持久的对象
     */
    int delete(T persistentObject);
    
    /**
     * 通过ID删除对象
     * 
     * @param id
     */
    int deleteById(PK id);

    /** 
     * 根据主键得到一个实体对象
     * 
     * @param id 主键对象
     */
    T find(PK id);

}
