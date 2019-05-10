package com.msyt.service;

import com.msyt.entity.Contacts;

import java.util.List;

/**
 * @author Brian
 * @description: 联系人接口
 * @date 2019/4/20
 */
public interface ContactsService {

    /**
     * 列表查询
     *
     * @return
     */
    List findAll() throws Exception;

    /**
     * 新增联系人
     *
     * @param contacts
     * @return
     */
    void insert(Contacts contacts) throws Exception;

    /**
     * 删除联系人
     *
     * @param id
     * @return
     */
    void delete(Long id) throws Exception;

    /**
     * 修改联系人
     *
     * @param contacts
     * @return
     */
    void update(Contacts contacts) throws Exception;

    /**
     * 查找联系人
     *
     * @param id
     * @return
     */
    Contacts find(Long id) throws Exception;


    /**
     * 根据供应商ID删除联系人
     *
     * @param vendorId
     * @return
     */
    void deleteByVendorId(Long vendorId) throws Exception;

    /**
     * 根据供应商ID查找联系人
     *
     * @param vendorId
     * @return
     */
    List<Contacts> findByVendorId(Long vendorId) throws Exception;

    /**
     * 批量添加联系人
     *
     * @param contactsList
     * @return
     */
    void batchAdd(List contactsList) throws Exception;

    /**
     * 查询
     *
     * @param contacts
     * @return
     */
    List<Contacts> findBy(Contacts contacts) throws Exception;

    /**
     * 批量删除
     *
     * @param vendorIdList
     * @return
     */
    void batchDelete(List<String> vendorIdList) throws Exception;
}
