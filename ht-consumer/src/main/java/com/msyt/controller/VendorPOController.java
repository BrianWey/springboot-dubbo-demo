package com.msyt.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.msyt.utils.CommonResult;
import com.msyt.entity.PurchaseItem;
import com.msyt.entity.VendorPO;
import com.msyt.service.PurchaseItemService;
import com.msyt.service.PurchaseOrderService;
import com.msyt.service.VendorPOService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 供应商采购单控制器
 * @author: Brian
 * @date: 2019-04-23
 */
@RestController
public class VendorPOController {

    @Reference
    private VendorPOService vendorPOService;
    @Reference
    private PurchaseItemService purchaseItemService;
    @Reference
    private PurchaseOrderService purchaseOrderService;

    /**
     * 查询所有供应商采购单
     */
    @RequestMapping("/vendorPO/findAll")
    public String findAll() {
        CommonResult result = new CommonResult();
        try {
            result.setData(vendorPOService.findAll());
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 删除供应商采购单
     */
    @RequestMapping("/vendorPO/delete")
    public String delete(HttpServletRequest request, @RequestParam(required = true) Long id) {
        CommonResult result = new CommonResult();
        try {
            vendorPOService.delete(id);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 修改供应商采购单
     */
    @RequestMapping("/vendorPO/edit")
    public String update(HttpServletRequest request, @RequestParam(required = true) VendorPO vendorPO) {
        CommonResult result = new CommonResult();
        try {
            vendorPOService.update(vendorPO);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 根据搜索条件查找供应商采购单
     */
    @RequestMapping("/vendorPO/searchVendorPO")
    public String searchVendor(HttpServletRequest request, VendorPO vendorPO) {
        CommonResult result = new CommonResult();
        try {
            result.setData(vendorPOService.findBy(vendorPO));
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 供应商端确认后推送至商品采购部
     */
    @RequestMapping("/vendorPO/publishTo")
    public String publishTo(HttpServletRequest request, @RequestParam(required = true) Long poId) {
        CommonResult result = new CommonResult();
        try {
            vendorPOService.publishTo(poId);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();

    }

    /**
     * 供应商端修改商品信息
     */
    @RequestMapping("/vendorPO/updateItem")
    public String updateItem(HttpServletRequest request, PurchaseItem purchaseItem) {
        CommonResult result = new CommonResult();
        try {
            purchaseItem.setMsg("供应商已修改");
            purchaseItemService.update(purchaseItem);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

}
