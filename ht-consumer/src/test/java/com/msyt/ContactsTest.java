package com.msyt;

import com.msyt.entity.Contacts;
import com.msyt.service.ContactsService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class ContactsTest {

    @Reference
    private ContactsService contactsService;

    @Test
    public void testFindAll() {
        try {
            List list = contactsService.findAll();
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() {
        Contacts contacts = new Contacts();
        contacts.setName("lisi");
        contacts.setPhoneNum("13915324565");
        contacts.setEmail("ccc@qq.com");
        contacts.setVendorId(new Long(1211));
        contacts.setCreateTime(new Date());
        try {
            contactsService.insert(contacts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(contacts.toString());
    }

    @Test
    public void testDelete() {
        try {
            contactsService.delete(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("delete success");
    }

    @Test
    public void testUpdate() {
        Contacts contacts = null;
        try {
            contacts = contactsService.find(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        contacts.setName("zs");
        contacts.setPhoneNum("13915324565");
        contacts.setEmail("ccc@qq.com");
        contacts.setVendorId(new Long(1211));
        contacts.setCreateTime(new Date());
        try {
            contactsService.update(contacts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(contacts.toString());
    }

    @Test
    public void testFind() {
        Contacts contacts = null;
        try {
            contacts = contactsService.find(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(contacts.toString());
    }

    @Test
    public void testBatchAdd() {
        List<Contacts> contactsList = new ArrayList();
        Contacts contacts1 = new Contacts();
        contacts1.setName("aaa");
        contacts1.setPhoneNum("13915324564");
        contacts1.setEmail("cdccc@qq.com");
        contacts1.setCreateTime(new Date());
        contacts1.setVendorId(new Long(1));
        contactsList.add(contacts1);

        Contacts contacts2 = new Contacts();
        contacts2.setName("bbb");
        contacts2.setPhoneNum("13915321564");
        contacts2.setEmail("cdccdsc@qq.com");
        contacts2.setCreateTime(new Date());
        contacts1.setVendorId(new Long(1));
        contactsList.add(contacts2);
        try {
            contactsService.batchAdd(contactsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAndDeleteByVendorId() {
        List<Contacts> vendorItemList = null;
        try {
            vendorItemList = contactsService.findByVendorId(new Long(1));
            System.out.println(vendorItemList.size());
            contactsService.deleteByVendorId(new Long(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("delete success");
    }

    @Test
    public void testFindBy() {
        Contacts contacts = new Contacts();
        contacts.setName("aaa");
        List<Contacts> contactsList = null;
        try {
            contactsList = contactsService.findBy(contacts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Contacts contacts1 : contactsList) {
            System.out.println(contacts1.toString());
        }
    }

    @Test
    public void testBatchDelete() {
        List<String> list = new ArrayList<>();
        list.add("0");
        try {
            contactsService.batchDelete(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("batch delete finished!");
    }
}
