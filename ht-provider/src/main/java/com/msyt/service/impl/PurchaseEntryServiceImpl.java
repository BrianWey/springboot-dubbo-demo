package com.msyt.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.msyt.entity.PurchaseEntry;
import com.msyt.entity.PurchaseItem;
import com.msyt.mapper.PurchaseEntryMapper;
import com.msyt.mapper.PurchaseItemMapper;
import com.msyt.service.PurchaseEntryService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * @description: 采购子单实现接口
 * @author: Brian
 * @date: 2019-04-20
 */
@Service
public class PurchaseEntryServiceImpl implements PurchaseEntryService {

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
    public List<PurchaseEntry> findAll() throws Exception {
        return purchaseEntryMapper.findAll();
    }

    /**
     * 新增采购子单
     *
     * @param purchaseEntry
     * @return
     */
    @Override
    public Long insert(PurchaseEntry purchaseEntry) throws Exception {
        return purchaseEntryMapper.insert(purchaseEntry);
    }

    /**
     * 删除采购子单
     *
     * @param id
     * @return
     */
    @Override
    public void delete(Long id) throws Exception {
        purchaseEntryMapper.delete(id);
    }

    /**
     * 修改采购子单
     *
     * @param purchaseEntry
     * @return
     */
    @Override
    public void update(PurchaseEntry purchaseEntry) throws Exception {
        purchaseEntryMapper.update(purchaseEntry);
    }

    /**
     * 查找采购子单
     *
     * @param id
     * @return
     */
    @Override
    public PurchaseEntry find(Long id) throws Exception {
        return purchaseEntryMapper.find(id);
    }

    /**
     * 搜索查找
     *
     * @param purchaseEntry
     * @return
     */
    @Override
    public List<PurchaseEntry> findBy(PurchaseEntry purchaseEntry) throws Exception {
        return purchaseEntryMapper.findBy(purchaseEntry);
    }

    /**
     * 批量添加
     *
     * @param purchaseEntryList
     * @return
     */
    @Override
    public void batchAdd(List<PurchaseEntry> purchaseEntryList) throws Exception {
        purchaseEntryMapper.batchAdd(purchaseEntryList);
    }

    /**
     * 新增采购子单
     *
     * @param purchaseEntry
     * @param purchaseItemList
     * @return
     */
    @Override
    public PurchaseEntry saveAdd(PurchaseEntry purchaseEntry, List<PurchaseItem> purchaseItemList) throws Exception {
        purchaseEntryMapper.insert(purchaseEntry);
        if (purchaseEntry.getIdx() != null) {
            for (PurchaseItem purchaseItem : purchaseItemList) {
                purchaseItem.setPoEntryId(purchaseEntry.getIdx());
                purchaseItem.setCreateTime(new Date());
            }
        }
        purchaseItemMapper.batchAdd(purchaseItemList);
        return purchaseEntry;
    }
}
