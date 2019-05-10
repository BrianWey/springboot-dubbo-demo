package com.msyt.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.msyt.utils.CommonResult;
import com.msyt.entity.Contacts;
import com.msyt.service.ContactsService;
import com.msyt.utils.DemoUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @description: 联系人控制器
 * @author: Brian
 * @date: 2019-04-18
 */
@RestController
public class ContactsController {

    @Reference
    private ContactsService contactsService;

    /**
     * 查询所有联系人
     */
    @RequestMapping("/contacts/findAll")
    public String findAll() {
        CommonResult result = new CommonResult();
        try {
            List contactsList = contactsService.findAll();
            result.setData(contactsList);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 新增联系人
     */
    @RequestMapping("/contacts/saveAdd")
    public String saveAdd(HttpServletRequest request, @RequestParam(required = true) Long vendorId,
                          @RequestParam(required = true) String name, @RequestParam(required = true) String phoneNum,
                          @RequestParam(required = true) String email) {
        Contacts contacts = new Contacts();
        contacts.setName(name);
        contacts.setPhoneNum(phoneNum);
        contacts.setEmail(email);
        contacts.setVendorId(vendorId);
        contacts.setCreateTime(new Date());

        CommonResult result = new CommonResult();
        try {
            contactsService.insert(contacts);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 根据供应商id删除联系人
     */
    @RequestMapping("/contacts/delete")
    public String saveAdd(HttpServletRequest request, @RequestParam(required = true) Long vendorId) {
        CommonResult result = new CommonResult();
        try {
            contactsService.delete(vendorId);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 修改联系人信息
     */
    @RequestMapping("/contacts/saveEdit")
    public String saveEdit(HttpServletRequest request, Contacts contacts) {
        if (contacts.getIdx() == null) {
            return "联系人ID不能为空";
        }
        CommonResult result = new CommonResult();
        try {
            contactsService.update(contacts);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 根据供应商id查找联系人
     */
    @RequestMapping("/contacts/findByVendorId")
    public String findByVendorId(HttpServletRequest request, @RequestParam(required = true) Long vendorId) {
        CommonResult result = new CommonResult();
        try {
            List<Contacts> contactsList = contactsService.findByVendorId(vendorId);
            result.setData(contactsList);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 根据搜索条件查找联系人
     */
    @RequestMapping("/contacts/searchContacts")
    public String searchContacts(HttpServletRequest request, Contacts contacts) {
        CommonResult result = new CommonResult();
        try {
            List<Contacts> contactsList = contactsService.findBy(contacts);
            result.setData(contactsList);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

    /**
     * 批量删除联系人
     */
    @RequestMapping("/contacts/batchDelete")
    public String batchDelete(HttpServletRequest request, @RequestParam(required = true) String vendorIds) {
        if (StringUtils.isEmpty(vendorIds)) {
            return "vendorIds不能为空";
        }
        CommonResult result = new CommonResult();
        try {
            List<String> vendorIdList = DemoUtils.stringToList(vendorIds);
            contactsService.batchDelete(vendorIdList);
            result.setMessage(CommonResult.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getCause().getMessage());
        }
        return result.toString();
    }

}
