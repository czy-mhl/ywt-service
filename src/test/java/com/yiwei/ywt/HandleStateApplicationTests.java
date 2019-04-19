package com.yiwei.ywt;

import com.yiwei.ywt.businessProcess.handleState.mapper.HandleStateMapper;
import com.yiwei.ywt.businessProcess.handleState.model.HandleState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HandleStateApplicationTests {

    @Resource
    private HandleStateMapper handleStateMapper;

    /**
     * 办理进度查询
     */
    @Test
    public void select() {
        List<HandleState> handleStates = handleStateMapper.selectByApplyMobile("申请人联系方式");
        for (HandleState handleState : handleStates) {
            System.out.println(handleState);
        }
    }
    /**
     * 办理进度插入
     */
    @Test
    @Transactional(rollbackFor = Exception.class)
    public void insert() {
        HandleState handleState = new HandleState();
        handleState.setFamilyNumber("户号");
        handleState.setBusinessName("业务类型（名）");
        handleState.setBusinessState(0);
        handleState.setApplyName("申请人姓名");
        handleState.setApplyMobile("申请人联系方式");
        handleStateMapper.insert(handleState);
    }
    /**
     * 办理进度修改
     */
    @Test
    @Transactional(rollbackFor = Exception.class)
    public void update() {
        List<HandleState> handleStates = handleStateMapper.selectByApplyMobile("申请人联系方式");
        for (HandleState handleState : handleStates) {
            handleState.setBusinessState(2);
            System.out.println(handleState);
            System.out.println(handleStateMapper.update(handleState));
        }

    }
}
