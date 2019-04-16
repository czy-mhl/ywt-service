/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SysUserBillController
 * Author:   XXXXXXX
 * Date:     2019/4/15 11:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.yiwei.ywt.waterCostBill.bill.contorller;

import com.yiwei.ywt.framework.web.AjaxResponse;
import com.yiwei.ywt.waterCostBill.bill.model.TUserBill;
import com.yiwei.ywt.waterCostBill.bill.service.SysBillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈根据UserId查询UserBill〉<br>
 * 〈〉
 *
 * @author 向珂
 * @create 2019/4/15
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class SysUserBillController {

    @Resource
    private SysBillService sysBillService;

    /**
     * 根据UserId查询UserBill  账单详情
     * @param userId
     * @return AjaxResponse
     */
    @RequestMapping(value = "/waterbill", method = RequestMethod.GET)
    public AjaxResponse userBill(@RequestBody @PathVariable("userId") Long userId) {
        try {
            List<TUserBill> userBills = this.sysBillService.findByUserId(userId);
            return null == userBills ? new AjaxResponse(AjaxResponse.FAILURE_SELECT_ENTITY,
                    "error") : AjaxResponse.success("ok",userBills);
        }
        catch(Exception e) {
            log.error("add SysMenu error!", e);
            return AjaxResponse.error("error", userId);
        }
    }

    /**
     * 根据mouthTotal查询UserBill
     * @param billMonth
     * @return AjaxResponse
     */
    @RequestMapping(value = "/billdetails/{billMonth}", method = RequestMethod.GET)
    public AjaxResponse userBill(@RequestBody @PathVariable("billMonth") String billMonth) {
        try {
            TUserBill userBill = this.sysBillService.findBybillMonth(billMonth);
            return null == userBill ? new AjaxResponse(AjaxResponse.FAILURE_SELECT_ENTITY,
                    "error") : AjaxResponse.success("ok",userBill);
        }
        catch(Exception e) {
            log.error("add SysMenu error!", e);
            return AjaxResponse.error("error", billMonth);
        }
    }

    /**
     * 根据TUserBill新增或更新记录
     * @param userBill
     * @return AjaxResponse
     */
    @RequestMapping(value = "/bill/add", method = RequestMethod.POST)
    public AjaxResponse userBill(@RequestBody TUserBill userBill) {
        try {
            sysBillService.insertByTUserBill(userBill);
            return null == userBill ? new AjaxResponse(AjaxResponse.FAILURE_SELECT_ENTITY,
                    "error") : AjaxResponse.success("ok",userBill);
        }
        catch(Exception e) {
            log.error("add SysMenu error!", e);
            return AjaxResponse.error("error", userBill);
        }
    }
}
