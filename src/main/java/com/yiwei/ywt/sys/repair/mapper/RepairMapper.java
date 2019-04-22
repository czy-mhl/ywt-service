package com.yiwei.ywt.sys.repair.mapper;

import com.yiwei.ywt.sys.repair.model.Repair;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RepairMapper {
    int insert(Repair record);
}