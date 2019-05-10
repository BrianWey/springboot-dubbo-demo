package com.msyt;

import com.alibaba.dubbo.config.annotation.Reference;
import com.msyt.entity.VendorItem;
import com.msyt.service.VendorItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Brian
 * @date: 2019-04-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorItemTest {

    @Reference
    private VendorItemService vendorItemService;

    @Test
    public void testFindAll() {
        try {
            List list = vendorItemService.findAll();
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testInsert() {
        VendorItem vendorItem = new VendorItem();
        vendorItem.setCreateTime(new Date());
        vendorItem.setVendorId(new Long(1));
        vendorItem.setItemDesc("a");
        vendorItem.setBrand("a");
        vendorItem.setCategory("a");
        vendorItem.setShipDay(2);
        vendorItem.setCurrency("RMB");
        vendorItem.setStock(22);
        vendorItem.setSpecs("未知规格");
        vendorItem.setBarCode("aaaa");
        vendorItem.setOrigin("中国");
        vendorItem.setSupplyPprice(5555);
        vendorItem.setItemName("a");
        vendorItem.setItemCode("a");
        vendorItem.setExpiryTime(new Date());
        try {
            vendorItemService.insert(vendorItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(vendorItem.toString());
    }

    @Test
    public void testDelete() {
        try {
            vendorItemService.delete(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("delete success");
    }

    @Test
    public void testUpdate() {
        VendorItem vendorItem = null;
        try {
            vendorItem = vendorItemService.find(new Long(1));
            vendorItem.setItemCode("aaaaaaaaaaaaaaaaa");
            vendorItemService.update(vendorItem);
            System.out.println(vendorItem.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFind() {
        VendorItem vendorItem = null;
        try {
            vendorItem = vendorItemService.find(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(vendorItem.toString());
    }

    @Test
    public void testFindAndDeleteByVendorId() {
        List<VendorItem> vendorItemList = null;
        try {
            vendorItemList = vendorItemService.findByVendorId(new Long(1));
            System.out.println(vendorItemList.size());
            vendorItemService.deleteByVendorId(new Long(1));
            System.out.println("delete success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindBy() {
        VendorItem vendorItem = new VendorItem();
        vendorItem.setItemCode("a");
        List<VendorItem> vendorItemList = null;
        try {
            vendorItemList = vendorItemService.findBy(vendorItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (VendorItem i : vendorItemList) {
            System.out.println(i.toString());
        }
    }
}
