package com.yiwei.ywt.businessProcess.residentNew.controller;

import com.yiwei.ywt.businessProcess.residentNew.model.WaterApply;
import com.yiwei.ywt.framework.utils.ModelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 居民新装用水
 */
@RestController
@RequestMapping("/water")
@Slf4j
public class WaterApplyController {

    /**
     * 申请
     */
    @PostMapping("apply")
    public void getWaterApply(@RequestBody Map<String, String> map) {
        WaterApply waterApply = ModelUtil.map2Model(map, WaterApply.class);
        // todo 插入记录
    }
}
