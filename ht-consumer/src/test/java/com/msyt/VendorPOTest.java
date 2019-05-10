package com.msyt;

import com.alibaba.dubbo.config.annotation.Reference;
import com.msyt.entity.VendorPO;
import com.msyt.service.PurchaseItemService;
import com.msyt.service.VendorPOService;
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
 * @date: 2019-04-23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorPOTest {

    @Reference
    private VendorPOService vendorPOService;
    @Reference
    private PurchaseItemService purchaseItemService;

    @Test
    public void testFindAll() {
        try {
            List<VendorPO> list = vendorPOService.findAll();
            for (VendorPO i : list) {
                System.out.println(i.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() {
        VendorPO vendorPO = new VendorPO();
        vendorPO.setVendorId(new Long(1));
        vendorPO.setItemRangeCount(3);
        vendorPO.setCreateTime(new Date());
        vendorPO.setItemTotal(5);
        vendorPO.setStatus(2);
        vendorPO.setTotalMoney(10000);
        try {
            vendorPOService.insert(vendorPO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(vendorPO.toString());
    }

    @Test
    public void testDelete() {
        try {
            vendorPOService.delete(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("delete success");
    }

    @Test
    public void testUpdate() {
        try {
            VendorPO vendorPO = vendorPOService.find(new Long(1));
            vendorPO.setStatus(1);
            vendorPOService.update(vendorPO);
            System.out.println(vendorPO.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFind() {
        VendorPO vendorPO = null;
        try {
            vendorPO = vendorPOService.find(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(vendorPO.toString());
    }

    @Test
    public void testFindBy() {
        VendorPO vendorPO = new VendorPO();
        vendorPO.setIdx(new Long(1));
        List<VendorPO> vendorPOList = null;
        try {
            vendorPOList = vendorPOService.findBy(vendorPO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (VendorPO i : vendorPOList) {
            System.out.println(i.toString());
        }
    }

    @Test
    public void testPublishVendor() {
        try {
            purchaseItemService.publishToVendor(new Long(52));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("推送结束");
    }
}
