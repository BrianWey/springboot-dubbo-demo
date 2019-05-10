package com.msyt.service;

import com.msyt.entity.VendorPO;

import java.util.List;

/**
 * @author Brian
 * @description: 供应商采购单接口
 * @date 2019/4/23
 */

public interface VendorPOService {
    /**
     * 列表查询
     *
     * @return
     */
    List<VendorPO> findAll() throws Exception;

    /**
     * 新增供应商采购单
     *
     * @param vendorPO
     * @return
     */
    Long insert(VendorPO vendorPO) throws Exception;

    /**
     * 删除供应商采购单
     *
     * @param id
     * @return
     */
    void delete(Long id) throws Exception;

    /**
     * 修改供应商采购单
     *
     * @param vendorPO
     * @return
     */
    void update(VendorPO vendorPO) throws Exception;

    /**
     * 查找供应商采购单
     *
     * @param id
     * @return
     */
    VendorPO find(Long id) throws Exception;

    /**
     * 搜索查找
     *
     * @param vendorPO
     * @return
     */
    List<VendorPO> findBy(VendorPO vendorPO) throws Exception;

    /**
     * 新增供应商采购单
     *
     * @param vendorPO
     * @param poEntryIds
     * @return
     */
    void saveAdd(VendorPO vendorPO, List<String> poEntryIds) throws Exception;

    /**
     * 供应商端推送
     *
     * @param poId
     * @return
     */
    void publishTo(Long poId) throws Exception;
}
