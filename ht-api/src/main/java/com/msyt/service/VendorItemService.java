package com.msyt.service;

import com.msyt.entity.VendorItem;
import com.msyt.vo.VendorItemVo;

import java.util.List;

/**
 * @author Brian
 * @description: 商品接口
 * @date 2019/4/20
 */

public interface VendorItemService {

    /**
     * 列表查询
     *
     * @return
     */
    List<VendorItem> findAll() throws Exception;

    /**
     * 新增商品
     *
     * @param vendorItem
     * @return
     */
    void insert(VendorItem vendorItem) throws Exception;

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    void delete(Long id) throws Exception;

    /**
     * 修改商品
     *
     * @param vendorItem
     * @return
     */
    void update(VendorItem vendorItem) throws Exception;

    /**
     * 查找商品
     *
     * @param id
     * @return
     */
    VendorItem find(Long id) throws Exception;


    /**
     * 根据供应商ID删除商品
     *
     * @param vendorId
     * @return
     */
    void deleteByVendorId(Long vendorId) throws Exception;

    /**
     * 根据供应商ID查找商品
     *
     * @param vendorId
     * @return
     */
    List<VendorItem> findByVendorId(Long vendorId) throws Exception;

    /**
     * 搜索查找
     *
     * @param vendorItem
     * @return
     */
    List<VendorItem> findBy(VendorItem vendorItem) throws Exception;

    /**
     * 查找供应商+商品集
     *
     * @param itemIds
     * @return
     */
    List<VendorItemVo> findByItemIds(List<String> itemIds) throws Exception;
}
