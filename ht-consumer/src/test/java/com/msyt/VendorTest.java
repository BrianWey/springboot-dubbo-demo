package com.msyt;

import com.alibaba.dubbo.config.annotation.Reference;
import com.msyt.entity.Contacts;
import com.msyt.entity.VendorEntity;
import com.msyt.entity.VendorItem;
import com.msyt.service.VendorItemService;
import com.msyt.service.VendorService;
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
 * @date: 2019-04-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorTest {

    @Reference
    private VendorService vendorService;
    @Reference
    private VendorItemService vendorItemService;

    @Test
    public void testFindAll() {
        try {
            List list = vendorService.findAll();
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() {
        VendorEntity vendorEntity = new VendorEntity();
        vendorEntity.setAddress("广东省广州市天河区xxx号");
        vendorEntity.setCountry("中国");
        vendorEntity.setCity("广州市");
        vendorEntity.setVendorName("供应商A");
        vendorEntity.setCreateTime(new Date());

        // add contacts
        List<Contacts> contactsList = new ArrayList();
        Contacts contacts1 = new Contacts();
        contacts1.setName("aaa");
        contacts1.setPhoneNum("13915324564");
        contacts1.setEmail("cdccc@qq.com");
        contacts1.setCreateTime(new Date());
        contactsList.add(contacts1);

        Contacts contacts2 = new Contacts();
        contacts2.setName("bbb");
        contacts2.setPhoneNum("13915321564");
        contacts2.setEmail("cdccdsc@qq.com");
        contacts2.setCreateTime(new Date());
        contactsList.add(contacts2);
        vendorEntity.setContactsList(contactsList);

        Long vendorId = null;
        try {
            vendorId = vendorService.insert(vendorEntity);
            if (vendorId != null) {
                // add item
                VendorItem vendorItem = new VendorItem();
                vendorItem.setItemCode("abc");
                vendorItem.setItemName("AADFSA");
                vendorItem.setSupplyPprice(5455);
                vendorItem.setStock(100);
                vendorItem.setCurrency("RMB");
                vendorItem.setShipDay(4);
                vendorItem.setCategory("category1");
                vendorItem.setBrand("brand1");
                vendorItem.setItemDesc("这件商品非常的不错");
                vendorItem.setVendorId(vendorId);
                vendorItem.setCreateTime(new Date());
                vendorItemService.insert(vendorItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testDelete() {
        try {
            vendorService.delete(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("delete success");
    }

    @Test
    public void testUpdate() {
        VendorEntity vendorEntity = null;
        try {
            vendorEntity = vendorService.find(new Long(1));
            vendorEntity.setVendorName("aaaaaaaaaaaaaaaaa");
            vendorService.update(vendorEntity);
            System.out.println(vendorEntity.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFind() {
        VendorEntity vendorEntity = null;
        try {
            vendorEntity = vendorService.find(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(vendorEntity.toString());
    }


    @Test
    public void testFindBy() {
        VendorEntity vendorEntity = new VendorEntity();
        vendorEntity.setVendorName("供应商A");
        List<VendorEntity> vendorEntityList = null;
        try {
            vendorEntityList = vendorService.findBy(vendorEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (VendorEntity i : vendorEntityList) {
            System.out.println(i.toString());
        }
    }
}
