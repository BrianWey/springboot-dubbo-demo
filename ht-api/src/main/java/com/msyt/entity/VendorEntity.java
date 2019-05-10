package com.msyt.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian
 * @description: 供应商实体类
 * @date 2019/4/20
 */

@Data
@ToString
public class VendorEntity implements Serializable {
    /**
     * 供应商ID
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
     * 供应商名称
     */
    private String vendorName;

    /**
     * 供应商地址
     */
    private String address;

    /**
     * 供应商所属国家
     */
    private String country;

    /**
     * 供应商所属城市
     */
    private String city;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    private List<Contacts> contactsList = new ArrayList<Contacts>();

}
