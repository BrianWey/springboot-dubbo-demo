package com.msyt.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Brian
 * @description: 供应商关联商品实体类
 * @date 2019/4/20
 */
@Data
@ToString
public class VendorItem implements Serializable {
    /**
     * 商品ID
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
     * 货号
     */
    private String itemCode;

    /**
     * 商品名称
     */
    private String itemName;

    /**
     * 供货价
     */
    private Integer supplyPprice;

    /**
     * 可供库存
     */
    private Integer stock;

    /**
     * 币种
     */
    private String currency;

    /**
     * 运期
     */
    private Integer shipDay;

    /**
     * 类目
     */
    private String category;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 商品规格
     */
    private String specs;

    /**
     * 条形码
     */
    private String barCode;

    /**
     * 原产地
     */
    private String origin;

    /**
     * 商品描述
     */
    private String itemDesc;

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

    /**
     * 保质期
     */
    private Date expiryTime;
}
