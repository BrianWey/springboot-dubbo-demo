package com.msyt.mapper;

import com.msyt.entity.VendorPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Brian
 * @description: 供应商采购单映射类
 * @date 2019-04-23
 */

@Mapper
public interface VendorPOMapper {

    /**
     * 列表查询
     *
     * @return
     */
    List<VendorPO> findAll();

    /**
     * 新增供应商采购单
     *
     * @param vendorPO
     * @return
     */
    Long insert(VendorPO vendorPO);

    /**
     * 删除供应商采购单
     *
     * @param id
     * @return
     */
    void delete(@Param(value = "id") Long id);

    /**
     * 修改供应商采购单
     *
     * @param vendorPO
     * @return
     */
    void update(VendorPO vendorPO);

    /**
     * 查找供应商采购单
     *
     * @param id
     * @return
     */
    VendorPO find(@Param(value = "id") Long id);

    /**
     * 搜索查找
     *
     * @param vendorPO
     * @return
     */
    List<VendorPO> findBy(VendorPO vendorPO);
}

