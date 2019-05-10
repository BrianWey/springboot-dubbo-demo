package com.msyt.mapper;

import com.msyt.entity.VendorEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Brian
 * @description: 供应商映射类
 * @date 2019-04-20
 */

@Mapper
public interface VendorMapper {

    /**
     * 查询列表
     *
     * @return
     */
    List<VendorEntity> findAll();

    /**
     * 新增供应商
     *
     * @param vendorEntity
     * @return
     */
    Long insert(VendorEntity vendorEntity);

    /**
     * 删除供应商
     *
     * @param id
     * @return
     */
    void delete(@Param(value = "id") Long id);

    /**
     * 修改供应商
     *
     * @param vendorEntity
     * @return
     */
    void update(VendorEntity vendorEntity);

    /**
     * 查找供应商
     *
     * @param id
     * @return
     */
    VendorEntity find(@Param(value = "id") Long id);

    /**
     * 搜索查找
     *
     * @param vendorEntity
     * @return
     */
    List<VendorEntity> findBy(VendorEntity vendorEntity);
}

