package com.msyt;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.msyt.entity.PurchaseOrder;
import com.msyt.service.PurchaseOrderService;
import com.msyt.utils.DemoUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @description:
 * @author: Brian
 * @date: 2019-04-23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PurchaseOrderTest {

    @Reference
    private PurchaseOrderService purchaseOrderService;

    @Test
    public void testFindAll() {
        try {
            List<PurchaseOrder> list = purchaseOrderService.findAll();
            for (PurchaseOrder i : list) {
                System.out.println(i.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() {
        String ss = "{\"poEntrysJson\": {\"status\": \"待确认\",\"chlidPoNum\": \"1\",\"itemTotal\": \"2\",\"totalMoney\": \"960\",\"poEntryIds\": \"12\"}}";
        JSONObject root = JSONObject.parseObject(ss);
        JSONObject poEntrysJson = root.getJSONObject("poEntrysJson");
        String s = poEntrysJson.getString("poEntryIds");
        PurchaseOrder purchaseOrder = JSONObject.toJavaObject(poEntrysJson, PurchaseOrder.class);
        List<String> poEntryIds = DemoUtils.stringToList(s);
        try {
            purchaseOrderService.saveAdd(purchaseOrder, poEntryIds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("======新增成功=======");
//        PurchaseOrder purchaseOrder = new PurchaseOrder();
//        purchaseOrder.setChlidPoNum(3);
//        purchaseOrder.setCreateTime(new Date());
//        purchaseOrder.setItemTotal(5);
//        purchaseOrder.setStatus("待审核");
//        purchaseOrder.setTotalMoney(new BigDecimal(100));
//        purchaseOrderService.insert(purchaseOrder);
//        System.out.println(purchaseOrder.toString());
    }

    @Test
    public void testDelete() {
        try {
            purchaseOrderService.delete(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("delete success");
    }

    @Test
    public void testUpdate() {
        PurchaseOrder purchaseOrder = null;
        try {
            purchaseOrder = purchaseOrderService.find(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        purchaseOrder.setStatus(1);
        try {
            purchaseOrderService.update(purchaseOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(purchaseOrder.toString());
    }

    @Test
    public void testFind() {
        PurchaseOrder purchaseOrder = null;
        try {
            purchaseOrder = purchaseOrderService.find(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(purchaseOrder.toString());
    }

    @Test
    public void testFindBy() {
        PurchaseOrder purchaseOrder  = new PurchaseOrder();
        purchaseOrder.setIdx(new Long(1));
        List<PurchaseOrder> purchaseOrderList = null;
        try {
            purchaseOrderList = purchaseOrderService.findBy(purchaseOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (PurchaseOrder i : purchaseOrderList) {
            System.out.println(i.toString());
        }
    }
}
