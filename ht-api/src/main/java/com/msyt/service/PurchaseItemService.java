package com.msyt.service;

import com.msyt.entity.PurchaseItem;

import java.util.List;

/**
 * @author Brian
 * @description: 采购子单商品接口
 * @date 2019/4/23
 */

public interface PurchaseItemService {
    /**
     * 列表查询
     *
     * @return
     */
    List<PurchaseItem> findAll() throws Exception;

    /**
     * 新增采购子单商品
     *
     * @param purchaseItem
     * @return
     */
    Long insert(PurchaseItem purchaseItem) throws Exception;

    /**
     * 删除采购子单商品
     *
     * @param id
     * @return
     */
    void delete(Long id) throws Exception;

    /**
     * 修改采购子单商品
     *
     * @param purchaseItem
     * @return
     */
    void update(PurchaseItem purchaseItem) throws Exception;

    /**
     * 查找采购子单商品
     *
     * @param id
     * @return
     */
    PurchaseItem find(Long id) throws Exception;

    /**
     * 搜索查找
     *
     * @param purchaseItem
     * @return
     */
    List<PurchaseItem> findBy(PurchaseItem purchaseItem) throws Exception;

    /**
     * 批量添加
     *
     * @param purchaseItemList
     * @return
     */
    void batchAdd(List<PurchaseItem> purchaseItemList) throws Exception;

    /**
     * 推送至供应商端
     *
     * @param poId
     */
    void publishToVendor(Long poId) throws Exception;
}
