package com.msyt.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.msyt.entity.Contacts;
import com.msyt.mapper.ContactsMapper;
import com.msyt.service.ContactsService;

import javax.annotation.Resource;
import java.util.List;


/**
 * @description: 联系人实体实现接口
 * @author: Brian
 * @date: 2019-04-19
 */
@Service
public class ContactsServiceImpl implements ContactsService {

    @Resource
    private ContactsMapper contactsMapper;

    /**
     * 列表查询
     *
     * @return
     */
    @Override
    public List<Contacts> findAll() throws Exception {
        return contactsMapper.findAll();
    }

    /**
     * 新增联系人
     *
     * @param contacts
     * @return
     */
    @Override
    public void insert(Contacts contacts) throws Exception {
        contactsMapper.insert(contacts);
    }

    /**
     * 删除联系人
     *
     * @param id
     * @return
     */
    @Override
    public void delete(Long id) throws Exception {
        contactsMapper.delete(id);
    }

    /**
     * 修改联系人
     *
     * @param contacts
     * @return
     */
    @Override
    public void update(Contacts contacts) throws Exception {
        contactsMapper.update(contacts);
    }

    /**
     * 查找联系人
     *
     * @param id
     * @return
     */
    @Override
    public Contacts find(Long id) throws Exception {
        return contactsMapper.find(id);
    }

    /**
     * 根据供应商ID删除联系人
     *
     * @param vendorId
     * @return
     */
    @Override
    public void deleteByVendorId(Long vendorId) throws Exception {
        contactsMapper.deleteByVendorId(vendorId);
    }

    /**
     * 根据供应商ID查找联系人
     *
     * @param vendorId
     * @return
     */
    @Override
    public List<Contacts> findByVendorId(Long vendorId) throws Exception {
        return contactsMapper.findByVendorId(vendorId);
    }

    /**
     * 批量添加联系人
     *
     * @param contactsList
     * @return
     */
    @Override
    public void batchAdd(List contactsList) throws Exception {
        contactsMapper.batchAdd(contactsList);
    }

    /**
     * 查询contacts
     *
     * @param contacts
     * @return
     */
    @Override
    public List<Contacts> findBy(Contacts contacts) throws Exception {
        return contactsMapper.findBy(contacts);
    }

    /**
     * 批量删除
     *
     * @param vendorIdList
     * @return
     */
    @Override
    public void batchDelete(List<String> vendorIdList) throws Exception {
        contactsMapper.batchDelete(vendorIdList);
    }

}
