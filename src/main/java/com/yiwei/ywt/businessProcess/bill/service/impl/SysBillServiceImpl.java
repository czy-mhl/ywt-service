/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SysBillServiceImpl
 * Author:   XXXXXXX
 * Date:     2019/4/15 9:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.yiwei.ywt.businessProcess.bill.service.impl;

import com.yiwei.ywt.businessProcess.bill.dao.TUserBillMapper;
import com.yiwei.ywt.businessProcess.bill.model.TUserBill;
import com.yiwei.ywt.businessProcess.bill.service.SysBillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈根据UserID查询UserBill〉<br>
 * 〈〉
 *
 * @author XXXXXXX
 * @create 2019/4/15
 * @since 1.0.0
 */
@Service
public class SysBillServiceImpl implements SysBillService {

    @Resource
    private TUserBillMapper tUserBillMapper;

    /**
     * 根据userID查询userBill
     *
     * @param userId
     * @return
     */
//    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<TUserBill> findByUserId(Long userId) {
        return tUserBillMapper.selectByUserId(userId);
    }

    /**
     * 根据billMonth查询userBill
     *
     * @param billMonth
     * @return
     */
    @Override
    public TUserBill findBybillMonth(String billMonth) {
        return tUserBillMapper.selectBybillMonth(billMonth);
    }

    /**
     * 根据TUserBill新增,若主键存在则更新
     *
     * @param userBill
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int insertByTUserBill(TUserBill userBill) {
        if (userBill != null) {
            //提取当月账单总额
            Double sum = userBill.getWaterRates() +
                    userBill.getSewageCharge() +
                    userBill.getGarbageCharge() +
                    userBill.getPenalty();
            //存入当月账单总额
            userBill.setMouthTotal(sum);

            //判断用水量、非居名污水费单价、当月污水费总额是否为空
            if (userBill.getNonResidentPrice() == null || userBill.getWaterConsumption() == null ||
                    userBill.getSewageCharge() == null) {

                if (userBill.getWaterConsumption() != null && userBill.getNonResidentPrice() != null) {
                    //判断当月非居民污水费单价和当月用水量是否为空
                    double sewageCharge = userBill.getWaterConsumption() * userBill.getNonResidentPrice();
                    //不为空则计算出当月污水费总额，存入更新
                    userBill.setSewageCharge(sewageCharge);
                } else if (userBill.getWaterConsumption() != null && userBill.getSewageCharge() != null) {
                    //判断当月非居民污水费总额和当月用水量是否为空
                    double nonResidentPrice = userBill.getSewageCharge() / userBill.getWaterConsumption();
                    //不为空则计算出非居民污水费单价，存入更新
                    userBill.setNonResidentPrice(nonResidentPrice);
                } else if (userBill.getNonResidentPrice() != null && userBill.getSewageCharge() != null) {
                    //判断当月非居民污水费单价和当月污水费总额是否为空
                    double waterConsumption = userBill.getSewageCharge() / userBill.getNonResidentPrice();
                    //不为空则计算出用水量，存入更新
                    userBill.setWaterConsumption((long) waterConsumption);
                }
            }else {
                //如果都不为空
                //算出污水费总额
                double sewageCharge = userBill.getWaterConsumption() * userBill.getNonResidentPrice();
                //如果污水费总额不相等，则更新为最新状态。
                if(userBill.getSewageCharge() != sewageCharge){
                    userBill.setSewageCharge(sewageCharge);
                }

                //算出非居名污水费单价
                double nonResidentPrice = userBill.getSewageCharge() / userBill.getWaterConsumption();
                //如果非居名污水费单价不相等，则更新为最新状态。
                if(userBill.getNonResidentPrice() != nonResidentPrice){
                    userBill.setNonResidentPrice(nonResidentPrice);
                }

                //算出用水量
                double waterConsumption = userBill.getSewageCharge() / userBill.getNonResidentPrice();
                //如果用水量不相等，则更新为最新状态。
                if(userBill.getWaterConsumption() != waterConsumption){
                    userBill.setWaterConsumption((long) waterConsumption);
                }

            }

            //判断用水量、工商用水单价、自来水费是否为空
            if (userBill.getBusinessCirclesPrice() == null || userBill.getWaterConsumption() == null ||
                    userBill.getWaterRates() == null) {
                if (userBill.getWaterRates() != null && userBill.getWaterConsumption() != null) {
                    //判断当月自来水费总额和当月用水量是否为空
                    double businessCirclesPrice = userBill.getWaterRates() / userBill.getWaterConsumption();
                    //不为空则计算出工商用水单价，存入更新
                    userBill.setBusinessCirclesPrice(businessCirclesPrice);
                }

                if (userBill.getBusinessCirclesPrice() != null && userBill.getWaterRates() != null) {
                    //判断当月工商用水单价和当月自来水费是否为空
                    double waterConsumption = userBill.getWaterRates() / userBill.getBusinessCirclesPrice();
                    //不为空则计算出用水量，存入更新
                    userBill.setWaterConsumption((long) waterConsumption);
                }

                if (userBill.getWaterConsumption() != null && userBill.getBusinessCirclesPrice() != null) {
                    //判断当月工商用水单价和当月用水量是否为空
                    double waterRates = userBill.getWaterConsumption() * userBill.getBusinessCirclesPrice();
                    //不为空则计算出自来水费，存入更新
                    userBill.setWaterRates(waterRates);
                }
            }else {
                //如果都不为空
                //算出自来水费
                double waterRates = userBill.getWaterConsumption() * userBill.getBusinessCirclesPrice();
                //如果自来水费不相等，则更新为最新状态。
                if(userBill.getWaterRates() != waterRates){
                    userBill.setWaterRates(waterRates);
                }

                //算出工商用水单价
                double businessCirclesPrice = userBill.getWaterRates() / userBill.getWaterConsumption();
                //如果工商用水单价不相等，则更新为最新状态。
                if(userBill.getBusinessCirclesPrice() != businessCirclesPrice){
                    userBill.setBusinessCirclesPrice(businessCirclesPrice);
                }

                //算出用水量
                double waterConsumption = userBill.getWaterRates() / userBill.getBusinessCirclesPrice();
                //如果用水量不相等，则更新为最新状态。
                if(userBill.getWaterConsumption() != waterConsumption){
                    userBill.setWaterConsumption((long) waterConsumption);
                }

            }

        }
        //更新记录
        return tUserBillMapper.insertUserBill(userBill);
    }
}
