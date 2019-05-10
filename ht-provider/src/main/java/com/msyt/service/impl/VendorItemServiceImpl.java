package com.msyt.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.msyt.entity.Contacts;
import com.msyt.entity.VendorItem;
import com.msyt.vo.VendorItemVo;
import com.msyt.mapper.ContactsMapper;
import com.msyt.mapper.VendorItemMapper;
import com.msyt.service.VendorItemService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description: 供应商商品实现接口
 * @author: Brian
 * @date: 2019-04-20
 */
@Service
public class VendorItemServiceImpl implements VendorItemService {

    @Resource
    private VendorItemMapper vendorItemMapper;
    @Resource
    private ContactsMapper contactsMapper;

    /**
     * 列表查询
     *
     * @return
     */
    @Override
    public List<VendorItem> findAll() throws Exception {
        return vendorItemMapper.findAll();
    }

    /**
     * 新增商品
     *
     * @param vendorItem
     * @return
     */
    @Override
    public void insert(VendorItem vendorItem) throws Exception {
        vendorItemMapper.insert(vendorItem);
    }

    /**
     * 删除商品
     *
     * @param
     * @param id
     * @return
     */
    @Override
    public void delete(Long id) throws Exception {
        vendorItemMapper.delete(id);
    }

    /**
     * 修改商品
     *
     * @param vendorItem
     * @return
     */
    @Override
    public void update(VendorItem vendorItem) throws Exception {
        vendorItemMapper.update(vendorItem);
    }

    /**
     * 查找商品
     *
     * @param id
     * @return
     */
    @Override
    public VendorItem find(Long id) throws Exception {
        return vendorItemMapper.find(id);
    }

    /**
     * 根据供应商ID删除商品
     *
     * @param vendorId
     * @return
     */
    @Override
    public void deleteByVendorId(Long vendorId) throws Exception {
        vendorItemMapper.deleteByVendorId(vendorId);
    }

    /**
     * 根据供应商ID查找商品
     *
     * @param vendorId
     * @return
     */
    @Override
    public List<VendorItem> findByVendorId(Long vendorId) throws Exception {
        return vendorItemMapper.findByVendorId(vendorId);
    }

    /**
     * 搜索查找
     *
     * @param vendorItem
     * @return
     */
    @Override
    public List<VendorItem> findBy(VendorItem vendorItem) throws Exception {
        return vendorItemMapper.findBy(vendorItem);
    }

    /**
     * 查找供应商+商品集
     *
     * @param itemIds
     * @return
     */
    @Override
    public List<VendorItemVo> findByItemIds(List<String> itemIds) throws Exception {
        List<VendorItemVo> vendorItemVos = vendorItemMapper.findByItemIds(itemIds);
        List<Long> vendorIds = new ArrayList<>();
        for (VendorItemVo vo : vendorItemVos) {
            vendorIds.add(vo.getVendorId());
        }

        // 联系人分组
        Map<Long, List<Contacts>> contactsMap = new HashMap<>();
        List<Contacts> contactsList = contactsMapper.findByVendorIds(vendorIds);
        for (Contacts contacts : contactsList) {
            if (contactsMap.containsKey(contacts.getVendorId())) {
                contactsMap.get(contacts.getVendorId()).add(contacts);
            } else {
                List<Contacts> list = new ArrayList<>();
                list.add(contacts);
                contactsMap.put(contacts.getVendorId(), list);
            }
        }

        // 设置每个子单的联系人集合
        for (VendorItemVo vendorItemVo : vendorItemVos) {
            List list = contactsMap.get(vendorItemVo.getVendorId());
            vendorItemVo.setContactsList(list);
        }

        return vendorItemVos;
    }
}
