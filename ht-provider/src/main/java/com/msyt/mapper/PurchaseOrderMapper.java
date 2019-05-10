package com.msyt.mapper;

import com.msyt.entity.PurchaseOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Brian
 * @description: 采购单映射类
 * @date 2019-04-23
 */

@Mapper
public interface PurchaseOrderMapper {

    /**
     * 列表查询
     *
     * @return
     */
    List<PurchaseOrder> findAll();

    /**
     * 新增采购单
     *
     * @param purchaseOrder
     * @return
     */
    Long insert(PurchaseOrder purchaseOrder);

    /**
     * 删除采购单
     *
     * @param id
     * @return
     */
    void delete(@Param(value = "id") Long id);

    /**
     * 修改采购单
     *
     * @param purchaseOrder
     * @return
     */
    void update(PurchaseOrder purchaseOrder);

    /**
     * 查找采购单
     *
     * @param id
     * @return
     */
    PurchaseOrder find(@Param(value = "id") Long id);

    /**
     * 搜索查找
     *
     * @param purchaseOrder
     * @return
     */
    List<PurchaseOrder> findBy(PurchaseOrder purchaseOrder);
}

