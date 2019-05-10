package com.msyt.service;

import com.msyt.entity.PurchaseOrder;

import java.util.List;

/**
 * @author Brian
 * @description: 采购单接口
 * @date 2019/4/23
 */

public interface PurchaseOrderService {
    /**
     * 列表查询
     *
     * @return
     */
    List<PurchaseOrder> findAll() throws Exception;

    /**
     * 新增采购单
     *
     * @param purchaseOrder
     * @return
     */
    Long insert(PurchaseOrder purchaseOrder) throws Exception;

    /**
     * 删除采购单
     *
     * @param id
     * @return
     */
    void delete(Long id) throws Exception;

    /**
     * 修改采购单
     *
     * @param purchaseOrder
     * @return
     */
    void update(PurchaseOrder purchaseOrder) throws Exception;

    /**
     * 查找采购单
     *
     * @param id
     * @return
     */
    PurchaseOrder find(Long id) throws Exception;

    /**
     * 搜索查找
     *
     * @param purchaseOrder
     * @return
     */
    List<PurchaseOrder> findBy(PurchaseOrder purchaseOrder) throws Exception;

    /**
     * 新增采购单
     *
     * @param purchaseOrder
     * @param poEntryIds
     * @return
     */
    void saveAdd(PurchaseOrder purchaseOrder, List<String> poEntryIds) throws Exception;
}
