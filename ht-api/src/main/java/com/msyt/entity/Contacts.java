package com.msyt.entity;

import lombok.Data;
import lombok.ToString;
import sun.java2d.loops.GeneralRenderer;

import java.io.Serializable;
import java.util.Date;


/**
 * @description: 联系人实体类
 * @author: Brian
 * @date: 2019-04-18
 */
@Data
@ToString
public class Contacts implements Serializable {

    /**
     * ID
     */
    private Long idx;

    /**
     * 版本号，乐观锁解决方案
     */
    private Long version;

    /**
     * 0：删除（软删除）， 1：可用 , 2: 未激活'
     */
    private Integer status;

    /**
     * 姓名
     */
    private String name;
    /**
     * 电话
     */
    private String phoneNum;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 供应商ID
     */
    private Long vendorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
