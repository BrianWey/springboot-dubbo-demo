package com.msyt.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.msyt.utils.CommonResult;
import com.msyt.entity.PurchaseItem;
import com.msyt.service.PurchaseItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 采购子单商品控制器
 * @author: Brian
 * @date: 2019-04-23
 */
@RestController
public class PurchaseItemController {

    @Reference
    private PurchaseItemService purchaseItemService;

    /**
     * 查询所有采购子单商品
     */
    @RequestMapping("/poItem/findAll")
    public String findAll() {
        CommonResult result = new CommonResult();
        try {
            result.setData(JSON.toJSONString(purchaseItemService.findAll()));
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }


    /**
     * 删除采购子单商品
     */
    @RequestMapping("/poItem/delete")
    public String delete(HttpServletRequest request, @RequestParam(required = true) Long id) {
        CommonResult result = new CommonResult();
        try {
            result.setData("");
            purchaseItemService.delete(id);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 修改采购子单商品
     */
    @RequestMapping("/poItem/saveEdit")
    public String saveEdit(HttpServletRequest request, PurchaseItem purchaseItem) {
        CommonResult result = new CommonResult();
        try {
            purchaseItemService.update(purchaseItem);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 推送至供应商端
     */
    @RequestMapping("/poItem/publishToVendor")
    public String publishToVendor(HttpServletRequest request, @RequestParam(required = true) Long poId) {
        CommonResult result = new CommonResult();
        try {
            purchaseItemService.publishToVendor(poId);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

}
