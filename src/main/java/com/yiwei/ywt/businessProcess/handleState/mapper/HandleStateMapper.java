package com.yiwei.ywt.businessProcess.handleState.mapper;

import com.yiwei.ywt.businessProcess.handleState.model.HandleState;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HandleStateMapper extends CRUDMapper<HandleState> {
    int insertSelective(HandleState handleState);

    List<HandleState> selectByApplyMobile(String applyMobile);

    List<HandleState> selectByFamilyNumber(String familyNumber);

    int updateByPrimaryKeySelective(HandleState handleState);
}