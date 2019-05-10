package com.msyt.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.msyt.entity.Contacts;
import com.msyt.entity.VendorEntity;
import com.msyt.mapper.ContactsMapper;
import com.msyt.mapper.VendorItemMapper;
import com.msyt.mapper.VendorMapper;
import com.msyt.service.VendorService;

import javax.annotation.Resource;
import java.util.List;


/**
 * @description: 供应商实现接口
 * @author: Brian
 * @date: 2019-04-20
 */
@Service
public class VendorServiceImpl implements VendorService {

    @Resource
    private VendorMapper vendorMapper;

    @Resource
    private ContactsMapper contactsMapper;

    @Resource
    private VendorItemMapper vendorItemMapper;

    /**
     * 列表查询
     *
     * @return
     */
    @Override
    public List<VendorEntity> findAll() {
        return vendorMapper.findAll();
    }

    /**
     * 新增供应商
     *
     * @param vendorEntity
     * @return
     */
    @Override
    public Long insert(VendorEntity vendorEntity) throws Exception {
        vendorMapper.insert(vendorEntity);
        if (vendorEntity.getIdx() != null) {
            List<Contacts> contactsList = vendorEntity.getContactsList();
            for (Contacts contacts : contactsList) {
                contacts.setVendorId(vendorEntity.getIdx());
            }
            contactsMapper.batchAdd(contactsList);
        }
        return vendorEntity.getIdx();
    }

    /**
     * 删除供应商
     *
     * @param vendorId
     * @return
     */
    @Override
    public void delete(Long vendorId) throws Exception {
        // 删除供应商关联的联系人
        contactsMapper.deleteByVendorId(vendorId);

        // 删除供应商关联的商品
        vendorItemMapper.deleteByVendorId(vendorId);

        // 删除供应商
        vendorMapper.delete(vendorId);
    }

    /**
     * 修改供应商
     *
     * @param vendorEntity
     * @return
     */
    @Override
    public void update(VendorEntity vendorEntity) throws Exception {
        vendorMapper.update(vendorEntity);
    }

    /**
     * 查找供应商
     *
     * @param id
     * @return
     */
    @Override
    public VendorEntity find(Long id) throws Exception {
        return vendorMapper.find(id);
    }

    /**
     * 查找
     *
     * @param vendorEntity
     * @return
     */
    @Override
    public List<VendorEntity> findBy(VendorEntity vendorEntity) throws Exception {
        return vendorMapper.findBy(vendorEntity);
    }
}
