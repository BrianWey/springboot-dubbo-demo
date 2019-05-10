package com.msyt.service;

import com.msyt.entity.PurchaseEntry;
import com.msyt.entity.PurchaseItem;

import java.util.List;

/**
 * @author Brian
 * @description: 采购子单接口
 * @date 2019/4/23
 */

public interface PurchaseEntryService {
    /**
     * 列表查询
     *
     * @return
     */
    List<PurchaseEntry> findAll() throws Exception;

    /**
     * 新增采购子单
     *
     * @param purchaseEntry
     * @return
     */
    Long insert(PurchaseEntry purchaseEntry) throws Exception;

    /**
     * 删除采购子单
     *
     * @param id
     * @return
     */
    void delete(Long id) throws Exception;

    /**
     * 修改采购子单
     *
     * @param purchaseEntry
     * @return
     */
    void update(PurchaseEntry purchaseEntry) throws Exception;

    /**
     * 查找采购子单
     *
     * @param id
     * @return
     */
    PurchaseEntry find(Long id) throws Exception;

    /**
     * 搜索查找
     *
     * @param purchaseEntry
     * @return
     */
    List<PurchaseEntry> findBy(PurchaseEntry purchaseEntry) throws Exception;

    /**
     * 批量添加
     *
     * @param purchaseItemList
     * @return
     */
    void batchAdd(List<PurchaseEntry> purchaseItemList) throws Exception;

    /**
     * 新增采购子单
     *
     * @param purchaseEntry
     * @param purchaseItemList
     * @return
     */
    PurchaseEntry saveAdd(PurchaseEntry purchaseEntry, List<PurchaseItem> purchaseItemList) throws Exception;
}
