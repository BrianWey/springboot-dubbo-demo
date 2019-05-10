package com.msyt.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.msyt.entity.*;
import com.msyt.mapper.*;
import com.msyt.service.PurchaseOrderService;

import javax.annotation.Resource;
import java.util.*;


/**
 * @description: 采购单实现接口
 * @author: Brian
 * @date: 2019-04-20
 */
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Resource
    private PurchaseOrderMapper purchaseOrderMapper;
    @Resource
    private PurchaseEntryMapper purchaseEntryMapper;
    @Resource
    private PurchaseItemMapper purchaseItemMapper;

    /**
     * 列表查询
     *
     * @return
     */
    @Override
    public List<PurchaseOrder> findAll() throws Exception {
        return purchaseOrderMapper.findAll();
    }

    /**
     * 新增采购单
     *
     * @param purchaseOrder
     * @return
     */
    @Override
    public Long insert(PurchaseOrder purchaseOrder) throws Exception {
        return purchaseOrderMapper.insert(purchaseOrder);
    }

    /**
     * 删除采购单
     *
     * @param id
     * @return
     */
    @Override
    public void delete(Long id) throws Exception {
        purchaseOrderMapper.delete(id);
    }

    /**
     * 修改采购单
     *
     * @param purchaseOrder
     * @return
     */
    @Override
    public void update(PurchaseOrder purchaseOrder) throws Exception {
        purchaseOrderMapper.update(purchaseOrder);
    }

    /**
     * 查找采购单
     *
     * @param id
     * @return
     */
    @Override
    public PurchaseOrder find(Long id) throws Exception {
        return purchaseOrderMapper.find(id);
    }

    /**
     * 搜索查找
     *
     * @param purchaseOrder
     * @return
     */
    @Override
    public List<PurchaseOrder> findBy(PurchaseOrder purchaseOrder) throws Exception {
        return purchaseOrderMapper.findBy(purchaseOrder);
    }

    /**
     * 新增采购单
     *
     * @param purchaseOrder
     * @param poEntryIds
     * @return
     */
    @Override
    public void saveAdd(PurchaseOrder purchaseOrder, List<String> poEntryIds) throws Exception {
        purchaseOrder.setCreateTime(new Date());
        purchaseOrder.setUpdateTime(new Date());
        purchaseOrderMapper.insert(purchaseOrder);

        List<PurchaseEntry> purchaseEntryList = new ArrayList<>();
        if (purchaseOrder.getIdx() != null) {
            // 设置poItem表的po_id_的值
            Map<String, Object> map = new HashMap<>();
            map.put("poId", purchaseOrder.getIdx());
            map.put("poEntryIds", poEntryIds);
            purchaseItemMapper.updateByEntryIds(map);

            for (String poEntryId : poEntryIds) {
                PurchaseEntry purchaseEntry = new PurchaseEntry();
                purchaseEntry.setIdx(Long.valueOf(poEntryId));
                purchaseEntry.setPoId(purchaseOrder.getIdx());
                purchaseEntryList.add(purchaseEntry);
            }
        }
        // 设置poEntry表的po_id_的值
        purchaseEntryMapper.batchUpdate(purchaseEntryList);
    }
}
