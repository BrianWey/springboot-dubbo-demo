package com.msyt.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.msyt.utils.CommonResult;
import com.msyt.entity.VendorItem;
import com.msyt.service.VendorItemService;
import com.msyt.utils.DemoUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 商品控制器
 * @author: Brian
 * @date: 2019-04-22
 */
@RestController
public class VendorItemController {

    @Reference
    private VendorItemService vendorItemService;

    /**
     * 查询所有商品
     */
    @RequestMapping("/vendorItem/findAll")
    public String findAll() {
        CommonResult result = new CommonResult();
        try {
            result.setData(vendorItemService.findAll());
            result.setCode(1);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 新增商品
     */
    @RequestMapping("/vendorItem/saveAdd")
    public String saveAdd(HttpServletRequest request, VendorItem vendorItem) {
        CommonResult result = new CommonResult();
        try {
            result.setData("");
            vendorItemService.insert(vendorItem);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 删除商品
     */
    @RequestMapping("/vendorItem/delete")
    public String delete(HttpServletRequest request, @RequestParam(required = true) Long vendorId) {
        CommonResult result = new CommonResult();
        try {
            vendorItemService.delete(vendorId);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 修改商品
     */
    @RequestMapping("/vendorItem/saveEdit")
    public String saveEdit(HttpServletRequest request, VendorItem vendorItem) {
        if (vendorItem.getIdx() == null) {
            return "商品ID不能为空";
        }

        CommonResult result = new CommonResult();
        try {
            vendorItemService.update(vendorItem);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 根据搜索条件查找商品
     */
    @RequestMapping("/vendorItem/searchVendor")
    public String searchVendor(HttpServletRequest request, VendorItem vendorItem) {
        CommonResult result = new CommonResult();
        try {
            result.setData(vendorItemService.findBy(vendorItem));
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 根据商品ID搜索查找供应商+商品集
     */
    @RequestMapping("/vendorItem/findByItemIds")
    public String findByItemIds(HttpServletRequest request, @RequestParam(required = true) String itemIds) {
        if (StringUtils.isEmpty(itemIds)) {
            return "商品ID集不能为空";
        }

        CommonResult result = new CommonResult();
        try {
            result.setData(vendorItemService.findByItemIds(DemoUtils.stringToList(itemIds)));
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

}
