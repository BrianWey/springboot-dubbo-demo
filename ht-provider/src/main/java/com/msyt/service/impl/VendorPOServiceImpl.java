package com.msyt.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.msyt.entity.PurchaseOrder;
import com.msyt.entity.VendorPO;
import com.msyt.mapper.PurchaseEntryMapper;
import com.msyt.mapper.PurchaseItemMapper;
import com.msyt.mapper.VendorPOMapper;
import com.msyt.service.PurchaseOrderService;
import com.msyt.service.VendorPOService;

import javax.annotation.Resource;
import java.util.*;


/**
 * @description: 供应商采购单实现接口
 * @author: Brian
 * @date: 2019-04-20
 */
@Service
public class VendorPOServiceImpl implements VendorPOService {

    @Resource
    private VendorPOMapper vendorPOMapper;
    @Resource
    private PurchaseEntryMapper purchaseEntryMapper;
    @Resource
    private PurchaseItemMapper purchaseItemMapper;
    @Resource
    private PurchaseOrderService purchaseOrderService;

    /**
     * 列表查询
     *
     * @return
     */
    @Override
    public List<VendorPO> findAll() throws Exception {
        return vendorPOMapper.findAll();
    }

    /**
     * 新增供应商采购单
     *
     * @param vendorPO
     * @return
     */
    @Override
    public Long insert(VendorPO vendorPO) throws Exception {
        return vendorPOMapper.insert(vendorPO);
    }

    /**
     * 删除供应商采购单
     *
     * @param id
     * @return
     */
    @Override
    public void delete(Long id) throws Exception {
        vendorPOMapper.delete(id);
    }

    /**
     * 修改供应商采购单
     *
     * @param vendorPO
     * @return
     */
    @Override
    public void update(VendorPO vendorPO) throws Exception {
        vendorPOMapper.update(vendorPO);
    }

    /**
     * 查找供应商采购单
     *
     * @param id
     * @return
     */
    @Override
    public VendorPO find(Long id) throws Exception {
        return vendorPOMapper.find(id);
    }

    /**
     * 搜索查找
     *
     * @param vendorPO
     * @return
     */
    @Override
    public List<VendorPO> findBy(VendorPO vendorPO) throws Exception {
        return vendorPOMapper.findBy(vendorPO);
    }

    /**
     * 新增供应商采购单
     *
     * @param vendorPO
     * @param poEntryIds
     * @return
     */
    @Override
    public void saveAdd(VendorPO vendorPO, List<String> poEntryIds) throws Exception {
        vendorPOMapper.insert(vendorPO);
    }

    /**
     * 供应商端推送
     *
     * @param poId
     * @return
     */
    @Override
    public void publishTo(Long poId) throws Exception {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setIdx(poId);
        // 1:待确认、2:待审核、3:已推送、4:已完成'
        purchaseOrder.setStatus(1);
        purchaseOrderService.update(purchaseOrder);
    }
}
