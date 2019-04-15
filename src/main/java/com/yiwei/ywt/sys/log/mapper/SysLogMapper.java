package com.yiwei.ywt.sys.log.mapper;


import com.yiwei.ywt.framework.dao.CRUDMapper;
import com.yiwei.ywt.sys.log.model.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created :czy
 * date:2019/04/15/16:56
 * annotation:SysLogMapper dao层接口
 * table:
 */
@Mapper
public interface SysLogMapper extends CRUDMapper<SysLog> {
    Long getLogById(@Param("id") Long id);

}
