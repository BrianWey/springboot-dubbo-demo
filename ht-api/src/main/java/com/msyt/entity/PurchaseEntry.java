package com.msyt.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian
 * @description: 采购子单实体类
 * @date 2019/4/23
 */

@Data
@ToString
public class PurchaseEntry implements Serializable {
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
     * 采购子单ID
     */
    private Long poId;

    /**
     * 类目
     */
    private String category;

    /**
     * 商品货号
     */
    private String itemCode;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 商品描述
     */
    private String itemDesc;

    /**
     * 条形码
     */
    private String barCode;

    /**
     * 供应商数量
     */
    private Integer vendorCount;

    /**
     * 距采购需求数量
     */
    private Integer dValue;

    /**
     * 平均采购价
     */
    private Integer avgPurchasePrice;

    /**
     * 总运期
     */
    private Integer totalShipDay;

    /**
     * 采购总数
     */
    private Integer totalPurchaseCount;

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

    List<PurchaseItem> purchaseItemList = new ArrayList<PurchaseItem>();

}
