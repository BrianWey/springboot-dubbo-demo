package com.msyt.mapper;

import com.msyt.entity.PurchaseEntry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Brian
 * @description: 采购子单映射类
 * @date 2019-04-23
 */

@Mapper
public interface PurchaseEntryMapper {

    /**
     * 查询列表
     *
     * @return
     */
    List<PurchaseEntry> findAll();

    /**
     * 新增采购子单
     *
     * @param purchaseEntry
     * @return
     */
    Long insert(PurchaseEntry purchaseEntry);

    /**
     * 删除采购子单
     *
     * @param id
     * @return
     */
    void delete(@Param(value = "id") Long id);

    /**
     * 修改采购子单
     *
     * @param purchaseEntry
     * @return
     */
    void update(PurchaseEntry purchaseEntry);

    /**
     * 查找采购子单
     *
     * @param id
     * @return
     */
    PurchaseEntry find(@Param(value = "id") Long id);

    /**
     * 搜索查找
     *
     * @param purchaseEntry
     * @return
     */
    List<PurchaseEntry> findBy(PurchaseEntry purchaseEntry);

    /**
     * 批量添加批量更新
     *
     * @param purchaseEntryList
     * @return
     */
    void batchAdd(@Param(value = "purchaseEntryList") List<PurchaseEntry> purchaseEntryList);

    /**
     * 批量更新
     *
     * @param purchaseEntryList
     * @return
     */
    void batchUpdate(@Param(value = "purchaseEntryList") List<PurchaseEntry> purchaseEntryList);
}

