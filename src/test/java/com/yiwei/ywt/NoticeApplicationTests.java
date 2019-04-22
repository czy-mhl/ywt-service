package com.yiwei.ywt;

import com.yiwei.ywt.sys.serviceInformation.mapper.NoticeMapper;
import com.yiwei.ywt.sys.serviceInformation.mapper.PayModeMapper;
import com.yiwei.ywt.sys.serviceInformation.model.Notice;
import com.yiwei.ywt.sys.serviceInformation.model.PayMode;
import com.yiwei.ywt.sys.serviceInformation.service.NoticeService;
import com.yiwei.ywt.sys.serviceInformation.service.PayModeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeApplicationTests {

    /**
     * 公告测试
     */
    @Resource
    private NoticeMapper noticeMapper;

    @Resource
    private NoticeService noticeService;

    /**
     * 公告查询
     */
    @Test
    public void select() {
        List<Notice> notices = noticeService.selectAll();
        for (Notice notice : notices) {
            System.out.println(notice.getCreateTime());
        }
    }
    /**
     * 公告插入
     */
    @Test
    public void insert() {
        Notice notice = new Notice();
        notice.setTitle("公告测试（4）（insert）");
        notice.setContent("测试内容（4）（insert）");

        noticeService.addEntity(notice);
    }
    /**
     * 公告修改
     */
    @Test
    public void update() {
        Notice notice = new Notice();
        notice.setId(3L);
        notice.setTitle("公告测试（1）（update）");
        noticeService.editEntity(notice);
    }
    /**
     * 公告删除
     */
    @Test
    public void delete() {
        noticeService.deleteEntity(4l);
    }
}
