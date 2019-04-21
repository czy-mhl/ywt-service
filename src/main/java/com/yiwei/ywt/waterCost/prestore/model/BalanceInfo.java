package com.yiwei.ywt.waterCost.prestore.model;

import com.yiwei.ywt.framework.model.BaseEntity;

import java.math.BigDecimal;

/**
 * @description: 余额信息 实体类
 * 数据库表：t_balance_info
 * @author: czy
 * @date: 2019-04-21 12:00
 * @version: 1.0.0
 */
public class BalanceInfo extends BaseEntity {

    /**
     * 户号
     */
    private String familyCode;
    /**
     * 存入
     */
    private BigDecimal income;
    /**
     * 支出
     */
    private BigDecimal disburse;
    /**
     * 余额
     */
    private BigDecimal balance;
}
