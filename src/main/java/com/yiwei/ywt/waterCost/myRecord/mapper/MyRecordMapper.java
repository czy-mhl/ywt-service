package com.yiwei.ywt.waterCost.myRecord.mapper;


import com.yiwei.ywt.framework.dao.CRUDMapper;
import com.yiwei.ywt.waterCost.myRecord.model.MyRecordInfo;
import org.apache.ibatis.annotations.Mapper;
/**
 * 我的档案
 * @author czy
 * @create 2019/4/18
 * @since 1.0.0
 */
@Mapper
public interface MyRecordMapper extends CRUDMapper<MyRecordInfo> {
     MyRecordInfo gitEntityByFamilyCode(MyRecordInfo myRecordInfo);
}