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
public class PurchaseOrder implements Serializable {
    /**
     * 采购单ID
     */
    private Long idx;

    /**
     * 版本号，乐观锁解决方案
     */
    private Long version;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态。待确认、待审核、已推送、已完成
     */
    private Integer status;

    /**
     * 子单数
     */
    private Integer chlidPoNum;

    /**
     * 采购商品数量总和
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

    /**
     * 结束时间
     */
    private Date completeTime;

}
