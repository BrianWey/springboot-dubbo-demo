package com.msyt.mapper;

import com.msyt.entity.Contacts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Brian
 * @description: 联系人映射类
 * @date 2019-04-18
 */

@Mapper
public interface ContactsMapper {

    /**
     * 列表查询
     *
     * @return
     */
    List<Contacts> findAll();

    /**
     * 新增联系人
     *
     * @param contacts
     * @return
     */
    void insert(Contacts contacts);

    /**
     * 删除联系人
     *
     * @param id
     * @return
     */
    void delete(@Param(value = "id") Long id);

    /**
     * 修改联系人
     *
     * @param contacts
     * @return
     */
    void update(Contacts contacts);

    /**
     * 查找联系人
     *
     * @param id
     * @return
     */
    Contacts find(@Param(value = "id") Long id);

    /**
     * 批量添加联系人
     *
     * @param contactsList
     * @return
     */
    void batchAdd(@Param(value = "contactsList") List contactsList);

    /**
     * 根据供应商ID删除联系人
     *
     * @param vendorId
     * @return
     */
    void deleteByVendorId(@Param(value = "vendorId") Long vendorId);

    /**
     * 根据供应商ID查找联系人
     *
     * @param vendorId
     * @return
     */
    List<Contacts> findByVendorId(@Param(value = "vendorId") Long vendorId);

    /**
     * 搜索查找
     *
     * @param contacts
     * @return
     */
    List<Contacts> findBy(Contacts contacts);

    /**
     * 批量删除
     *
     * @param vendorIdList
     * @return
     */
    void batchDelete(@Param(value = "vendorIdList") List<String> vendorIdList);

    /**
     * 根据供应商IDS查找联系人
     *
     * @param vendorIds
     * @return
     */
    List<Contacts> findByVendorIds(@Param(value = "vendorIds") List<Long> vendorIds);
}

