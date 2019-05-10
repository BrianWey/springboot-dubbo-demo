package com.msyt.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.msyt.entity.PurchaseItem;
import com.msyt.entity.PurchaseOrder;
import com.msyt.entity.VendorPO;
import com.msyt.mapper.PurchaseItemMapper;
import com.msyt.mapper.VendorPOMapper;
import com.msyt.service.PurchaseItemService;

import javax.annotation.Resource;
import java.util.*;


/**
 * @description: 采购单实现接口
 * @author: Brian
 * @date: 2019-04-20
 */
@Service
public class PurchaseItemServiceImpl implements PurchaseItemService {

    @Resource
    private PurchaseItemMapper purchaseItemMapper;
    @Resource
    private VendorPOMapper vendorPOMapper;

    /**
     * 列表查询
     *
     * @return
     */
    @Override
    public List<PurchaseItem> findAll() {
        return purchaseItemMapper.findAll();
    }

    /**
     * 新增采购子单商品
     *
     * @param purchaseItem
     * @return
     */
    @Override
    public Long insert(PurchaseItem purchaseItem) {
        return purchaseItemMapper.insert(purchaseItem);
    }

    /**
     * 删除采购子单商品
     *
     * @param id
     * @return
     */
    @Override
    public void delete(Long id) {
        purchaseItemMapper.delete(id);
    }

    /**
     * 修改采购子单商品
     *
     * @param purchaseItem
     * @return
     */
    @Override
    public void update(PurchaseItem purchaseItem) {
        purchaseItemMapper.update(purchaseItem);
    }

    /**
     * 查找采购子单商品
     *
     * @param id
     * @return
     */
    @Override
    public PurchaseItem find(Long id) {
        return purchaseItemMapper.find(id);
    }

    /**
     * 搜索查找
     *
     * @param purchaseItem
     * @return
     */
    @Override
    public List<PurchaseItem> findBy(PurchaseItem purchaseItem) throws Exception {
        return purchaseItemMapper.findBy(purchaseItem);
    }

    /**
     * 批量添加
     *
     * @param purchaseItemList
     * @return
     */
    @Override
    public void batchAdd(List<PurchaseItem> purchaseItemList) throws Exception {
        purchaseItemMapper.batchAdd(purchaseItemList);
    }

    /**
     * 推送至供应商端
     *
     * @param poId
     */
    @Override
    public void publishToVendor(Long poId) throws Exception {
        PurchaseItem purchaseItem = new PurchaseItem();
        purchaseItem.setPoId(poId);
        List<PurchaseItem> purchaseItemList = purchaseItemMapper.findBy(purchaseItem);

        // 构建map，按供应商区分
        Map<Long, List<PurchaseItem>> map = new HashMap<>();
        for (PurchaseItem item : purchaseItemList) {
            if (map.containsKey(item.getVendorId())) {
                map.get(item.getVendorId()).add(item);
            } else {
                List<PurchaseItem> list = new ArrayList<>();
                list.add(item);
                map.put(item.getVendorId(), list);
            }
        }
        for (Map.Entry<Long, List<PurchaseItem>> entry : map.entrySet()) {

            VendorPO vendorPO = new VendorPO();
            vendorPO.setPoId(poId);
            // 1:待确认、2:待审核、3:已推送、4:已完成'
            vendorPO.setStatus(1);
            vendorPO.setVendorId(entry.getKey());
            vendorPO.setCreateTime(new Date());

            Integer totalItem = 0;  // 采购数
            Integer totalMoney = 0;  // 采购总金额

            // 构建map，按商品区分
            Map<String, List<PurchaseItem>> itemMap = new HashMap<>();
            List<PurchaseItem> PurchaseItemlist = entry.getValue();
            for (PurchaseItem item : PurchaseItemlist) {
                if (itemMap.containsKey(item.getItemCode())) {
                    itemMap.get(item.getItemCode()).add(item);
                } else {
                    List<PurchaseItem> list = new ArrayList<>();
                    list.add(item);
                    itemMap.put(item.getItemCode(), list);
                }
                totalMoney = item.getPurchasePrice() * item.getPurchaseCount() + totalMoney;
                totalItem += item.getPurchaseCount();

            }

            vendorPO.setItemRangeCount(itemMap.size());
            vendorPO.setItemTotal(totalItem);
            vendorPO.setTotalMoney(totalMoney);

            // 推送
            Long i = vendorPOMapper.insert(vendorPO);

            // 推送成功后修改采购单状态
            if (i == 1) {
                PurchaseOrder purchaseOrder = new PurchaseOrder();
                purchaseOrder.setIdx(poId);
                // 1:待确认、2:待审核、3:已推送、4:已完成'
                purchaseOrder.setStatus(3);
            }
        }
    }
}
