package com.msyt.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.msyt.utils.CommonResult;
import com.msyt.entity.Contacts;
import com.msyt.entity.VendorEntity;
import com.msyt.service.VendorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 供应商控制器
 * @author: Brian
 * @date: 2019-04-20
 */
@RestController
public class VendorController {

    @Reference
    private VendorService vendorService;


    /**
     * 查询所有供应商
     */
    @RequestMapping("/vendor/findAll")
    public String findAll() {
        CommonResult result = new CommonResult();
        try {
            result.setData(vendorService.findAll());
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 新增供应商
     */
    @RequestMapping("/vendor/saveAdd")
    public String saveAdd(HttpServletRequest request, VendorEntity vendorEntity) {
        String contactsStr = request.getParameter("contacts");
        JSONArray jsonArray = JSONArray.parseArray(contactsStr);
        List<Contacts> contactsList = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Contacts contacts = (Contacts) JSONObject.toJavaObject(jsonObject, Contacts.class);
            contactsList.add(contacts);
        }
        vendorEntity.setContactsList(contactsList);

        CommonResult result = new CommonResult();
        try {
            vendorService.insert(vendorEntity);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 删除供应商
     */
    @RequestMapping("/vendor/delete")
    public String delete(HttpServletRequest request, @RequestParam(required = true) Long vendorId) {
        CommonResult result = new CommonResult();
        try {
            vendorService.delete(vendorId);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 修改供应商
     */
    @RequestMapping("/vendor/saveEdit")
    public String saveEdit(HttpServletRequest request, VendorEntity vendorEntity) {
        if (vendorEntity.getIdx() == null) {
            return "供应商不能为空";
        }

        CommonResult result = new CommonResult();
        try {
            vendorService.update(vendorEntity);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 根据搜索条件查找供应商
     */
    @RequestMapping("/vendor/searchVendor")
    public String searchVendor(HttpServletRequest request, VendorEntity vendorEntity) {
        CommonResult result = new CommonResult();
        try {
            List<VendorEntity> vendorList = vendorService.findBy(vendorEntity);
            result.setData(vendorList);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

}
