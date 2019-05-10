package com.msyt;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.msyt.entity.PurchaseEntry;
import com.msyt.entity.PurchaseItem;
import com.msyt.service.PurchaseEntryService;
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
public class PurchaseEntryTest {

    @Reference
    private PurchaseEntryService purchaseEntryService;

    @Test
    public void testFindAll() {
        try {
            List<PurchaseEntry> list = purchaseEntryService.findAll();
            for (PurchaseEntry i : list) {
                System.out.println(i.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() {
//        PurchaseEntry purchaseEntry1 = new PurchaseEntry();
//        purchaseEntry1.setAvgPurchasePrice(new BigDecimal(11.11));
//        purchaseEntry1.setBarCode("saasd");
//        purchaseEntry1.setBrand("aaa");
//        purchaseEntry1.setCategory("aaa");
//        purchaseEntry1.setCreateTime(new Date());
//        purchaseEntry1.setDValue(2);
//        purchaseEntry1.setItemCode("aaa");
//        purchaseEntry1.setItemDesc("asda");
//        purchaseEntry1.setPoId(1);
//        purchaseEntry1.setMsg("aaaa");
//        purchaseEntry1.setTotalPurchaseCount(1);
//        purchaseEntry1.setTotalShipDay(2);
//        purchaseEntry1.setVendorCount(3);
//        purchaseEntryService.insert(purchaseEntry1);
//        System.out.println(purchaseEntry1.toString());
        String s = "{\"purchaseEntryJson\": {\"poId\": null,\"category\": \"category1\",\"itemCode\": \"1001\",\"brand\": \"brand1\",\"itemDesc\": \"非常的不错\",\"barCode\": \"barcode001\",\"vendorCount\":\"2\",\"dValue\":\"40\",\"avgPurchasePrice\": 16,\"totalShipDay\":\"5\",\"totalPurchaseCount\": 100,\"createTime\":\"2019-04-24 12:00:00\",\"purchaseItem\":[{\"poEntryId\":null,\"itemCode\": \"1001\",\"vendorId\": 1,\"vendorName\": \"供应商A\",\"stock\": 100,\"itemDesc\": \"非常的不错\",\"supplyPprice\": 15,\"currency\": \"RMB\",\"exchangeRate\": 1.0,\"purchasePrice\": 15,\"shipDay\":\"2\",\"purchaseCount\":\"30\",\"shipType\":\"空运\",\"contactsId\": 1},{\"poEntryId\":null,\"itemCode\": \"1001\",\"vendorId\": 2,\"vendorName\": \"供应商B\",\"stock\": 200,\"itemDesc\": \"非常的不错\",\"supplyPprice\": 17,\"currency\": \"RMB\",\"exchangeRate\": 1.0,\"purchasePrice\": 17,\"shipDay\":\"3\",\"purchaseCount\":\"30\",\"shipType\":\"海运\",\"contactsId\": 3}]}}";
        JSONObject a = JSONObject.parseObject(s);
        List<PurchaseItem> list = new ArrayList<>();
        JSONObject b = a.getJSONObject("purchaseEntryJson");
        JSONArray c = JSONArray.parseArray(b.getString("purchaseItem"));
        for (int i = 0; i < c.size(); i++) {
            JSONObject d = c.getJSONObject(i);
            System.out.println();
            PurchaseItem purchaseItem = (PurchaseItem) JSONObject.toJavaObject(d, PurchaseItem.class);
            list.add(purchaseItem);
        }
        PurchaseEntry purchaseEntry = (PurchaseEntry) JSONObject.toJavaObject(b, PurchaseEntry.class);
        JSONObject json = null;
        try {
            json = (JSONObject) JSONObject.toJSON(purchaseEntryService.saveAdd(purchaseEntry, list));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(json.toString());
    }

    @Test
    public void testDelete() {
        try {
            purchaseEntryService.delete(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("delete success");
    }

    @Test
    public void testUpdate() {
        PurchaseEntry purchaseItem = null;
        try {
            purchaseItem = purchaseEntryService.find(new Long(1));
            purchaseItem.setItemCode("BBB");
            purchaseEntryService.update(purchaseItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(purchaseItem.toString());
    }

    @Test
    public void testFind() {
        PurchaseEntry purchaseItem = null;
        try {
            purchaseItem = purchaseEntryService.find(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(purchaseItem.toString());
    }

    @Test
    public void testFindBy() {
        PurchaseEntry purchaseItem = new PurchaseEntry();
        purchaseItem.setIdx(new Long(1));
        List<PurchaseEntry> purchaseOrderList = null;
        try {
            purchaseOrderList = purchaseEntryService.findBy(purchaseItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (PurchaseEntry i : purchaseOrderList) {
            System.out.println(i.toString());
        }
    }

    @Test
    public void testBatchAdd() {
        List<PurchaseEntry> purchaseEntryList = new ArrayList<>();

        PurchaseEntry purchaseEntry1 = new PurchaseEntry();
        purchaseEntry1.setAvgPurchasePrice(1111);
        purchaseEntry1.setBarCode("saasd");
        purchaseEntry1.setBrand("aaa");
        purchaseEntry1.setCategory("aaa");
        purchaseEntry1.setCreateTime(new Date());
        purchaseEntry1.setDValue(2);
        purchaseEntry1.setItemCode("aaa");
        purchaseEntry1.setItemDesc("asda");
        purchaseEntry1.setPoId(new Long(1));
        purchaseEntry1.setMsg("aaaa");
        purchaseEntry1.setTotalPurchaseCount(1);
        purchaseEntry1.setTotalShipDay(2);
        purchaseEntry1.setVendorCount(3);
        purchaseEntryList.add(purchaseEntry1);

        PurchaseEntry purchaseEntry2 = new PurchaseEntry();
        purchaseEntry2.setAvgPurchasePrice(1111);
        purchaseEntry2.setBarCode("saasd");
        purchaseEntry2.setBrand("aaa");
        purchaseEntry2.setCategory("aaa");
        purchaseEntry2.setCreateTime(new Date());
        purchaseEntry2.setDValue(2);
        purchaseEntry2.setItemCode("aaa");
        purchaseEntry2.setItemDesc("asda");
        purchaseEntry2.setPoId(new Long(1));
        purchaseEntry2.setMsg("aaaa");
        purchaseEntry2.setTotalPurchaseCount(1);
        purchaseEntry2.setTotalShipDay(2);
        purchaseEntry2.setVendorCount(3);
        purchaseEntryList.add(purchaseEntry2);

        try {
            purchaseEntryService.batchAdd(purchaseEntryList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (PurchaseEntry purchaseEntry : purchaseEntryList) {
            System.out.println(purchaseEntry.toString());
        }
    }
}
