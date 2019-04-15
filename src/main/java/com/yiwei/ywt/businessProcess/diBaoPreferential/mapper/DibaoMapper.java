package com.yiwei.ywt.businessProcess.diBaoPreferential.mapper;

import com.yiwei.ywt.businessProcess.diBaoPreferential.model.DibaoInfo;
import com.yiwei.ywt.framework.dao.CRUDMapper;
import org.apache.ibatis.annotations.Mapper;
/**
 * </p>
 * @author czy
 * @version 1.0.0
 * @date 2019/4/15 16:37
 */
@Mapper
public interface DibaoMapper extends CRUDMapper<DibaoInfo> {
    DibaoInfo checkFamilyCode(String familyCode);

}
