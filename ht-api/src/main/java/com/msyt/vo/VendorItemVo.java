package com.msyt.vo;

import com.msyt.entity.Contacts;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian
 * @description: 供应商+商品
 * @date 2019/4/23
 */

@Data
@ToString
public class VendorItemVo implements Serializable {

    // =====================供应商==============================
    /**
     * 供应商ID
     */
    private Long vendorId;

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

    // =====================商品==============================

    /**
     * 商品ID
     */
    private Long itemId;

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

    // =====================联系人==============================
    /**
     * 联系人
     */
    private List<Contacts> contactsList = new ArrayList<Contacts>();

}
