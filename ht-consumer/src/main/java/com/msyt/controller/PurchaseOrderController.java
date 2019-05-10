package com.msyt.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.msyt.utils.CommonResult;
import com.msyt.entity.PurchaseOrder;
import com.msyt.service.PurchaseOrderService;
import com.msyt.utils.DemoUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description: 采购单控制器
 * @author: Brian
 * @date: 2019-04-23
 */
@RestController
public class PurchaseOrderController {

    @Reference
    private PurchaseOrderService purchaseOrderService;

    /**
     * 查询所有采购单
     */
    @RequestMapping("/po/findAll")
    public String findAll() {
        CommonResult result = new CommonResult();
        try {
            result.setData(purchaseOrderService.findAll());
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 删除采购单
     */
    @RequestMapping("/po/delete")
    public String delete(HttpServletRequest request, @RequestParam(required = true) Long id) {
        CommonResult result = new CommonResult();
        try {
            purchaseOrderService.delete(id);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 根据搜索条件查找采购单
     */
    @RequestMapping("/po/searchVendor")
    public String searchVendor(HttpServletRequest request, PurchaseOrder purchaseOrder) {
        CommonResult result = new CommonResult();
        try {
            result.setData(purchaseOrderService.findBy(purchaseOrder));
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 新增采购单
     */
    @RequestMapping("/po/saveAdd")
    public String saveAdd(HttpServletRequest request, @RequestParam(required = true) String poEntrysJsonStr) {
        JSONObject root = JSONObject.parseObject(poEntrysJsonStr);
        JSONObject poEntrysJson = root.getJSONObject("poEntrysJson");
        PurchaseOrder purchaseOrder = JSONObject.toJavaObject(poEntrysJson, PurchaseOrder.class);
        String s = poEntrysJson.getString("poEntryIds");
        List<String> poEntryIds = DemoUtils.stringToList(s);

        CommonResult result = new CommonResult();
        try {
            purchaseOrderService.saveAdd(purchaseOrder, poEntryIds);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

}
