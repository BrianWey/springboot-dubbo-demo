package com.msyt.mapper;

import com.msyt.entity.VendorItem;
import com.msyt.vo.VendorItemVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Brian
 * @description: 商品映射类
 * @date 2019-04-20
 */

@Mapper
public interface VendorItemMapper {

    /**
     * 列表查询
     *
     * @return
     */
    List<VendorItem> findAll();

    /**
     * 新增商品
     *
     * @param vendorItem
     * @return
     */
    void insert(VendorItem vendorItem);

    /**
     * 删除商品
     *
     * @param
     * @param id
     * @return
     */
    void delete(@Param(value = "id") Long id);

    /**
     * 修改商品
     *
     * @param vendorItem
     * @return
     */
    void update(VendorItem vendorItem);

    /**
     * 查找商品
     *
     * @param id
     * @return
     */
    VendorItem find(@Param(value = "id") Long id);

    /**
     * 根据供应商ID删除商品
     *
     * @param vendorId
     * @return
     */
    void deleteByVendorId(@Param(value = "vendorId") Long vendorId);

    /**
     * 根据供应商ID查找商品
     *
     * @param vendorId
     * @return
     */
    List<VendorItem> findByVendorId(@Param(value = "vendorId") Long vendorId);

    /**
     * 搜索查找
     *
     * @param vendorItem
     * @return
     */
    List<VendorItem> findBy(VendorItem vendorItem);

    /**
     * 查找供应商+商品集
     *
     * @param itemIds
     * @return
     */
    List<VendorItemVo> findByItemIds(@Param(value = "itemIds") List<String> itemIds);
}

