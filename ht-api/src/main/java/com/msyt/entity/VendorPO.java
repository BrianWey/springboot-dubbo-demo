package com.msyt.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Brian
 * @description: 采购单实体类
 * @date 2019/4/23
 */

@Data
@ToString
public class VendorPO implements Serializable {
    /**
     * ID
     */
    private Long idx;

    /**
     * 版本号，乐观锁解决方案
     */
    private Long version;

    /**
     * 供应商ID
     */
    private Long vendorId;

    /**
     * 商品部采购单ID
     */
    private Long poId;

    /**
     * 状态。待确认、待审核、已推送、已完成
     */
    private Integer status;

    /**
     * 采购商品种数
     */
    private Integer itemRangeCount;

    /**
     * 采购数量总和
     */
    private Integer itemTotal;

    /**
     * 采购商品总金额（根据汇率转成RMB）
     */
    private Integer totalMoney;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
