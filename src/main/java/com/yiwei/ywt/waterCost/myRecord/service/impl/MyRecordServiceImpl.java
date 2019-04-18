package com.yiwei.ywt.waterCost.myRecord.service.impl;

import com.yiwei.ywt.waterCost.myRecord.mapper.BillingInformationMapper;
import com.yiwei.ywt.waterCost.myRecord.mapper.MyRecordMapper;
import com.yiwei.ywt.waterCost.myRecord.model.BillingInformation;
import com.yiwei.ywt.waterCost.myRecord.model.MyRecordInfo;
import com.yiwei.ywt.waterCost.myRecord.service.MyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 我的档案
 * @author czy
 * @create 2019/4/18
 * @since 1.0.0
 */
@Service
public class MyRecordServiceImpl implements MyRecordService {

    @Autowired
    private MyRecordMapper myRecordMapper;
    @Autowired
    private BillingInformationMapper billingInformationMapper;
    /**
     * 根据户号获取我的档案
     * @param myRecordInfo
     * @return
     */
    public MyRecordInfo selectEntityByFamilyCode(MyRecordInfo myRecordInfo) throws RuntimeException{
        if (!StringUtils.isEmpty(myRecordInfo.getFamilyCode())) {
            MyRecordInfo myRecordInfo1 = this.myRecordMapper.gitEntityByFamilyCode(myRecordInfo);
            if(null != myRecordInfo1){
                BillingInformation billingInformation = new BillingInformation();
                billingInformation.setFamilyCode(myRecordInfo.getFamilyCode());
                myRecordInfo1.setBillingInformation(this.billingInformationMapper.selectEntityByFamilyCode(billingInformation));
            }
            return myRecordInfo1;
        }else {
            throw new RuntimeException("户号不存在或户号有误");
        }
    }

    /**
     * 根据户号修改开票信息
     * @param billingInformation
     * @return
     */
    public BillingInformation updateEntityByFamilyCode(BillingInformation billingInformation) {
        // todo 短信验证
        return 0<this.billingInformationMapper.update(billingInformation)?billingInformation:null;
    }
}
