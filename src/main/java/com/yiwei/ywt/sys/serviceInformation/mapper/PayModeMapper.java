package com.yiwei.ywt.sys.serviceInformation.mapper;

import com.yiwei.ywt.framework.dao.CRUDMapper;
import com.yiwei.ywt.sys.serviceInformation.model.PayMode;

import java.util.List;


public interface PayModeMapper extends CRUDMapper<PayMode> {
    List<PayMode> selectByTitle(String title);
}