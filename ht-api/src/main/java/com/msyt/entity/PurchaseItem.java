package com.msyt.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Brian
 * @description: 采购商品实体类
 * @date 2019/4/23
 */

@Data
@ToString
public class PurchaseItem implements Serializable {
    /**
     * 子单ID
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
     * 采购单ID
     */
    private Long poId;

    /**
     * 采购子单ID
     */
    private Long poEntryId;

    /**
     * 商品货号
     */
    private String itemCode;

    /**
     * 供应商ID
     */
    private Long vendorId;

    /**
     * 供应商名字
     */
    private String vendorName;

    /**
     * 可供库存
     */
    private Integer stock;

    /**
     * 商品描述
     */
    private String itemDesc;

    /**
     * 供货价
     */
    private Integer supplyPrice;

    /**
     * 币种
     */
    private String currency;

    /**
     * 汇率
     */
    private BigDecimal exchangeRate;

    /**
     * 采购价
     */
    private Integer purchasePrice;

    /**
     * 运期
     */
    private Integer shipDay;

    /**
     * 采购数量
     */
    private Integer purchaseCount;

    /**
     * 货运方式
     */
    private String shipType;

    /**
     * 联系人ID
     */
    private Long contactsId;

    /**
     * 信息。供应商有修改、供应商已确认、商品部已修改
     */
    private String msg;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
