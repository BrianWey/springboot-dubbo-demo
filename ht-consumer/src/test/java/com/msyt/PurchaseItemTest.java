package com.msyt;

import com.alibaba.dubbo.config.annotation.Reference;
import com.msyt.entity.PurchaseItem;
import com.msyt.service.PurchaseItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Brian
 * @date: 2019-04-23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PurchaseItemTest {

    @Reference
    private PurchaseItemService purchaseItemService;

    @Test
    public void testFindAll() {
        try {
            List<PurchaseItem> list = purchaseItemService.findAll();
            for (PurchaseItem i : list) {
                System.out.println(i.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() {
        PurchaseItem purchaseItem = new PurchaseItem();
        purchaseItem.setPoEntryId(new Long(1));
        purchaseItem.setItemCode("1001");
        purchaseItem.setVendorId(new Long(1));
        purchaseItem.setVendorName("供应商1");
        purchaseItem.setStock(100);
        purchaseItem.setItemDesc("不错1");
        purchaseItem.setSupplyPrice(5555);
        purchaseItem.setCurrency("RMB");
        purchaseItem.setExchangeRate(new BigDecimal(0.6));
        purchaseItem.setPurchasePrice(5455);
        purchaseItem.setShipDay(2);
        purchaseItem.setPurchaseCount(50);
        purchaseItem.setShipType("空运");
        purchaseItem.setContactsId(new Long(1));
        purchaseItem.setMsg("供应商有修改");
        purchaseItem.setCreateTime(new Date());
        try {
            purchaseItemService.insert(purchaseItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(purchaseItem.toString());
    }

    @Test
    public void testDelete() {
        try {
            purchaseItemService.delete(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("delete success");
    }

    @Test
    public void testUpdate() {
        PurchaseItem purchaseItem = null;
        try {
            purchaseItem = purchaseItemService.find(new Long(1));
            purchaseItem.setItemCode("BBB");
            purchaseItemService.update(purchaseItem);
            System.out.println(purchaseItem.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFind() {
        PurchaseItem purchaseItem = null;
        try {
            purchaseItem = purchaseItemService.find(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(purchaseItem.toString());
    }

    @Test
    public void testFindBy() {
        PurchaseItem purchaseItem = new PurchaseItem();
        purchaseItem.setIdx(new Long(1));
        List<PurchaseItem> purchaseOrderList = null;
        try {
            purchaseOrderList = purchaseItemService.findBy(purchaseItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (PurchaseItem i : purchaseOrderList) {
            System.out.println(i.toString());
        }
    }

    @Test
    public void testBatchAdd() {
        List<PurchaseItem> purchaseItemList = new ArrayList<>();

        PurchaseItem purchaseItem1 = new PurchaseItem();
        purchaseItem1.setPoEntryId(new Long(1));
        purchaseItem1.setItemCode("1001");
        purchaseItem1.setVendorId(new Long(1));
        purchaseItem1.setVendorName("供应商1");
        purchaseItem1.setStock(100);
        purchaseItem1.setItemDesc("不错1");
        purchaseItem1.setSupplyPrice(5555);
        purchaseItem1.setCurrency("RMB");
        purchaseItem1.setExchangeRate(new BigDecimal(0.6));
        purchaseItem1.setPurchasePrice(5455);
        purchaseItem1.setShipDay(2);
        purchaseItem1.setPurchaseCount(50);
        purchaseItem1.setShipType("空运");
        purchaseItem1.setContactsId(new Long(1));
        purchaseItem1.setMsg("供应商有修改");
        purchaseItem1.setCreateTime(new Date());
        purchaseItemList.add(purchaseItem1);

        PurchaseItem purchaseItem2 = new PurchaseItem();
        purchaseItem2.setPoEntryId(new Long(1));
        purchaseItem2.setItemCode("1001");
        purchaseItem2.setVendorId(new Long(1));
        purchaseItem2.setVendorName("供应商1");
        purchaseItem2.setStock(100);
        purchaseItem2.setItemDesc("不错1");
        purchaseItem2.setSupplyPrice(5555);
        purchaseItem2.setCurrency("RMB");
        purchaseItem2.setExchangeRate(new BigDecimal(0.6));
        purchaseItem2.setPurchasePrice(5455);
        purchaseItem2.setShipDay(2);
        purchaseItem2.setPurchaseCount(50);
        purchaseItem2.setShipType("空运");
        purchaseItem2.setContactsId(new Long(1));
        purchaseItem2.setMsg("供应商有修改");
        purchaseItem2.setCreateTime(new Date());
        purchaseItemList.add(purchaseItem2);

        try {
            purchaseItemService.batchAdd(purchaseItemList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (PurchaseItem purchaseItem : purchaseItemList) {
            System.out.println(purchaseItem.toString());
        }
    }
}
