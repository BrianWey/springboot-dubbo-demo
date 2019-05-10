package com.msyt.mapper;

import com.msyt.entity.PurchaseItem;
import com.msyt.entity.PurchaseOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Brian
 * @description: 采购子单商品映射类
 * @date 2019-04-23
 */

@Mapper
public interface PurchaseItemMapper {

    /**
     * 列表查询
     *
     * @return
     */
    List<PurchaseItem> findAll();

    /**
     * 新增采购子单商品
     *
     * @param purchaseItem
     * @return
     */
    Long insert(PurchaseItem purchaseItem);

    /**
     * 删除采购子单商品
     *
     * @param id
     * @return
     */
    void delete(@Param(value = "id") Long id);

    /**
     * 修改采购子单商品
     *
     * @param purchaseItem
     * @return
     */
    void update(PurchaseItem purchaseItem);

    /**
     * 查找采购子单商品
     *
     * @param id
     * @return
     */
    PurchaseItem find(@Param(value = "id") Long id);

    /**
     * 搜索查找
     *
     * @param purchaseItem
     * @return
     */
    List<PurchaseItem> findBy(PurchaseItem purchaseItem);

    /**
     * 批量添加
     *
     * @param purchaseItemList
     * @return
     */
    void batchAdd(@Param(value = "purchaseItemList") List<PurchaseItem> purchaseItemList);

    /**
     * 批量修改
     *
     * @param map
     * @return
     */
    void updateByEntryIds(Map<String, Object> map);
}

