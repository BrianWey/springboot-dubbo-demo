package com.msyt.service;

import com.msyt.entity.VendorEntity;

import java.util.List;

/**
 * @author Brian
 * @description: 供应商接口
 * @date 2019/4/20
 */

public interface VendorService {
    /**
     * 列表查询
     *
     * @return
     */
    List findAll() throws Exception;

    /**
     * 新增供应商
     *
     * @param vendorEntity
     * @return
     */
    Long insert(VendorEntity vendorEntity) throws Exception;

    /**
     * 删除供应商
     *
     * @param vendorId
     * @return
     */
    void delete(Long vendorId) throws Exception;

    /**
     * 修改供应商
     *
     * @param vendorEntity
     * @return
     */
    void update(VendorEntity vendorEntity) throws Exception;

    /**
     * 查找供应商
     *
     * @param id
     * @return
     */
    VendorEntity find(Long id) throws Exception;

    /**
     * 查找
     *
     * @param vendorEntity
     * @return
     */
    List<VendorEntity> findBy(VendorEntity vendorEntity) throws Exception;
}
