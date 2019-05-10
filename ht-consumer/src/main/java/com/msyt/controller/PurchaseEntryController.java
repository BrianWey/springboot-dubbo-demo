package com.msyt.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.msyt.utils.CommonResult;
import com.msyt.entity.PurchaseEntry;
import com.msyt.entity.PurchaseItem;
import com.msyt.service.PurchaseEntryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 采购子单控制器
 * @author: Brian
 * @date: 2019-04-23
 */
@RestController
public class PurchaseEntryController {

    @Reference
    private PurchaseEntryService purchaseEntryService;

    /**
     * 查询所有采购子单
     */
    @RequestMapping("/purchaseEntry/findAll")
    public String findAll() {
        CommonResult result = new CommonResult();
        try {
            result.setData(purchaseEntryService.findAll());
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }


    /**
     * 新增采购子单
     * param purchaseEntryJsonStr
     */
    @RequestMapping("/purchaseEntry/saveAdd")
    public String saveAdd(HttpServletRequest request, @RequestParam(required = true) String purchaseEntryJsonStr) {
        JSONObject jsonObject = JSONObject.parseObject(purchaseEntryJsonStr);

        // 子单对象
        JSONObject purchaseEntryJsonObj = jsonObject.getJSONObject("purchaseEntryJson");
        PurchaseEntry purchaseEntry = (PurchaseEntry) JSONObject.toJavaObject(purchaseEntryJsonObj, PurchaseEntry.class);

        // 子单对象中的购买的商品集
        JSONArray jsonArray = JSONArray.parseArray(purchaseEntryJsonObj.getString("purchaseItem"));
        List<PurchaseItem> purchaseItemList = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            PurchaseItem purchaseItem = (PurchaseItem) JSONObject.toJavaObject(jsonObject1, PurchaseItem.class);
            purchaseItemList.add(purchaseItem);
        }

        CommonResult result = new CommonResult();
        try {
            result.setData(purchaseEntryService.saveAdd(purchaseEntry, purchaseItemList));
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

}
